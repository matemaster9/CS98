package cs.matemaster.web.service.impl;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cs.matemaster.web.common.model.dto.GlobalCompanyDto;
import cs.matemaster.web.common.model.vo.Global500VO;
import cs.matemaster.web.common.model.vo.GlobalCompanyVO;
import cs.matemaster.web.mapper.GlobalCompanyInsertMapper;
import cs.matemaster.web.mapper.GlobalCompanyQueryMapper;
import cs.matemaster.web.service.OfficeService;
import cs.matemaster.web.util.ExcelUtil;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MateMaster
 * @since 2022/8/18
 */
@Service
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final GlobalCompanyQueryMapper globalCompanyQueryMapper;
    private final GlobalCompanyInsertMapper globalCompanyInsertMapper;

    @Override
    public Boolean saveGlobalCompanyList(MultipartFile file) {
        List<GlobalCompanyDto> globalCompanyList = ExcelUtil.convertExcel2JavaObject(file, GlobalCompanyDto.class, 0, 1);
        int count = 0;
        if (CollectionUtils.isNotEmpty(globalCompanyList)) {
            count = globalCompanyInsertMapper.batchInsertGlobalCom(globalCompanyList);
        }
        return globalCompanyList.size() == count;
    }

    @Override
    public Global500VO getGlobalCompanyList(Integer year) {
        List<GlobalCompanyVO> globalCompanyVOS = globalCompanyQueryMapper.getGlobalCompanyListByYear(year);
        var global500 = new Global500VO();
        global500.setYear(year);
        global500.setGlobalCompanyList(globalCompanyVOS);
        return global500;
    }

    @Override
    public void exportGlobal500(Integer year) {
        Global500VO global500 = getGlobalCompanyList(year);
        if (CollectionUtils.isEmpty(global500.getGlobalCompanyList())) {
            return;
        }

        List<ExcelExportEntity> column = new ArrayList<>();
        column.add(new ExcelExportEntity("世界排名", "comRank"));
        column.add(new ExcelExportEntity("公司名称", "companyName"));
        column.add(new ExcelExportEntity("营业收入", "income"));
        column.add(new ExcelExportEntity("利润", "profit"));
        column.add(new ExcelExportEntity("所属国家", "country"));

        List<GlobalCompanyVO> globalCompanyList = global500.getGlobalCompanyList();
        List<Map<String, Object>> data = new ArrayList<>();
        for (GlobalCompanyVO company : globalCompanyList) {
            Map<String, Object> map = new HashMap<>();
            map.put("comRank", company.getComRank());
            map.put("companyName", company.getCompanyName());
            map.put("income", company.getIncome());
            map.put("profit", company.getProfit());
            map.put("country", company.getCountry());
            data.add(map);
        }

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS"));
        String fileName = StringUtils.joinWith("-", "全球500强", year.toString(), now);

        ExcelUtil.export2WebFront(fileName, column, data);
    }
}

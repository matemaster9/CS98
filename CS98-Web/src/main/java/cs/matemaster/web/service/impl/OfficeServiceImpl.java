package cs.matemaster.web.service.impl;

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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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
        List<GlobalCompanyDto> globalCompanyList = ExcelUtil.getMapping(file, GlobalCompanyDto.class, 0, 1);
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
}

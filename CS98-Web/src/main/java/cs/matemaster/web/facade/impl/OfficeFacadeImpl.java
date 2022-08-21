package cs.matemaster.web.facade.impl;

import cs.matemaster.web.common.model.vo.Global500VO;
import cs.matemaster.web.common.webcore.WebLogger;
import cs.matemaster.web.facade.OfficeFacade;
import cs.matemaster.web.service.OfficeService;
import cs.matemaster.web.util.ExcelUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author MateMaster
 * @since 2022/8/18
 */
@Component
@RequiredArgsConstructor
public class OfficeFacadeImpl implements OfficeFacade {

    private final OfficeService officeService;

    @Override
    public Boolean uploadGlobalCompanyList(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("禁止上传空文件");
        }
        return officeService.saveGlobalCompanyList(file);
    }

    @Override
    public Global500VO getGlobalCompanyList(Integer year) {
        validYear(year);
        return officeService.getGlobalCompanyList(year);
    }

    @Override
    public void toMapList(MultipartFile file) {
        Map<String, String> nameValue = new HashMap<>(8);
        nameValue.put("排名", "rank");
        nameValue.put("公司名称(中文)", "companyName");
        nameValue.put("营业收入(百万美元)", "income");
        nameValue.put("利润(百万美元)", "profit");
        nameValue.put("国家", "country");
        nameValue.put("年份", "year");
        ExcelUtil.convertExcel2Map(file, nameValue, 0, 1).forEach(WebLogger::info);
    }

    @Override
    public void exportGlobal500(Integer year) {
        validYear(year);
        officeService.exportGlobal500(year);
    }

    private void validYear(Integer year) {
        int thisYear = LocalDateTime.now().getYear();
        if (Objects.isNull(year) || year > thisYear) {
            throw new IllegalArgumentException("非法时间");
        }
    }
}

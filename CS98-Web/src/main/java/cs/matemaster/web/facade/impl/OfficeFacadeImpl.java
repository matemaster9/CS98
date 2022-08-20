package cs.matemaster.web.facade.impl;

import cs.matemaster.web.common.model.vo.Global500VO;
import cs.matemaster.web.facade.OfficeFacade;
import cs.matemaster.web.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
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
        int thisYear = LocalDateTime.now().getYear();
        if (Objects.isNull(year) || year > thisYear) {
            throw new IllegalArgumentException("非法时间");
        }
        return officeService.getGlobalCompanyList(year);
    }
}

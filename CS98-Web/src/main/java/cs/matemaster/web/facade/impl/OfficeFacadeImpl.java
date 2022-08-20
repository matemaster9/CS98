package cs.matemaster.web.facade.impl;

import cs.matemaster.web.facade.OfficeFacade;
import cs.matemaster.web.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
}

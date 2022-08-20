package cs.matemaster.web.facade;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author MateMaster
 * @since 2022/8/18
 */
public interface OfficeFacade {


    /**
     * 上传file
     *
     * @param file
     * @return
     */
    Boolean uploadGlobalCompanyList(MultipartFile file);
}

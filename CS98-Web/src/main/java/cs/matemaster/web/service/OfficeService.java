package cs.matemaster.web.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author MateMaster
 * @since 2022/8/18
 */
public interface OfficeService {

    /**
     * 保存文件信息
     *
     * @param file
     * @return
     */
    Boolean saveGlobalCompanyList(MultipartFile file);
}

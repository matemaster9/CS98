package cs.matemaster.web.service;

import cs.matemaster.web.common.model.vo.Global500VO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    /**
     * 获取500信息
     *
     * @param year
     * @return
     */
    Global500VO getGlobalCompanyList(Integer year);
}

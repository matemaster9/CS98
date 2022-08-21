package cs.matemaster.web.facade;

import cs.matemaster.web.common.model.vo.Global500VO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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

    /**
     * 按年份查询500强
     *
     * @param year
     * @return
     */
    Global500VO getGlobalCompanyList(Integer year);

    void toMapList(MultipartFile file);

    void exportGlobal500(Integer year);
}

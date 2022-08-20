package cs.matemaster.web.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cs.matemaster.web.common.webcore.WebLogger;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/18
 */
public final class ExcelUtil {

    private ExcelUtil() {
    }


    /**
     * excel转化Java对象
     *
     * @param file
     * @param pojo
     * @param title
     * @param head
     * @param <T>
     * @return
     */
    public static <T> List<T> getMapping(MultipartFile file, Class<T> pojo, int title, int head) {

        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(title);
            params.setHeadRows(head);
            return ExcelImportUtil.importExcel(file.getInputStream(), pojo, params);
        } catch (Exception e) {
            WebLogger.error("导出失败" + e.getMessage());
        }

        return Collections.emptyList();
    }
}

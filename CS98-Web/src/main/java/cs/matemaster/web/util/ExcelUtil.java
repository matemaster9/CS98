package cs.matemaster.web.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cs.matemaster.web.common.webcore.WebLogger;
import cs.matemaster.web.thirdparty.MapImportHandler;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MateMaster
 * @since 2022/8/18
 */
public final class ExcelUtil {

    private static final String CONTENT_TYPE = "application/vnd.ms-excel";
    private static final String CHINESE_REGEXP = "[\\u4e00-\\u9fa5]";

    private ExcelUtil() {
    }


    /**
     * excel转化Java对象
     *
     * @param excelFile
     * @param pojo
     * @param title
     * @param head
     * @param <T>
     * @return
     */
    public static <T> List<T> convertExcel2JavaObject(MultipartFile excelFile, Class<T> pojo, int title, int head) {

        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(title);
            params.setHeadRows(head);
            return ExcelImportUtil.importExcel(excelFile.getInputStream(), pojo, params);
        } catch (Exception e) {
            WebLogger.error("导出失败" + e.getMessage());
        }

        return Collections.emptyList();
    }

    /**
     * 解析excel转化成 List<Map<String, Object>>
     *
     * @param excelFile
     * @param nameValueMap
     * @param title
     * @param head
     * @return
     */
    public static List<Map<String, Object>> convertExcel2Map(MultipartFile excelFile, Map<String, String> nameValueMap, int title, int head) {

        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(title);
            params.setHeadRows(head);
            params.setDataHandler(new MapImportHandler(nameValueMap));
            return ExcelImportUtil.importExcel(excelFile.getInputStream(), Map.class, params);
        } catch (Exception e) {
            WebLogger.error("导出失败" + e.getMessage());
        }

        return Collections.emptyList();
    }

    public static Workbook exportWorkbook(List<ExcelExportEntity> columnList, Collection<Map<String, Object>> data) {
        ExportParams params = new ExportParams();
        return ExcelExportUtil.exportExcel(params, columnList, data);
    }

    public static void export2WebFront(String fileName, List<ExcelExportEntity> columnList, Collection<Map<String, Object>> data) {
        try {

            Workbook workbook = exportWorkbook(columnList, data);

            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletResponse response = requestAttributes.getResponse();
            if (Objects.isNull(response)) {
                WebLogger.error("response is null");
                return;
            }

            response.reset();
            response.setContentType(CONTENT_TYPE);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            if (isContainsChinese(fileName)) {
                response.setHeader("Content-Disposition", String.format("attachment;filename=%s.xls", new String(fileName.getBytes("GBK"))));
            } else {
                response.setHeader("Content-Disposition", String.format("attachment;filename=%s.xls", fileName));
            }

            ServletOutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            WebLogger.error("导出excel到前端失败：" + e.getMessage());
        }
    }

    private static boolean isContainsChinese(String content) {
        Pattern compile = Pattern.compile(CHINESE_REGEXP);
        Matcher matcher = compile.matcher(content);
        return matcher.find();
    }
}

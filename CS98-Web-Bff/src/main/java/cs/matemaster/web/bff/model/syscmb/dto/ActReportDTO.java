package cs.matemaster.web.bff.model.syscmb.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/13
 */
@Data
public class ActReportDTO {

    private String activityId;

    private String activityName;

    private String deptName;

    private String activityType;

    public static List<String> getList() {
        return Collections.emptyList();
    }
}

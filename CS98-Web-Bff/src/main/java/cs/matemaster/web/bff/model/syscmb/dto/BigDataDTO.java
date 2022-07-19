package cs.matemaster.web.bff.model.syscmb.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author MateMaster
 * @since 2022/7/13
 */
@Data
public class BigDataDTO {
    private String date;

    private String activityId;

    private String count;

    public static List<BigDataDTO> getList(int capacity) {
        return Collections.emptyList();
    }
}

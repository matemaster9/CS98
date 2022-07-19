package cs.matemaster.web.bff.model.syscmb.vo;

import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/7/13
 */
@Data
public class ActDataFunnelVO {

    private String date;

    private String activityId;

    private Integer count;

    private Integer countSuc;
}

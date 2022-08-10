package cs.matemaster.web.bff.model.syscmb.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/13
 */
@Data
public class RipApiDTO {
    private String actGroupId;
    private String prdType;
    private String time;
    private Integer prdDrawCount;
    private Integer prdPeopleSuc;
    private BigDecimal prdProvideAmount;
    private BigDecimal prdProvideUseAmount;
    private BigDecimal prdDrawAmount;
    private BigDecimal prdUseAmount;
    private Integer prdUsePeople;

    private String activityId;

    private Integer countSuc;

    public static List<RipApiDTO> getList(int capacity) {
        return Collections.emptyList();
    }
}

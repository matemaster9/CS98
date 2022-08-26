package cs.matemaster.web.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/8/25
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GlobalComPO {
    private String comRank;
    private String comIncome;
    private String comProfit;
    private String comName;
}

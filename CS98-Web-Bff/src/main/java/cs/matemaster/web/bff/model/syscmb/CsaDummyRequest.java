package cs.matemaster.web.bff.model.syscmb;

import lombok.Data;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/12
 */
@Data
public class CsaDummyRequest {

    private String startDate;

    private String endDate;

    private List<String> actIdList;

    private String[] actIdArr;
}

package cs.matemaster.web.common.model;

import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/7/19
 */
@Data
public abstract class PaginatedParam {

    protected int pageNo;

    protected int pageSize;

    public PaginatedParam() {
        pageNo = 1;
        pageSize = 10;
    }
}

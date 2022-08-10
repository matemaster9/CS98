package cs.matemaster.web.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDataView<T> {

    private int totalCount;

    private int pageNo;

    private int pageSize;

    private List<T> data;
}

package cs.matemaster.web.common.model;

import cs.matemaster.web.common.model.vo.GlobalCompanyVO;
import lombok.Data;

import java.util.List;

/**
 * 财富世界500强榜单
 *
 * @author MateMaster
 * @since 2022/8/18
 */
@Data
public class FortuneGlobal500 {

    private Integer year;

    private List<GlobalCompanyVO> globalCompanyList;
}

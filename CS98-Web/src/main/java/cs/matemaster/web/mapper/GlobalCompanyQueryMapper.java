package cs.matemaster.web.mapper;

import cs.matemaster.web.common.model.vo.GlobalCompanyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/20
 */
@Mapper
public interface GlobalCompanyQueryMapper {

    @Select("SELECT com_rank, company_name, income, profit, country " +
            "FROM global_company " +
            "WHERE delete_flag = 0 AND year = #{year} "
    )
    List<GlobalCompanyVO> getGlobalCompanyListByYear(Integer year);

}

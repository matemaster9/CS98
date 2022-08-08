package cs.matemaster.web.mapper;

import cs.matemaster.web.common.model.ComStaff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/8
 */
@Mapper
public interface ComStaffMapper {

    @Insert({"<script>" +
            "INSERT INTO com_staff(code, salary, sex, stochastic_number, area) " +
            "VALUES ()" +
            "</script>"
    })
    int batchInsert(List<ComStaff> comStaffs);
}

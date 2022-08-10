package cs.matemaster.web.mapper;

import cs.matemaster.web.common.model.ComStaff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/8
 */
@Mapper
public interface ComStaffMapper {

    @Insert({"<script>" +
            "INSERT INTO com_staff(code, salary, sex, stochastic_number, area, stamp) " +
            "VALUES " +
            "<foreach  collection='a' item='item' separator=',' > " +
            " (#{item.code}, #{item.salary}, #{item.sex}, #{item.stochasticNumber}, #{item.area}, now()) " +
            "</foreach>" +
            "</script>"
    })
    int batchInsert(@Param("a") List<ComStaff> comStaffs);
}

package cs.matemaster.web.mapper;

import cs.matemaster.web.common.model.dto.GlobalCompanyDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/20
 */
@Mapper
public interface GlobalCompanyMapper {

    @Insert("<script>" +
            "INSERT INTO global_company (com_rank, company_name, income, profit, country, year) " +
            "VALUES " +
            "   <foreach  collection='com' item='item' separator=',' > " +
            "       (#{item.rank}, #{item.companyName}, #{item.income}, #{item.profit}, #{item.country}, #{item.year}) " +
            "   </foreach>" +
            "</script>"
    )
    int batchInsertGlobalCom(@Param("com") List<GlobalCompanyDto> globalCompanyDtoList);

    @Insert("INSERT INTO global_company (com_rank, company_name, income, profit, country, year) " +
            "VALUES " +
            "(#{item.rank}, #{item.companyName}, #{item.income}, #{item.profit}, #{item.country}, #{item.year}) "
    )
    int insertGlobalCom(@Param("item") GlobalCompanyDto globalCompanyDtoList);
}

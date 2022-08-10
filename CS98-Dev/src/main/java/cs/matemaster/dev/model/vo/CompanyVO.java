package cs.matemaster.dev.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.var;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author MateMaster
 * @since 2022/7/14
 */
@Data
public class CompanyVO {

    @JsonProperty("CompanyCode")
    private String companyCode;

    @JsonProperty("CreateDate")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createDate;

    @JsonProperty("Rank")
    private Integer rank;

    private static final String COM = "COM";
    private static final ThreadLocalRandom CURRENCY_RDM = ThreadLocalRandom.current();


    public static CompanyVO rdm() {
        var companyVO = new CompanyVO();
        companyVO.setCompanyCode(COM + CURRENCY_RDM.nextInt(99_999_999));
        companyVO.setCreateDate(LocalDate.now().minusDays(CURRENCY_RDM.nextInt(3_000)));
        companyVO.setRank(CURRENCY_RDM.nextInt(500));
        return companyVO;
    }

    public static List<CompanyVO> getList(int capacity) {
        List<CompanyVO> companyVOList = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            var companyVO = new CompanyVO();
            companyVO.setCompanyCode(COM + CURRENCY_RDM.nextInt(99_999_999));
            companyVO.setCreateDate(LocalDate.now().minusDays(CURRENCY_RDM.nextInt(3_000)));
            companyVO.setRank(CURRENCY_RDM.nextInt(500));
            companyVOList.add(companyVO);
        }

        return companyVOList;
    }
}

package cs.matemaster.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import cs.matemaster.web.common.testmodel.GlobalCompany;
import cs.matemaster.web.common.util.MockUtil;
import cs.matemaster.web.common.webcore.WebLogger;
import cs.matemaster.web.model.GlobalComPO;
import cs.matemaster.web.model.MemberVO;
import cs.matemaster.web.model.jackson.ComputerVO;
import cs.matemaster.web.model.jackson.MemberIgnoreType;
import cs.matemaster.web.model.jackson.WeChatUserVO;
import lombok.var;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author MateMaster
 * @since 2022/8/21
 */
public class JacksonTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper OBJECT_MAPPER_NONNULL = new ObjectMapper();
    private static final ObjectMapper OBJECT_MAPPER_SNAKE = new ObjectMapper();
    private static final String[] COM_NAME = {"HUAWEI", "ALIBABA", "APPLE", "ORACLE", "GOOGLE", "SPACEX"};

    static {
        OBJECT_MAPPER_NONNULL.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER_SNAKE.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    @Test
    public void test1() throws JsonProcessingException {
        GlobalCompany company = new GlobalCompany();
        company.setRank(1);
        company.setCompanyName("COM");
        company.setIncome(new BigDecimal("100.0"));
        company.setProfit(new BigDecimal("10.0"));
        company.setYear(2021);
        company.setCountry("Chinese");

        String jsonString = OBJECT_MAPPER.writeValueAsString(company);

        WebLogger.debug(jsonString);

        GlobalCompany copy = OBJECT_MAPPER.readValue(jsonString, GlobalCompany.class);
        WebLogger.debug(copy);
    }

    @Test
    public void test2() throws JsonProcessingException {
        GlobalCompany company = new GlobalCompany();
        company.setRank(1);
        company.setCompanyName("COM");
        company.setIncome(new BigDecimal("100.0"));
        company.setProfit(new BigDecimal("10.0"));
        company.setYear(2021);
        company.setCountry("Chinese");

        byte[] jsonBytes = OBJECT_MAPPER.writeValueAsBytes(company);
        String jsonStr = new String(jsonBytes);

        WebLogger.debug(Arrays.toString(jsonBytes));
        WebLogger.debug(jsonStr);
    }

    @Test
    public void test3() throws JsonProcessingException {
        Set<String> companyNameSet = Arrays.stream(COM_NAME).collect(Collectors.toSet());
        List<String> companyNameList = Arrays.stream(COM_NAME).collect(Collectors.toList());
        Map<Integer, String> companyNameMap = new HashMap<Integer, String>() {{
            for (int i = 0; i < COM_NAME.length; i++)
                put(i, COM_NAME[i]);
        }};

        WebLogger.debug(OBJECT_MAPPER.writeValueAsString(companyNameSet));
        WebLogger.debug(OBJECT_MAPPER.writeValueAsString(companyNameList));
        WebLogger.debug(OBJECT_MAPPER.writeValueAsString(companyNameMap));
    }

    @Test
    public void test4() throws JsonProcessingException {
        var companyNameSet = new HashSet<>(MockUtil.getGlobalCompanyForTest(3));
        var companyNameList = MockUtil.getGlobalCompanyForTest(3);
        var companyNameMap = MockUtil.getGlobalCompanyForTest(3).stream().collect(Collectors.toMap(GlobalCompany::getRank, Function.identity()));

        WebLogger.debug(OBJECT_MAPPER.writeValueAsString(companyNameSet));
        WebLogger.debug(OBJECT_MAPPER.writeValueAsString(companyNameList));
        WebLogger.debug(OBJECT_MAPPER.writeValueAsString(companyNameMap));
    }

    @Test
    public void test5() throws JsonProcessingException {
        var companyNameSet = new HashSet<>(MockUtil.getGlobalCompanyForTest(3));
        var companyNameList = MockUtil.getGlobalCompanyForTest(3);
        var companyNameMap = MockUtil.getGlobalCompanyForTest(3).stream().collect(Collectors.toMap(GlobalCompany::getRank, Function.identity()));

        String setJson = OBJECT_MAPPER.writeValueAsString(companyNameSet);
        String listJson = OBJECT_MAPPER.writeValueAsString(companyNameList);
        String mapJson = OBJECT_MAPPER.writeValueAsString(companyNameMap);

        Set set = OBJECT_MAPPER.readValue(setJson, Set.class);
        List list = OBJECT_MAPPER.readValue(listJson, List.class);
        Map map = OBJECT_MAPPER.readValue(mapJson, Map.class);

        WebLogger.debug(set);
        WebLogger.debug(list);
        WebLogger.debug(map);

        WebLogger.debug(list.get(0));
    }

    @Test
    public void test6() throws JsonProcessingException {
        var company = new GlobalCompany();
        company.setYear(2018);
        company.setCompanyName("GLOBAL_COM");
        company.setRank(499);
        company.setCountry("Earth");
        company.setIncome(BigDecimal.valueOf(10000));
        company.setProfit(BigDecimal.valueOf(-1000));
        List<GlobalCompany> globalCompanyList = Collections.singletonList(company);

        String jsonString = OBJECT_MAPPER.writeValueAsString(globalCompanyList);
        List copy = OBJECT_MAPPER.readValue(jsonString, List.class);
        WebLogger.debug(copy);

        WebLogger.debug(copy.get(0));
    }

    @Test
    public void test7() throws JsonProcessingException {
        var company = new GlobalCompany();
        company.setYear(2018);
        company.setCompanyName("GLOBAL_COM");
        company.setRank(499);
        company.setCountry("Earth");
        company.setIncome(BigDecimal.valueOf(10000));
        company.setProfit(BigDecimal.valueOf(-1000));
        List<GlobalCompany> globalCompanyList = Collections.singletonList(company);

        String jsonString = OBJECT_MAPPER.writeValueAsString(globalCompanyList);
        List<GlobalCompany> copy = OBJECT_MAPPER.readValue(jsonString, new TypeReference<List<GlobalCompany>>() {
        });
        WebLogger.debug(copy);
        WebLogger.debug(copy.get(0));
    }

    @Test
    public void test8() throws JsonProcessingException {
        String jsonString = OBJECT_MAPPER.writeValueAsString(COM_NAME);
        WebLogger.debug(jsonString);
        String[] comName = OBJECT_MAPPER.readValue(jsonString, String[].class);
        WebLogger.debug(Arrays.toString(comName));
    }

    @Test
    public void test9() throws JsonProcessingException {
        GlobalComPO globalComPO = new GlobalComPO();
        globalComPO.setComRank("1");
        globalComPO.setComName("GOOGLE");
        globalComPO.setComProfit("10000000");
        globalComPO.setComIncome("455987667878");

        String jsonString = OBJECT_MAPPER.writeValueAsString(globalComPO);
        WebLogger.debug(jsonString);
    }

    @Test
    public void test10() throws JsonProcessingException {
        GlobalComPO globalComPO = new GlobalComPO();
        globalComPO.setComRank("1");
        globalComPO.setComName("GOOGLE");
        globalComPO.setComProfit("10000000");
        globalComPO.setComIncome("455987667878");

        String jsonString = OBJECT_MAPPER.writeValueAsString(globalComPO);
        WebLogger.debug(jsonString);
    }

    @Test
    public void test11() throws JsonProcessingException {
        ComputerVO computer = new ComputerVO();
        computer.setModel("CAL-L1000");
        computer.setProduceDate(new Date());
        computer.setListingDate(LocalDate.now());

        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        String jsonString = OBJECT_MAPPER.writeValueAsString(computer);
        WebLogger.debug(jsonString);
    }

    @Test
    public void test12() throws JsonProcessingException {
        WeChatUserVO weChatUserVO = new WeChatUserVO();
        weChatUserVO.setUserId("18909087723");
        weChatUserVO.setPassword("LASFFHGVLL2#%$y");
        weChatUserVO.setLoginStamp(LocalDateTime.MAX);
        weChatUserVO.setUseless("无用字段");

        String jsonString = OBJECT_MAPPER.writeValueAsString(weChatUserVO);
        WebLogger.debug(jsonString);
    }

    @Test
    public void test13() throws JsonProcessingException {
        WeChatUserVO weChatUserVO = new WeChatUserVO();
        weChatUserVO.setUserId("18909087723");
        weChatUserVO.setPassword("LASFFHGVLL2#%$y");
        weChatUserVO.setLoginStamp(LocalDateTime.MAX);
        weChatUserVO.setUseless("无用字段");

        MemberVO memberVO = new MemberVO();
        memberVO.setUuid("svbqwevbjehb@#@%#BASDVH");
        memberVO.setName("MateMaster");
        memberVO.setWeChatUser(weChatUserVO);

        String jsonString = OBJECT_MAPPER.writeValueAsString(memberVO);
        WebLogger.debug(jsonString);
    }

    @Test
    public void test14() throws JsonProcessingException {
        WeChatUserVO weChatUserVO = new WeChatUserVO();
        weChatUserVO.setUserId("18909087723");
        weChatUserVO.setPassword("LASFFHGVLL2#%$y");
        weChatUserVO.setLoginStamp(LocalDateTime.MAX);
        weChatUserVO.setUseless("无用字段");

        ComputerVO computer = new ComputerVO();
        computer.setModel("CAL-L1000");
        computer.setProduceDate(new Date());
        computer.setListingDate(LocalDate.now());

        GlobalComPO globalComPO = new GlobalComPO();
        globalComPO.setComRank("1");
        globalComPO.setComName("GOOGLE");
        globalComPO.setComProfit("10000000");
        globalComPO.setComIncome("455987667878");

        MemberVO memberVO = new MemberVO();
        memberVO.setUuid("svbqwevbjehb@#@%#BASDVH");
        memberVO.setName("MateMaster");
        memberVO.setWeChatUser(weChatUserVO);
        memberVO.setComputer(computer);
        memberVO.setGlobalCom(globalComPO);

        OBJECT_MAPPER.addMixIn(ComputerVO.class, MemberIgnoreType.class);
        OBJECT_MAPPER.addMixIn(GlobalComPO.class, MemberIgnoreType.class);

        String jsonString = OBJECT_MAPPER.writeValueAsString(memberVO);
        WebLogger.debug(jsonString);
    }
}

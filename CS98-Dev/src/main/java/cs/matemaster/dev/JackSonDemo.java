package cs.matemaster.dev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.matemaster.web.common.vo.SysUserVO;
import cs.matemaster.web.common.webcore.JsonUtil;
import cs.matemaster.dev.model.ComputerVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Slf4j
public class JackSonDemo {

    private static final String JSON_STRING = JsonUtil.serialize(SysUserVO.rdmUser());
    private static final ComputerVO COMPUTER_OBJ;

    static {
        COMPUTER_OBJ = new ComputerVO();
        COMPUTER_OBJ.setBrand("HUAWEI");
        COMPUTER_OBJ.setPrice(12999);
        COMPUTER_OBJ.setProductionDate(LocalDateTime.now());
    }

    @Test
    public void JavaObj2JsonStr() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(COMPUTER_OBJ);
        log.info(result);
    }

    @Test
    public void JsonStr2JavaObj() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SysUserVO sysUserVO = mapper.readValue(JSON_STRING, SysUserVO.class);
        log.info(sysUserVO.toString());
    }
}

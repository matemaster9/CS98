package cs.matemaster.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import cs.matemaster.web.model.jackson.ComputerVO;
import cs.matemaster.web.model.jackson.WeChatUserVO;
import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/8/25
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberVO {
    private String uuid;
    private String name;

    // 无用的测试字段
    private WeChatUserVO weChatUser;
    private ComputerVO computer;
    private GlobalComPO globalCom;
}

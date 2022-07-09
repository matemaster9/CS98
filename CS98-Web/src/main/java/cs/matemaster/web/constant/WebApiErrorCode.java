package cs.matemaster.web.constant;

import cs.matemaster.common.constant.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Getter
@AllArgsConstructor
public enum WebApiErrorCode implements BaseCode {

    SYS_USER_INFO_NULL_ERROR("CSA0001", "用户信息为空"),
    SYS_USER_EXISTED_ERROR("CSA0002", "用户已存在");

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

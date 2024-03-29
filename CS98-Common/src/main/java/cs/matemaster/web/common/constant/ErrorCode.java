package cs.matemaster.web.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MateMaster
 * @since 2022/7/8
 */
@Getter
@AllArgsConstructor
public enum ErrorCode implements BaseCode {
    SUCCESS("0000", "请求成功"),
    UNKNOWN("CSV0001", "未知错误"),
    ILLEGAL_PARAM("CSV0002", "非法参数");

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

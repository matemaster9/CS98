package cs.matemaster.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MateMaster
 * @since 2022/7/8
 */
@Getter
@AllArgsConstructor
public enum ErrorCode implements BaseCode {
    SUCCESS("0000", "请求成功");

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

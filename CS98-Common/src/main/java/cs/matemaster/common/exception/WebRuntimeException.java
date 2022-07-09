package cs.matemaster.common.exception;

import cs.matemaster.common.constant.BaseCode;
import cs.matemaster.common.constant.ErrorCode;
import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Data
public class WebRuntimeException extends RuntimeException {

    private BaseCode errorCode;

    private Object extraMessage;

    public WebRuntimeException() {
        super(ErrorCode.UNKNOWN.getMessage());
        errorCode = ErrorCode.UNKNOWN;
    }

    public WebRuntimeException(BaseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public WebRuntimeException(BaseCode errorCode, Object extraMessage) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }
}

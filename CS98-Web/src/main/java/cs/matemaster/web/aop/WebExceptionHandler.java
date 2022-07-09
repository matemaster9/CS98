package cs.matemaster.web.aop;

import cs.matemaster.common.constant.ErrorCode;
import cs.matemaster.common.exception.WebRuntimeException;
import cs.matemaster.common.response.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@ResponseBody
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(WebRuntimeException.class)
    public ErrorResponse getWebRuntimeException(WebRuntimeException err) {
        return new ErrorResponse(err.getErrorCode().getCode(), err.getErrorCode().getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse getException(Exception err) {
        return new ErrorResponse(ErrorCode.UNKNOWN.getCode(), ErrorCode.UNKNOWN.getMessage());
    }
}

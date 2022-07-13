package cs.matemaster.web.common.webcore.global;

import cs.matemaster.web.common.constant.ErrorCode;
import cs.matemaster.web.common.exception.WebRuntimeException;
import cs.matemaster.web.common.response.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@ResponseBody
@ControllerAdvice
public class WebGlobalExceptionHandler {

    @ExceptionHandler(WebRuntimeException.class)
    public ErrorResponse getWebRuntimeException(WebRuntimeException err) {
        return new ErrorResponse(err.getErrorCode().getCode(), err.getErrorCode().getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse getException(Exception err) {
        return new ErrorResponse(ErrorCode.UNKNOWN.getCode(), ErrorCode.UNKNOWN.getMessage());
    }
}

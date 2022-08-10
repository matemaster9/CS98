package cs.matemaster.web.common.response;

import cs.matemaster.web.common.constant.BaseCode;
import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Data
public class ErrorResponse extends AbstractWebResponse {

    /**
     * 接口报错信息
     */
    private Object errorBody;

    public ErrorResponse(BaseCode errorCode) {
        setCode(errorCode.getCode());
        setMessage(errorCode.getMessage());
        setTimestamp(System.currentTimeMillis());
    }

    public ErrorResponse(String code, String errorMessage) {
        setCode(code);
        setMessage(errorMessage);
        setTimestamp(System.currentTimeMillis());
    }

    public ErrorResponse(String code, String errorMessage, Object errorBody) {
        setCode(code);
        setMessage(errorMessage);
        setTimestamp(System.currentTimeMillis());
        setErrorBody(errorBody);
    }

}

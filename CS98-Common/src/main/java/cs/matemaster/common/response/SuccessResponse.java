package cs.matemaster.common.response;

import cs.matemaster.common.constant.ErrorCode;
import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Data
public class SuccessResponse<T> extends AbstractWebResponse {

    /**
     * 接口响应成功数据
     */
    private T data;

    public SuccessResponse(T data) {
        setCode(ErrorCode.SUCCESS.getCode());
        setMessage(ErrorCode.SUCCESS.getMessage());
        setTimestamp(System.currentTimeMillis());
        this.data = data;
    }
}

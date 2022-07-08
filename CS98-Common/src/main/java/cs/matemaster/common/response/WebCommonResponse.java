package cs.matemaster.common.response;

/**
 * @author MateMaster
 * @since 2022/7/8
 */

import cs.matemaster.common.constant.BaseCode;
import lombok.Data;

@Data
public class WebCommonResponse<T> {
    /**
     * 响应码
     */
    private String code;

    /**
     * 请求状态信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 请求时间
     */
    private long timestamp;

    public WebCommonResponse() {
        timestamp = System.currentTimeMillis();
    }

    public static <T> WebCommonResponse<T> ok(BaseCode impl, T data) {
        WebCommonResponse<T> response = new WebCommonResponse<>();
        response.setCode(impl.getCode());
        response.setMessage(impl.getMessage());
        response.setData(data);
        return response;
    }
}

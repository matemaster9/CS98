package cs.matemaster.common.response;

import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Data
public abstract class AbstractWebResponse {

    /**
     * 响应码
     */
    protected String code;

    /**
     * 响应信息
     */
    protected String message;

    /**
     * 请求时间戳
     */
    protected long timestamp;
}

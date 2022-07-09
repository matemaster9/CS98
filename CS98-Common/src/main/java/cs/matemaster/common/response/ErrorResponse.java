package cs.matemaster.common.response;

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
    private Object errorMessage;
}

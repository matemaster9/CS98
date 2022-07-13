package cs.matemaster.web.common.vo;

import lombok.Data;

/**
 * http响应包装对象
 *
 * @author MateMaster
 * @since 2022/7/9
 */
@Data
public class HttpResponseWrapperVO {

    /**
     * http状态码
     */
    private Integer httpStatus;

    /**
     * http响应耗时
     */
    private Long timeConsuming;

    /**
     * http响应数据
     */
    private String data;
}

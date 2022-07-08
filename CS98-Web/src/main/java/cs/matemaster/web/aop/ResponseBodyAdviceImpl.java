package cs.matemaster.web.aop;

import cs.matemaster.common.response.WebCommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author MateMaster
 * @since 2022/7/8
 */
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice<WebCommonResponse> {

    @Override
    public boolean supports(MethodParameter param, Class clazz) {
        return false;
    }

    @Override
    public WebCommonResponse beforeBodyWrite(WebCommonResponse returnData, MethodParameter methodParameter,
                                             MediaType type, Class<? extends HttpMessageConverter<?>> clazz,
                                             ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }
}

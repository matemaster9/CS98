package cs.matemaster.web.aop;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author MateMaster
 * @since 2022/7/8
 */
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter param, Class clazz) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter param, MediaType type, Class clazz, ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }
}

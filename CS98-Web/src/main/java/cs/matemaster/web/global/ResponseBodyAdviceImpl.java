package cs.matemaster.web.global;

import cs.matemaster.common.response.SuccessResponse;
import cs.matemaster.common.webcore.BizUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * 统一后端接口返回值格式
 *
 * @author MateMaster
 * @since 2022/7/8
 */
@ControllerAdvice
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter param, Class clazz) {

        GetMapping get = param.getMethodAnnotation(GetMapping.class);
        PostMapping post = param.getMethodAnnotation(PostMapping.class);
        PutMapping put = param.getMethodAnnotation(PutMapping.class);
        DeleteMapping delete = param.getMethodAnnotation(DeleteMapping.class);

        String[] methods;
        if (Objects.nonNull(get)) {
            methods = get.value();
        } else if (Objects.nonNull(post)) {
            methods = post.value();
        } else if (Objects.nonNull(put)) {
            methods = put.value();
        } else if (Objects.nonNull(delete)) {
            methods = delete.value();
        } else {
            methods = new String[0];
        }

        return BizUtil.isNotEmptyArray(methods);
    }

    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter methodParameter,
                                  MediaType type, Class<? extends HttpMessageConverter<?>> clazz,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        return new SuccessResponse<>(returnValue);
    }
}

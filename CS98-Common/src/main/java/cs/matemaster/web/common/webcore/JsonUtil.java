package cs.matemaster.web.common.webcore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author MateMaster
 * @since 2022/7/8
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ObjectMapper CAMEL_MAPPER = new ObjectMapper();

    public static String serialize(Object obj) {
        if (Objects.isNull(obj)) {
            return BizUtil.Constants.BLANK;
        }

        try {
            return MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return BizUtil.Constants.BLANK;
        }
    }

    public static String serializeIgnoreNull(Object obj) {
        if (Objects.isNull(obj)) {
            return BizUtil.Constants.BLANK;
        }

        try {
            return MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return BizUtil.Constants.BLANK;
        }
    }

    public static String serializeWithUpperCamel(Object obj) {
        if (Objects.isNull(obj)) {
            return BizUtil.Constants.BLANK;
        }

        try {
            CAMEL_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
            return CAMEL_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return BizUtil.Constants.BLANK;
        }
    }

    public static <T> T deserialize(String content, Class<T> clazz) {
        if (BizUtil.isEmptyOrBlank(content)) {
            return null;
        }

        try {
            MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return MAPPER.readValue(content, clazz);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T deserialize(String content, TypeReference<T> type) {
        if (BizUtil.isEmptyOrBlank(content)) {
            return null;
        }

        try {
            MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return MAPPER.readValue(content, type);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}

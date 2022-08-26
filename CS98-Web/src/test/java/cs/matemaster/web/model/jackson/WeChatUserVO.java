package cs.matemaster.web.model.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author MateMaster
 * @since 2022/8/25
 */
@Data
@JsonIgnoreType
@JsonIgnoreProperties({"password", "loginStamp"})
public class WeChatUserVO {

    private String userId;

    private String password;

    private LocalDateTime loginStamp;

    @JsonIgnore
    private String useless;
}

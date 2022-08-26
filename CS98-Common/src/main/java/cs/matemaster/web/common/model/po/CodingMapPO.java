package cs.matemaster.web.common.model.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author MateMaster
 * @since 2022/8/17
 */
@Getter
@Setter
@ToString
public class CodingMapPO {
    private Long id;
    private String code;
    private String element;
    private Boolean deleteFlag;
    private LocalDateTime stamp;
}

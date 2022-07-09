package cs.matemaster.common.dto;

import lombok.Data;

/**
 * @author MateMaster
 * @since 2022/7/9
 */
@Data
public class DataWrapperDTO<T> {
    private String code;
    private String message;
    private long timestamp;
    private T data;
}

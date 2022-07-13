package cs.matemaster.web.bff.constant;

import cs.matemaster.web.common.constant.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MateMaster
 * @since 2022/7/11
 */
@Getter
@AllArgsConstructor
public enum WebBffErrorCode implements BaseCode {
    QUERY_DATE_ERROR("CSB0001", "查询起始时间不能大于当前时间点");

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

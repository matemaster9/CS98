package cs.matemaster.web.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author MateMaster
 * @since 2022/8/7
 */
@Setter
@Getter
@ToString
public class ComStaff {

    private String code;
    private Integer salary;
    private Integer sex;
    private Integer stochasticNumber;
    private String area;


    public ComStaff() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComStaff comStaff = (ComStaff) o;
        return Objects.equals(code, comStaff.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

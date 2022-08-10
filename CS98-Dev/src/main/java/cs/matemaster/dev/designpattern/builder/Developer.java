package cs.matemaster.dev.designpattern.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author MateMaster
 * @since 2022/8/9
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Developer {

    private String code;
    private String name;
    private Integer rank;

    public static DeveloperBuilder builder() {
        return new DeveloperBuilder();
    }

    public static class DeveloperBuilder implements Builder<Developer> {
        private String code;
        private String name;
        private Integer rank;

        public DeveloperBuilder code(final String code) {
            this.code = code;
            return this;
        }

        public DeveloperBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public DeveloperBuilder rank(final Integer rank) {
            this.rank = rank;
            return this;
        }


        @Override
        public Developer build() {
            return new Developer(this.code, this.name, this.rank);
        }
    }
}

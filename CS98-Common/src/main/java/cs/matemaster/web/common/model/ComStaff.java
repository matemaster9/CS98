package cs.matemaster.web.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

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
    private Boolean sex;
    private Integer stochasticNumber;
    private String area;

    private static final String COM = "COM";
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final String[] COM_AREA = {"北京市", "天津市", "河北省", "山西省", "内蒙古自治区", "辽宁省", "吉林省", "黑龙江省", "上海市", "江苏省", "浙江省", "安徽省",
            "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "广西壮族自治区", "海南省", "四川省", "贵州省", "云南省", "重庆市", "西藏自治区", "陕西省", "甘肃省",
            "青海省", "宁夏回族自治区", "新疆维吾尔自治区", "香港特别行政区", "澳门特别行政区", "台湾省"};

    public ComStaff() {
        code = getStochasticCode();
        salary = RANDOM.nextInt(10000, 100000);
        sex = RANDOM.nextBoolean();
        stochasticNumber = RANDOM.nextInt(0, 100);
        area = getStochasticArea();
    }

    private static String getStochasticCode() {
        return COM + RANDOM.nextInt(80_000_000, 90_000_000);
    }

    private static String getStochasticArea() {
        return COM_AREA[RANDOM.nextInt(0, COM_AREA.length)];
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

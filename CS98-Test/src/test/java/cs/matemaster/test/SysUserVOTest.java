package cs.matemaster.test;

import cs.matemaster.common.vo.SysUserVO;
import lombok.Data;
import org.junit.Test;

/**
 * @author MateMaster
 * @since 2022/7/6
 */
@Data
public class SysUserVOTest {

    @Test
    public void test() {
        System.out.println(SysUserVO.generate(1));
    }
}

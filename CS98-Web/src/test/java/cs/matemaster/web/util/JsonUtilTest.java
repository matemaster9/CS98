package cs.matemaster.web.util;

import cs.matemaster.web.common.vo.SysUserVO;
import cs.matemaster.web.common.webcore.JsonUtil;

/**
 * @author MateMaster
 * @since 2022/7/8
 */
public class JsonUtilTest {

    private static SysUserVO sysUserVO = SysUserVO.generate(1).get(0);

    @org.junit.Test
    public void serialize() {
        System.out.println(JsonUtil.serialize(sysUserVO));
    }

    @org.junit.Test
    public void serializeIgnoreNull() {
        sysUserVO.setCaptcha(null);
        System.out.println(JsonUtil.serializeIgnoreNull(sysUserVO));
    }

    @org.junit.Test
    public void serializeWithUpperCamel() {
        System.out.println(JsonUtil.serializeWithUpperCamel(sysUserVO));
    }

    @org.junit.Test
    public void deserialize() {
        System.out.println(JsonUtil.deserialize(JsonUtil.serialize(sysUserVO), SysUserVO.class));
    }

    @org.junit.Test
    public void testDeserialize() {

    }
}
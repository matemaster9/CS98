package cs.matemaster.web;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import cs.matemaster.web.common.model.ComStaff;
import cs.matemaster.web.common.util.MockUtil;
import cs.matemaster.web.common.webcore.WebLogger;
import cs.matemaster.web.model.hash.ActOprMember;
import cs.matemaster.web.model.hash.ActivityOperationGroup;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author MateMaster
 * @since 2022/8/27
 */
public class HashTest {

    @Test
    public void test1() {
        HashFunction hashFunction = Hashing.murmur3_32_fixed();
        HashCode hashCode = hashFunction.hashBytes(MockUtil.getClubMemberList(1).toString().getBytes(StandardCharsets.UTF_8));
        WebLogger.debug(hashCode.hashCode());
    }

    @Test
    public void test2() {
        HashFunction hashFunction = Hashing.murmur3_32_fixed();
        ComStaff comStaff = new ComStaff();
        int hashCode = hashFunction.newHasher()
                .putString(comStaff.getCode(), Charset.defaultCharset())
                .putInt(comStaff.getSalary())
                .putBoolean(comStaff.getSex())
                .putInt(comStaff.getStochasticNumber())
                .putString(comStaff.getArea(), Charset.defaultCharset())
                .hash().hashCode();
        WebLogger.debug(hashCode);
    }

    @Test
    public void test3() {
        HashFunction hashFunction = Hashing.murmur3_32_fixed();
        ComStaff comStaff = new ComStaff();
        int hashCode = hashFunction.hashObject(comStaff,
                (staff, primitiveSink) -> primitiveSink
                        .putString(staff.getCode(), Charsets.UTF_8)
                        .putInt(staff.getSalary())
                        .putBoolean(staff.getSex())
                        .putInt(staff.getStochasticNumber())
                        .putString(staff.getArea(), Charsets.UTF_8)
        ).hashCode();
        WebLogger.debug(hashCode);
    }

    @Test
    public void test4() {
        HashFunction hashFunction = Hashing.murmur3_128();
        ComStaff comStaff = new ComStaff();
        long hashCode = hashFunction.hashObject(comStaff,
                (staff, primitiveSink) -> primitiveSink
                        .putString(staff.getCode(), Charsets.UTF_8)
                        .putInt(staff.getSalary())
                        .putBoolean(staff.getSex())
                        .putInt(staff.getStochasticNumber())
                        .putString(staff.getArea(), Charsets.UTF_8)
        ).asLong();
        WebLogger.debug(hashCode);
    }

    @Test
    public void test5() {
        HashFunction hashFunction = Hashing.murmur3_128();
        ComStaff comStaff = new ComStaff();
        long hashCode = hashFunction.hashObject(comStaff,
                (staff, primitiveSink) -> primitiveSink
                        .putString(staff.getCode(), Charsets.UTF_8)
                        .putInt(staff.getSalary())
                        .putBoolean(staff.getSex())
                        .putInt(staff.getStochasticNumber())
                        .putString(staff.getArea(), Charsets.UTF_8)
        ).asLong();
        WebLogger.debug(hashCode);
    }

    @Test
    public void test6() {
        ActOprMember actOprMember1 = new ActOprMember();
        actOprMember1.setCode("89797821");
        actOprMember1.setName("MateMaster");
        ActOprMember actOprMember2 = new ActOprMember();
        actOprMember2.setCode("8768796");
        actOprMember2.setName("COde");
        ActOprMember leader = new ActOprMember();
        leader.setCode("907809787");
        leader.setName("TL");
        ActivityOperationGroup activityOperationGroup = new ActivityOperationGroup();
        activityOperationGroup.setRank(1);
        activityOperationGroup.setLeader(leader);
        activityOperationGroup.setMembers(Arrays.asList(actOprMember1, actOprMember2));

        HashCode hashCode = Hashing.murmur3_128().newHasher()
                .putInt(activityOperationGroup.getRank())
                .putObject(activityOperationGroup.getLeader(), ActivityOperationGroup.FunnelEnum.LEADER)
                .putObject(activityOperationGroup.getMembers(), ActivityOperationGroup.FunnelEnum.MEMBER)
                .hash();

        WebLogger.debug(hashCode.asLong());
    }

    @Test
    public void test7() {
        ActOprMember actOprMember = new ActOprMember();
        actOprMember.setCode("80678681");
        actOprMember.setName("MateMaster");
        actOprMember.setSex(Boolean.TRUE);
        actOprMember.setAge((short) 23);
        actOprMember.setDescription("系统开发");

        HashCode hashCode = Hashing.murmur3_128().newHasher()
                .putString(actOprMember.getCode(), Charsets.UTF_8)
                .putString(actOprMember.getName(), Charsets.UTF_8)
                .putBoolean(actOprMember.getSex())
                .putShort(actOprMember.getAge())
                .putString(actOprMember.getDescription(), Charsets.UTF_8)
                .hash();

        long hashCode1 = Hashing.murmur3_128()
                .hashObject(actOprMember,
                        (member, primitiveSink) -> primitiveSink.putString(member.getCode(), Charsets.UTF_8)
                                .putString(member.getName(), Charsets.UTF_8)
                                .putBoolean(member.getSex())
                                .putShort(member.getAge())
                                .putString(member.getDescription(), Charsets.UTF_8)
                ).asLong();

        long hashCode2 = Hashing.murmur3_128().newHasher()
                .putObject(actOprMember,
                        (member, primitiveSink) -> primitiveSink.putString(member.getCode(), Charsets.UTF_8)
                                .putString(member.getName(), Charsets.UTF_8)
                                .putBoolean(member.getSex())
                                .putShort(member.getAge())
                                .putString(member.getDescription(), Charsets.UTF_8)
                ).hash()
                .asLong();

        WebLogger.debug(hashCode.asLong());
        WebLogger.debug(hashCode1);
        WebLogger.debug(hashCode2);
    }
}

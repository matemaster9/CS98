package cs.matemaster.dev.effectivejava.generalprogramming;

import cs.matemaster.web.common.model.ClubMember;
import cs.matemaster.web.common.util.MockUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author MateMaster
 * @since 2022/8/7
 */
@Slf4j
public class Item57 {

    @Test
    public void test() {
        // NPE
        List<String> strings = new ArrayList<>(null);
        System.out.println(strings);
    }

    /**
     * for-each
     */
    @Test
    public void demo1() {
        List<ClubMember> clubMemberList = MockUtil.getClubMemberList(10);
        for (var clubMember : clubMemberList) {
            if (clubMember.getWorth() < 500000) {
                continue;
            }
            log.info("身价：" + clubMember.getWorth());
        }
    }

    /**
     * for loop
     */
    @Test
    public void demo2() {
        List<ClubMember> clubMemberList = MockUtil.getClubMemberList(10);
        for (var item = clubMemberList.iterator(); item.hasNext(); ) {
            ClubMember clubMember = item.next();
            if (clubMember.getWorth() < 500000) {
                continue;
            }
            item.remove();
        }
        log.info("身价500000以下的：" + clubMemberList);
    }

    /**
     * CV-false
     */
    @Test
    public void bug() {
        var clubMemberList = MockUtil.getClubMemberList(10);
        var clubMemberList2 = MockUtil.getClubMemberList(10);
        var iterator = clubMemberList.iterator();
        while (iterator.hasNext()) {
            log.info("ClubMember: " + iterator.next());
        }

        // bug : iterator.hasNext() is always false
        var iterator2 = clubMemberList2.iterator();
        while (iterator.hasNext()) {
            log.info("ClubMember: " + iterator2.next());
        }
    }

    @Test
    public void err() {
        var clubMemberList = MockUtil.getClubMemberList(10);
        var clubMemberList2 = MockUtil.getClubMemberList(10);

        for (var iterator = clubMemberList.iterator(); iterator.hasNext(); ) {
            log.info("ClubMember: " + iterator.next());
        }

/*
        CV: iterator报错
        for (var iterator2 = clubMemberList2.iterator(); iterator.hasNext(); ) {
            log.info("ClubMember: " + iterator2.next());
        }*/

        for (var iterator2 = clubMemberList2.iterator(); iterator2.hasNext(); ) {
            log.info("ClubMember: " + iterator2.next());
        }
    }

    @Test
    public void demo3() {
        var clubMemberList = MockUtil.getClubMemberList(10);
        for (int i = 0, size = clubMemberList.size(); i < size; i++) {

        }
    }
}

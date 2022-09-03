package cs.matemaster.web;

import cs.matemaster.web.common.model.WeekOfWeekBasedYear;
import cs.matemaster.web.common.util.BizTimeUtil;
import cs.matemaster.web.common.webcore.WebLogger;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author MateMaster
 * @since 2022/8/27
 */
public class JavaTimeTest {

    private static final ThreadLocalRandom StdRandom = ThreadLocalRandom.current();

    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        WebLogger.debug(now.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        WebLogger.debug(now.format(DateTimeFormatter.ISO_WEEK_DATE));
        WebLogger.debug(now.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void test2() {
        LocalDate now = LocalDate.now();
        WeekFields iso = WeekFields.ISO;
        int weekOfWeekBasedYear = now.get(iso.weekOfWeekBasedYear());
        WebLogger.debug(weekOfWeekBasedYear);
    }

    @Test
    public void test3() {
        LocalDate now = LocalDate.now();
        WebLogger.debug(now.withYear(2012).atStartOfDay());

        LocalDate of = LocalDate.of(2022, 1, 4);
        int i = of.get(WeekFields.ISO.weekOfWeekBasedYear());
    }

    @Test
    public void test4() {
        LocalDate of = LocalDate.of(2022, 1, 4);
        LocalDate with = of.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        WebLogger.debug(of);
        WebLogger.debug(with);

        LocalDate of1 = LocalDate.of(2023, 1, 4);
        LocalDate with1 = of1.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        WebLogger.debug(of1);
        WebLogger.debug(with1);
    }

    @Test
    public void test5() {
        Map<Integer, WeekOfWeekBasedYear> weekBasedYearMap = BizTimeUtil.getWeekBasedYearMap(2022);
        weekBasedYearMap.entrySet().forEach(WebLogger::debug);
    }

    @Test
    public void test6() {
        LocalDate firstDayOfWeekOfWeekBasedYear = LocalDate.of(2022, 1, 4).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        for (int i = 0; i < 53; i++) {
            WebLogger.debug(firstDayOfWeekOfWeekBasedYear.plusWeeks(i));
        }

    }

    @Test
    public void test7() {
        LocalDate firstDayOfWeekOfWeekBasedYear = LocalDate.of(2022, 1, 4).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate o = firstDayOfWeekOfWeekBasedYear.plusWeeks(52);
        LocalDate nextFirstDayOfWeekOfWeekBasedYear = LocalDate.of(2023, 1, 4).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        WebLogger.debug(o);
        WebLogger.debug(nextFirstDayOfWeekOfWeekBasedYear);
    }

    @Test
    public void test8() {

        for (int i = 2000; i < 2023; i++) {
            Map<Integer, WeekOfWeekBasedYear> weekBasedYearMap = BizTimeUtil.getWeekBasedYearMap(i);
            WebLogger.debug(i + ": " + weekBasedYearMap.keySet().size());
        }
    }

    @Test
    public void test9() {
        // 周日
        LocalDate now = LocalDate.of(2022, 8, 28);

        // 月份的第一天、最后一天
        WebLogger.debug(now.with(TemporalAdjusters.firstDayOfMonth()));
        WebLogger.debug(now.with(TemporalAdjusters.lastDayOfMonth()));


        // 年份的第一天、最后一天
        WebLogger.debug(now.with(TemporalAdjusters.firstDayOfYear()));
        WebLogger.debug(now.with(TemporalAdjusters.lastDayOfYear()));

        // 下个月或下年的第一天
        WebLogger.debug(now.with(TemporalAdjusters.firstDayOfNextYear()));
        WebLogger.debug(now.with(TemporalAdjusters.firstDayOfNextMonth()));

        // 几月的第一个星期几或最后一个星期几
        WebLogger.debug(now.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)));
        WebLogger.debug(now.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)));

        // 月份的第几个星期几
        WebLogger.debug(now.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.SUNDAY)));
        WebLogger.debug(now.with(TemporalAdjusters.dayOfWeekInMonth(-1, DayOfWeek.SUNDAY)));

        // 向前推荐至星期几
        WebLogger.debug(now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
        WebLogger.debug(now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)));
        WebLogger.debug(now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)));
        WebLogger.debug(now.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)));

        // 向后延至星期几
        WebLogger.debug(now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        WebLogger.debug(now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
        WebLogger.debug(now.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)));
        WebLogger.debug(now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));
    }

    @Test
    public void test10() {
        LocalDate of = LocalDate.of(2022, 1, 1);
        LocalDate first = LocalDate.ofYearDay(2022, 1);
        WebLogger.debug(of);
        WebLogger.debug(first);
        WebLogger.debug(of.isEqual(first));
    }

    @Test
    public void test11() {
        Map<Integer, LocalDate> calendarBaseYearMap = BizTimeUtil.getCalendarBaseYearMap(2022);
        calendarBaseYearMap.entrySet().forEach(WebLogger::debug);
    }


    @Test
    public void test12() {
        LocalDate stochasticDate1 = LocalDate.of(StdRandom.nextInt(2018, 2022), StdRandom.nextInt(1, 13), StdRandom.nextInt(1, 29));
        LocalDate stochasticDate2 = LocalDate.of(StdRandom.nextInt(2018, 2022), StdRandom.nextInt(1, 13), StdRandom.nextInt(1, 29));

        // 两个日期之间相差的天数
        long interval = ChronoUnit.DAYS.between(stochasticDate1, stochasticDate2);

        WebLogger.debug(stochasticDate1);
        WebLogger.debug(stochasticDate2);
        WebLogger.debug(interval);
    }

}

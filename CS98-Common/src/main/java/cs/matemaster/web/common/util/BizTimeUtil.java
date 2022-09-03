package cs.matemaster.web.common.util;

import cs.matemaster.web.common.model.WeekOfWeekBasedYear;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Map;

/**
 * 业务中对于日期时间的处理
 *
 * @author MateMaster
 * @since 2022/8/28
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BizTimeUtil {

    /**
     * 自然周表示法
     *
     * @param year 所属年份
     * @return 当前年份所有自然周的起止日期
     */
    public static Map<Integer, WeekOfWeekBasedYear> getWeekBasedYearMap(int year) {

        Map<Integer, WeekOfWeekBasedYear> resultMap = new HashMap<>(64);

        // 当前年份和明年首个自然周的星期一
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY);
        LocalDate firstDayOfWeekOfWeekBasedYear = LocalDate.of(year, 1, 4).with(temporalAdjuster);
        LocalDate nextFirstDayOfWeekOfWeekBasedYear = LocalDate.of(year + 1, 1, 4).with(temporalAdjuster);

        int i = 0;
        while (true) {
            LocalDate firstDayOfNextWeek = firstDayOfWeekOfWeekBasedYear.plusWeeks(i++);
            if (firstDayOfNextWeek.isEqual(nextFirstDayOfWeekOfWeekBasedYear)) {
                break;
            }
            WeekOfWeekBasedYear nextWeek = new WeekOfWeekBasedYear();
            nextWeek.setFirst(firstDayOfNextWeek);
            nextWeek.setLast(firstDayOfNextWeek.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
            resultMap.put(firstDayOfNextWeek.get(WeekFields.ISO.weekOfWeekBasedYear()), nextWeek);
        }

        return resultMap;
    }

    public static Map<Integer, LocalDate> getCalendarBaseYearMap(int year) {
        Map<Integer, LocalDate> resultMap = new HashMap<>(512);

        LocalDate first = LocalDate.ofYearDay(year, 1);
        LocalDate last = first.with(TemporalAdjusters.lastDayOfYear());

        int i = 0;
        while (true) {
            LocalDate iterator = first.plusDays(i++);
            if (iterator.isAfter(last)) {
                break;
            }
            resultMap.put(iterator.getDayOfYear(), iterator);
        }

        return resultMap;
    }
}

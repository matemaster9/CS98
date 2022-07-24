package cs.matemaster.dev.cmb;

import cs.matemaster.dev.model.DatePeriod;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MateMaster
 * @since 2022/7/24
 */
public class ActDataFunnelController {


    /**
     * 日期分段
     *
     * @param start 起始日期
     * @param end   终止日期
     * @return 整月或非整月时间间隔
     */
    public List<DatePeriod> getDataPeriodList(LocalDate start, LocalDate end) {
        List<DatePeriod> periods = new ArrayList<>();
        Period between = Period.between(start, end);
        long interval = between.toTotalMonths();

        for (int i = 0; i <= interval; i++) {

            // 同月
            if (interval == 0) {
                DatePeriod datePeriod = new DatePeriod(start, end);
                if (isFirstDayOfMonth(start) && isLastDayOfMonth(end)) {
                    datePeriod.setMonthApart(true);
                }
                periods.add(datePeriod);
            }
            // 不同月
            else {
                if (i == 0) {
                    DatePeriod startDatePeriod = new DatePeriod(start, start.with(TemporalAdjusters.lastDayOfMonth()));
                    if (isFirstDayOfMonth(start)) {
                        startDatePeriod.setMonthApart(true);
                    }
                    periods.add(startDatePeriod);
                } else if (i == interval) {
                    DatePeriod endDatePeriod = new DatePeriod(end.with(TemporalAdjusters.firstDayOfMonth()), end);
                    if (isLastDayOfMonth(end)) {
                        endDatePeriod.setMonthApart(true);
                    }
                    periods.add(endDatePeriod);
                } else {
                    periods.add(new DatePeriod(start.plusMonths(i).with(TemporalAdjusters.firstDayOfMonth()), start.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()), true));
                }
            }
        }

        return periods;
    }


    private boolean isFirstDayOfMonth(LocalDate date) {
        return date.getDayOfMonth() == date.with(TemporalAdjusters.firstDayOfMonth()).getDayOfMonth();
    }

    private boolean isLastDayOfMonth(LocalDate date) {
        return date.getDayOfMonth() == date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    }
}

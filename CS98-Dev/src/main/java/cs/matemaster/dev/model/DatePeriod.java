package cs.matemaster.dev.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author MateMaster
 * @since 2022/7/24
 */
@Data
@AllArgsConstructor
public class DatePeriod {
    private LocalDate start;
    private LocalDate end;
    private boolean isMonthApart;

    public DatePeriod(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }
}

package cs.matemaster.web.model.time;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author MateMaster
 * @since 2022/8/27
 */
@Data
public class WeekDate {
    private LocalDate startDate;
    private LocalDate endDate;
}

package cs.matemaster.web.common.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author MateMaster
 * @since 2022/8/28
 */
@Data
public class WeekOfWeekBasedYear {
    private LocalDate first;
    private LocalDate last;
}

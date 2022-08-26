package cs.matemaster.web.model.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author MateMaster
 * @since 2022/8/25
 */
@Data
public class ComputerVO {

    private String model;

    private Date produceDate;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private LocalDate listingDate;
}

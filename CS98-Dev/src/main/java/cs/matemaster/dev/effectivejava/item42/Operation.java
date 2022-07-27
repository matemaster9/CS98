package cs.matemaster.dev.effectivejava.item42;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.DoubleBinaryOperator;

/**
 * @author MateMaster
 * @since 2022/7/25
 */
@Getter
@AllArgsConstructor
public enum Operation {

    PLUS("+", (x, y) -> x + y),

    MINUS("-", (x, y) -> x - y),

    MULTI("*", (x, y) -> x * y),

    DIVIDE("/", (x, y) -> x / y);

    private String symbol;
    private DoubleBinaryOperator operator;
    }

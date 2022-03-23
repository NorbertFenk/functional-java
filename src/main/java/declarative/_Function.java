package main.java.declarative;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int number = 1;
        number = increment(number);

        System.out.println(number);

        int number2 = 1;
        number2 = incrementOneByFunction.apply(number2);
        System.out.println(number2);

        int multipledNumber = incrementOneByFunction.andThen(multipleBy10).apply(1);
        System.out.println(multipledNumber);

        int incrementedAndMultiplied = incrementAndMultiplyByFunction.apply(4, 10);
        System.out.println(incrementedAndMultiplied);
    }

    static int increment(int number) {
        return number + 1;
    }

    static Function<Integer, Integer> incrementOneByFunction = number -> number + 1;

    static Function<Integer, Integer> multipleBy10 = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementAndMultiplyByFunction = (number, multiplier) ->
            (number + 1) * multiplier;
}

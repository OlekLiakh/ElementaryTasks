package main;

import java.util.function.Predicate;

@FunctionalInterface
public interface Validator<T> {

    boolean isDataValid(T value);

    default boolean validation(T value, Predicate<T> predicate) {
        return predicate.test(value);
    }

}

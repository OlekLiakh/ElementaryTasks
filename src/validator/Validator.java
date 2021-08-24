package validator;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
public interface Validator <T> {

    boolean isDataValid(T value);

    default boolean validation(T value, Predicate<T> predicate){
        return predicate.test(value);
    }

    default Validator<T> and(Validator<? super T> other) {
        Objects.requireNonNull(other);
        return (value) -> isDataValid(value) && other.isDataValid(value);
    }
}

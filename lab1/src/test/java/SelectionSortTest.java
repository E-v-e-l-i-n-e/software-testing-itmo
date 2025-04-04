import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @ParameterizedTest(name = "[{index}] Input: {0} -> Expected: {1}")
    @MethodSource("sortTestDataProvider")
    @DisplayName("Параметризованные тесты сортировки")
    void testSelectionSort(List<Integer> input, List<Integer> expected) {
        List<Integer> result = SelectionSort.selectionSort(input);
        assertIterableEquals(expected, result, "Сортировка выполнена некорректно");
    }

    @Test
    @DisplayName("Тест на пустом списке")
    void testEmptyList() {
        List<Integer> emptyList = Collections.emptyList();
        List<Integer> result = SelectionSort.selectionSort(emptyList);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Тест с одним элементом")
    void testSingleElementList() {
        List<Integer> singleElement = List.of(42);
        List<Integer> result = SelectionSort.selectionSort(singleElement);
        assertIterableEquals(singleElement, result);
    }


    @ParameterizedTest
    @NullSource
    @DisplayName("Тест с null на входе")
    void testNullInput(List<Integer> input) {
        assertThrows(NullPointerException.class,
                () -> SelectionSort.selectionSort(input));
    }

    @Test
    @DisplayName("Тест с повторяющимися элементами")
    void testDuplicateElements() {
        List<Integer> input = List.of(5, 2, 5, 1, 2);
        List<Integer> expected = List.of(1, 2, 2, 5, 5);
        List<Integer> result = SelectionSort.selectionSort(input);
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Тест с отрицательными числами")
    void testNegativeNumbers() {
        List<Integer> input = List.of(-3, -1, -5, -2);
        List<Integer> expected = List.of(-5, -3, -2, -1);
        List<Integer> result = SelectionSort.selectionSort(input);
        assertIterableEquals(expected, result);
    }


    @Test
    @DisplayName("Тест первой итерации сортировки")
    void testFirstIteration() {
        List<Integer> input = List.of(4, 3, 2, 1);
        List<Integer> expected = List.of(1, 3, 2, 4);
        List<Integer> result = SelectionSort.firstIteration(input);
        assertIterableEquals(expected, result, "Первая итерация сортировки возвращает неверное состояние массива");
    }

    @Test
    @DisplayName("Тест первой итерации для пустого списка")
    void testFirstIterationEmptyList() {
        List<Integer> input = List.of();
        List<Integer> expected = List.of();
        List<Integer> result = SelectionSort.firstIteration(input);
        assertIterableEquals(expected, result, "Первая итерация сортировки возвращает неверное состояние массива для пустого списка");
    }

    @Test
    @DisplayName("Тест первой итерации с одним элементом")
    void testFirstIterationSingleElement() {
        List<Integer> input = List.of(42);
        List<Integer> expected = List.of(42);
        List<Integer> result = SelectionSort.firstIteration(input);
        assertIterableEquals(expected, result, "Первая итерация сортировки возвращает неверное состояние массива для списка с одним элементом");
    }




    static Stream<Arguments> sortTestDataProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(4, 3, 2, 1),
                        List.of(1, 2, 3, 4)
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4),
                        List.of(1, 2, 3, 4)
                ),
                Arguments.of(
                        List.of(3, 1, 4, 1, 5, 9, 2, 6),
                        List.of(1, 1, 2, 3, 4, 5, 6, 9)
                ),
                Arguments.of(
                        List.of(100, 99, 98, 97),
                        List.of(97, 98, 99, 100)
                ),
                Arguments.of(
                        List.of(0, 0, 0, 0),
                        List.of(0, 0, 0, 0)
                )
        );
    }


}
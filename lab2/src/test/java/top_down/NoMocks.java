package top_down;

import func.Func;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.MockedStatic;
import trigonometric.Sec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

public class NoMocks {
    private static final double EPS = 1e-7;

    @ParameterizedTest
    @CsvFileSource(resources = "no_mocks.csv", numLinesToSkip = 1)
    void testFunctionWithoutMocks(double x, double expectedResult) {
        if (Double.isNaN(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            double actual = Func.function(x, EPS);
            assertEquals(expectedResult, actual, EPS);
        }
    }
}

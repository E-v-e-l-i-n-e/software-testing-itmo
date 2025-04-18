package top_down_log;

import func.Func;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NoMocks {
    private static final double EPS = 1e-7;
    private static final double EPS2 = 1e-4;

    @ParameterizedTest
    @CsvFileSource(resources = "no_mocks.csv", numLinesToSkip = 1)
    void testFunctionWithoutMocks(double x, double expectedResult) {
        if (Double.isNaN(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            double actual = Func.function(x, EPS);
            assertEquals(expectedResult, actual, EPS2);
        }
    }
}

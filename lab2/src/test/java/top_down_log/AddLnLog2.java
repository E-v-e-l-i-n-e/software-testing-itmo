package top_down_log;

import func.Func;
import logarithmic.Log_2;
import logarithmic.Log_3;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

public class AddLnLog2 {
    private static final double EPS = 1e-7;
    private static final double EPS2 = 1e-4;
    private MockedStatic<Log_3> mockedLog_3;

    @AfterEach
    void closeMocks() {
        if (mockedLog_3 != null) mockedLog_3.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "add_ln_log2.csv", numLinesToSkip = 1)
    void testFunctionWithMocks(
            double x,
            double log_3Value,
            double expectedResult) {

        mockedLog_3 = mockStatic(Log_3.class);

        mockedLog_3.when(() -> Log_3.log_3(eq(x), eq(EPS))).thenReturn(log_3Value);

        if (Double.isNaN(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            assertEquals(expectedResult, Func.function(x, EPS), EPS2);
        }

        mockedLog_3.verify(() -> Log_3.log_3(eq(x), eq(EPS)), Mockito.atLeastOnce());
    }
}

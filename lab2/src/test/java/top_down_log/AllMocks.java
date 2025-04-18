package top_down_log;

import func.Func;
import logarithmic.Ln;
import logarithmic.Log_2;
import logarithmic.Log_3;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import trigonometric.Cos;
import trigonometric.Sec;
import trigonometric.Sin;
import trigonometric.Tan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

public class AllMocks {
    private static final double EPS = 1e-7;
    private MockedStatic<Ln> mockedLn;
    private MockedStatic<Log_2> mockedLog_2;
    private MockedStatic<Log_3> mockedLog_3;

    @AfterEach
    void closeMocks() {
        if (mockedLn != null) mockedLn.close();
        if (mockedLog_2 != null) mockedLog_2.close();
        if (mockedLog_3 != null) mockedLog_3.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "all_mocks.csv", numLinesToSkip = 1)
    void testFunctionWithMocks(
            double x,
            double lnValue,
            double log_2Value,
            double log_3Value,
            double expectedResult) {

        mockedLn = mockStatic(Ln.class);
        mockedLog_2 = mockStatic(Log_2.class);
        mockedLog_3 = mockStatic(Log_3.class);

        mockedLn.when(() -> Ln.ln(eq(x), eq(EPS))).thenReturn(lnValue);
        mockedLog_2.when(() -> Log_2.log_2(eq(x), eq(EPS))).thenReturn(log_2Value);
        mockedLog_3.when(() -> Log_3.log_3(eq(x), eq(EPS))).thenReturn(log_3Value);

        if (Double.isNaN(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            assertEquals(expectedResult, Func.function(x, EPS), EPS);
        }

        mockedLn.verify(() -> Ln.ln(eq(x), eq(EPS)), Mockito.atLeastOnce());
        mockedLog_2.verify(() -> Log_2.log_2(eq(x), eq(EPS)), Mockito.atLeastOnce());
        mockedLog_3.verify(() -> Log_3.log_3(eq(x), eq(EPS)), Mockito.atLeastOnce());
    }
}

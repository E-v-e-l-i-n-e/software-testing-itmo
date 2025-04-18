import func.Func;
import logarithmic.Ln;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static logarithmic.Log_3.log_3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;

public class Log_3IntegrationTest {
    private static final double EPS = 1e-5;
    private static final double EPS2 = 1e-3;
    private static final MockedStatic<Ln> mocked = Mockito.mockStatic(Ln.class);

    @AfterAll
    static void closeMock() {
        mocked.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "log_3.csv", numLinesToSkip = 1)
    public void testMockedLog_3(double x, double selfExpected, double funcExpected) {
        mocked.when(() -> Ln.ln(anyDouble(), eq(EPS))).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);
            return Math.log(arg);
        });

        assertEquals(selfExpected, log_3(x, EPS), EPS2);
        assertEquals(funcExpected, Func.function(x, EPS), EPS2);
        mocked.verify(() -> log_3(anyDouble(), eq(EPS)), atLeastOnce());
    }
}
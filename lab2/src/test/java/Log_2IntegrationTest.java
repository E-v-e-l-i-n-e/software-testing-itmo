import func.Func;
import logarithmic.Ln;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static logarithmic.Log_2.log_2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mockStatic;

public class Log_2IntegrationTest {
    private static final double EPS = 1e-5;
    private static final double EPS2 = 1e-3;
    private static final MockedStatic<Ln> mocked = Mockito.mockStatic(Ln.class);

    @AfterAll
    static void closeMock() {
        mocked.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "log_2.csv", numLinesToSkip = 1)
    public void testMockedLog_2(double x, double selfExpected, double funcExpected) {
        mocked.when(() -> Ln.ln(anyDouble(), eq(EPS))).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);
            return Math.log(arg);
        });

        assertEquals(selfExpected, log_2(x, EPS), EPS2);
        assertEquals(funcExpected, Func.function(x, EPS), EPS2);
        mocked.verify(() -> log_2(anyDouble(), eq(EPS)), atLeastOnce());
    }
}
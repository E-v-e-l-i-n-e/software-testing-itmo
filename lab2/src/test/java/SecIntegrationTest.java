import func.Func;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import trigonometric.Sin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static trigonometric.Sec.sec;

public class SecIntegrationTest {
    private static final double EPS = 1e-7;
    private static final MockedStatic<Sin> mocked = Mockito.mockStatic(Sin.class);

    @AfterAll
    static void closeMock() {
        mocked.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "sec.csv", numLinesToSkip = 1)
    public void testMockedSec(double x, double selfExpected, double funcExpected) {
        mocked.when(() -> sec(anyDouble(), eq(EPS))).thenAnswer(invocation -> {
            double arg = invocation.getArgument(0);
            return Math.sin(arg);
        });

        if (Double.isNaN(funcExpected)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            assertEquals(selfExpected, sec(x, EPS), EPS);
            assertEquals(funcExpected, Func.function(x, EPS), EPS);
        }
        mocked.verify(() -> sec(anyDouble(), eq(EPS)), atLeastOnce());
    }
}

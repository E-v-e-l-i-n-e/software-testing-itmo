package top_down;

import func.Func;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import trigonometric.Cos;
import trigonometric.Sec;
import trigonometric.Tan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

public class AddSinCos {
    private static final double EPS = 1e-7;
    private MockedStatic<Tan> mockedTan;
    private MockedStatic<Sec> mockedSec;

    @AfterEach
    void closeMocks() {
        if (mockedTan != null) mockedTan.close();
        if (mockedSec != null) mockedSec.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "add_sin_cos.csv", numLinesToSkip = 1)
    void testFunctionWithPartialMocks(
            double x,
            double tanValue,
            double secValue,
            double expectedResult) {

        mockedTan = mockStatic(Tan.class);
        mockedSec = mockStatic(Sec.class);

        mockedTan.when(() -> Tan.tan(eq(x), eq(EPS))).thenReturn(tanValue);
        mockedSec.when(() -> Sec.sec(eq(x), eq(EPS))).thenReturn(secValue);

        double actualResult = Func.function(x, EPS);

        if (Double.isNaN(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            assertEquals(expectedResult, actualResult, EPS);
        }

        mockedTan.verify(() -> Tan.tan(eq(x), eq(EPS)), Mockito.atLeastOnce());
        mockedSec.verify(() -> Sec.sec(eq(x), eq(EPS)), Mockito.atLeastOnce());
    }
}

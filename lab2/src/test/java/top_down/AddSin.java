package top_down;

import func.Func;
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

public class AddSin {
    private static final double EPS = 1e-7;
    private MockedStatic<Cos> mockedCos;
    private MockedStatic<Tan> mockedTan;
    private MockedStatic<Sec> mockedSec;

    @AfterEach
    void closeMocks() {
        if (mockedCos != null) mockedCos.close();
        if (mockedTan != null) mockedTan.close();
        if (mockedSec != null) mockedSec.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "add_sinus.csv", numLinesToSkip = 1)
    void testFunctionWithPartialMocks(
            double x,
            double cosValue,
            double tanValue,
            double secValue,
            double expectedResult) {

        mockedCos = mockStatic(Cos.class);
        mockedTan = mockStatic(Tan.class);
        mockedSec = mockStatic(Sec.class);

        mockedCos.when(() -> Cos.cos(eq(x), eq(EPS))).thenReturn(cosValue);
        mockedTan.when(() -> Tan.tan(eq(x), eq(EPS))).thenReturn(tanValue);
        mockedSec.when(() -> Sec.sec(eq(x), eq(EPS))).thenReturn(secValue);

        double actualResult = Func.function(x, EPS);

        if (Double.isNaN(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            assertEquals(expectedResult, actualResult, EPS);
        }

        mockedCos.verify(() -> Cos.cos(eq(x), eq(EPS)), Mockito.atLeastOnce());
        mockedTan.verify(() -> Tan.tan(eq(x), eq(EPS)), Mockito.atLeastOnce());
        mockedSec.verify(() -> Sec.sec(eq(x), eq(EPS)), Mockito.atLeastOnce());
    }
}
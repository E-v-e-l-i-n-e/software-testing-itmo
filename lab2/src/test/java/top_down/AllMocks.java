package top_down;

import func.Func;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import trigonometric.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

public class AllMocks {
    private static final double EPS = 1e-7;
    private MockedStatic<Sin> mockedSin;
    private MockedStatic<Cos> mockedCos;
    private MockedStatic<Tan> mockedTan;
    private MockedStatic<Sec> mockedSec;

    @AfterEach
    void closeMocks() {
        if (mockedSin != null) mockedSin.close();
        if (mockedCos != null) mockedCos.close();
        if (mockedTan != null) mockedTan.close();
        if (mockedSec != null) mockedSec.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "all_mocks.csv", numLinesToSkip = 1)
    void testFunctionWithMocks(
            double x,
            double sinValue,
            double cosValue,
            double tanValue,
            double secValue,
            double expectedResult) {

        mockedSin = mockStatic(Sin.class);
        mockedCos = mockStatic(Cos.class);
        mockedTan = mockStatic(Tan.class);
        mockedSec = mockStatic(Sec.class);

        mockedSin.when(() -> Sin.sin(eq(x), eq(EPS))).thenReturn(sinValue);
        mockedCos.when(() -> Cos.cos(eq(x), eq(EPS))).thenReturn(cosValue);
        mockedTan.when(() -> Tan.tan(eq(x), eq(EPS))).thenReturn(tanValue);
        mockedSec.when(() -> Sec.sec(eq(x), eq(EPS))).thenReturn(secValue);

        if (Double.isNaN(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            assertEquals(expectedResult, Func.function(x, EPS), EPS);
        }

        mockedSin.verify(() -> Sin.sin(eq(x), eq(EPS)), Mockito.atLeastOnce());
        mockedCos.verify(() -> Cos.cos(eq(x), eq(EPS)), Mockito.atLeastOnce());
        mockedTan.verify(() -> Tan.tan(eq(x), eq(EPS)), Mockito.atLeastOnce());
        mockedSec.verify(() -> Sec.sec(eq(x), eq(EPS)), Mockito.atLeastOnce());
    }
}
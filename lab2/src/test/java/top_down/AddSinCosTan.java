package top_down;

import func.Func;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import trigonometric.Sec;
import trigonometric.Tan;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

public class AddSinCosTan {
    private static final double EPS = 1e-7;
    private MockedStatic<Sec> mockedSec;

    @AfterEach
    void closeMocks() {
        if (mockedSec != null) mockedSec.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "add_sin_cos_tan.csv", numLinesToSkip = 1)
    void testFunctionWithPartialMocks(
            double x,
            double secValue,
            double expectedResult) {

        mockedSec = mockStatic(Sec.class);

        mockedSec.when(() -> Sec.sec(eq(x), eq(EPS))).thenReturn(secValue);

        double actualResult = Func.function(x, EPS);

        if (Double.isNaN(expectedResult)) {
            assertThrows(IllegalArgumentException.class, () -> Func.function(x, EPS));
        } else {
            assertEquals(expectedResult, actualResult, EPS);
        }

        mockedSec.verify(() -> Sec.sec(eq(x), eq(EPS)), Mockito.atLeastOnce());
    }
}

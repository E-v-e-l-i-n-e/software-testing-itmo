package logarithmic;

import trigonometric.Sin;

public class Ln {
    public static double ln(double x, double eps) {
        if (x <= 0) throw new IllegalArgumentException("x должен быть положительным");
        if (x > 2) {
            return -ln(1/x, eps);
        }
        double result = 0;
        int n = 1;
        double term = x - 1;
        while (Math.abs(term) > eps) {
            term = Math.pow(-1, n + 1) * Math.pow(x - 1, n ) / n;
            result += term;
            n++;
        }
        return result;
    }
}

package trigonometric;


public class Sin {

    public static double sin(double x, double eps) {
        x = normalizeAngle(x);
        double result = 0;
        int n = 0;
        double term = x;
        while (Math.abs(term) > eps) {
            term = Math.pow(-1,n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
            result += term;
            n++;
        }
        return result;
    }


    public static double factorial(int number) {
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }

    private static double normalizeAngle(double x) {
        x = x % (2 * Math.PI);
        if (x > Math.PI) x -= 2 * Math.PI;
        if (x < -Math.PI) x += 2 * Math.PI;
        return x;
    }


}

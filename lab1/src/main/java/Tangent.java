public class Tangent {

    private final double[] bernoulliNumbers = {
            1.0/6.0, -1.0/30.0, 1.0/42.0, -1.0/30.0, 5.0/66.0, -691.0/2730.0, 7.0/6.0
    };

    private double factorial(int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double tangent(double x, int count){

        if (Double.isInfinite(x) || Double.isNaN(x)) {
            throw new IllegalArgumentException("x не может быть Infinity или NaN");
        }

        x = x % Math.PI;
        if (x < -Math.PI / 2) {
            x += Math.PI;
        } else if (x > Math.PI / 2) {
            x -= Math.PI;
        }
        if (Math.abs(x) >= Math.PI / 2)
            throw new IllegalArgumentException("Тангенс не сходится");

        if (count > 7) count = 7;

        double result = 0;
        for (int i = 0; i < count; i++) {
            result += bernoulliNumbers[i] *  Math.pow(-4, i + 1) * (1 - Math.pow(4, i + 1)) * Math.pow(x, 2 * (i + 1) - 1) / factorial(2 * (i + 1));

        }
        return result;
    }

//    public static void main(String[] args) {
//        for (double x = -Math.PI/2 + 0.1; x < Math.PI/2; x += 0.1) {
//            Tangent tangent = new Tangent();
//            double result = tangent.tangent(x, 7);
//
//            System.out.printf("%6.1f  | %8.6f | %8.6f  \n", x, result, Math.tan(x));
//        }
//    }
}

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

import static func.Func.function;
import static logarithmic.Log_2.log_2;
import static logarithmic.Log_3.log_3;
import static trigonometric.Cos.cos;
import static trigonometric.Sec.sec;
import static trigonometric.Tan.tan;

public class Main {
    private static final String CSV_FILE_PATH = "testing_lab2_output.csv";
    private static final double EPS = 1e-7;

    public static void outputCsv() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.println("x,y");

            for (double x = -60.0; x <= 3.5; x += 0.0001) {
                double funcExpected = function(x, EPS);
                writer.printf("%f,%f%n", x, funcExpected);
                if (x % 10 == 0)
                    System.out.println("Ура, осталось недолго!!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        outputCsv();
//        double eps = 1e-7;
//        Double[] xValues = {-Math.PI/6, -5*Math.PI/6, -5.68251, -3.74227, -3.0};
//        for(Double x: xValues) {
//            System.out.println(x + ", " + tan(x, eps) + ", " + func.Func.function(x, eps));
//        }
    }
}

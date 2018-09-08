
import java.util.Scanner;
import java.math.*;

public class ecuacion_cuadratica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa coeficiente cuadratico");
        double a = sc.nextDouble();
        System.out.println("Ingresa coeficiente lineal");
        double b = sc.nextDouble();
        System.out.println("Ingresa constante");
        double c = sc.nextDouble();
        double disc = Math.pow(b, 2) - 4 * a * c;
        if (a != 0) {
            if (disc < 0) {
                System.out.println("Tiene raices imaginarias");
            } else {
                double x1 = (-b + Math.sqrt(disc)) / (2 * a);
                double x2 = (-b - Math.sqrt(disc)) / (2 * a);
                System.out.println("X1 = " + x1 + " X2 = " + x2);
            }
        } else {
            System.out.println("El coeficiente cuadratico debe ser diferente de 0");
        }
    }
}

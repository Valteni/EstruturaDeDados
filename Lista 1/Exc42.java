import java.util.Scanner;
import static java.lang.Math.*;

public class Exc42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double angulo, rang;
        
        System.out.print("\nDigite um angulo em graus: ");
        angulo = scanner.nextDouble();
        
        rang = angulo * PI / 180;
        
        System.out.println("\nSeno: " + sin(rang));
        System.out.println("Co-seno: " + cos(rang));
        System.out.println("Tangente: " + tan(rang));
        System.out.println("Co-secante: " + (1 / sin(rang)));
        System.out.println("Secante: " + (1 / cos(rang)));
        System.out.println("Cotangente: " + (1 / tan(rang)));
        System.out.println();
    }
}
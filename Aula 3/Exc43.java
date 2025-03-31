import java.util.Scanner;
import static java.lang.Math.*;

public class Exc43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num, logaritmo;
        
        System.out.print("\nEntre com o logaritmando: ");
        num = scanner.nextDouble();
        
        logaritmo = log10(num);
        System.out.println("\nLogaritmo: " + logaritmo);
        System.out.println();
    }
}
import java.util.Scanner;
import static java.lang.Math.*;

public class Exc44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num, base, logaritmo;
        
        System.out.print("\nEntre com o logaritmando: ");
        num = scanner.nextDouble();
        
        System.out.print("\nEntre com a base: ");
        base = scanner.nextDouble();
        
        logaritmo = log(num) / log(base);
        
        System.out.println("\nO logaritmo de " + num + " na base " + base + " é: " + logaritmo);
        System.out.println();
    }
}
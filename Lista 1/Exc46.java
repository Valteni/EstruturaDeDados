import java.util.Scanner;

public class Exc46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo, nsaldo;
        
        System.out.print("\nDigite saldo: ");
        saldo = scanner.nextDouble();
        
        nsaldo = saldo * 1.01;
        
        System.out.println("\nNovo saldo: " + nsaldo);
        System.out.println();
    }
}
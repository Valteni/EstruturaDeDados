import java.util.Scanner;

public class Exc23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, d;
        
        System.out.print("\nDigite numero de tres casas: ");
        a = scanner.nextInt();
        
        d = (a % 100) / 10;
        
        System.out.println("\nalgarismo da casa das dezenas: " + d);
        System.out.println(" ");
    }
}
import java.util.Scanner;

public class Exc460 {    
    public static int dobro(int numero) {
        return numero * 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2, num3;

        System.out.print("Digite o primeiro número: ");
        num1 = input.nextInt();
        System.out.print("Digite o segundo número: ");
        num2 = input.nextInt();
        System.out.print("Digite o terceiro número: ");
        num3 = input.nextInt();

        
        System.out.println("\nDobro do primeiro número: " + dobro(num1));
        System.out.println("Dobro do segundo número: " + dobro(num2));
        System.out.println("Dobro do terceiro número: " + dobro(num3));
    }
}
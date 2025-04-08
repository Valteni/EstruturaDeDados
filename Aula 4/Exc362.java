import java.util.Scanner;
import java.util.HashSet;

public class Exc362 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vet1 = new int[10];
        int[] vet2 = new int[20];
        HashSet<Integer> comuns = new HashSet<>();
        
        System.out.println("\nEntrada de dados do vetor 1 (10 elementos)");
        for (int i = 0; i < 10; i++) {
            System.out.print("Entre com o " + (i + 1) + " elemento: ");
            vet1[i] = scanner.nextInt();
        }
        
        System.out.println("\nEntrada de dados do vetor 2 (20 elementos)");
        for (int i = 0; i < 20; i++) {
            System.out.print("Entre com o " + (i + 1) + " elemento: ");
            vet2[i] = scanner.nextInt();
        }
        
        for (int valor : vet1) {
            for (int valor2 : vet2) {
                if (valor == valor2) {
                    comuns.add(valor);
                    break;
                }
            }
        }
        
        if (!comuns.isEmpty()) {
            System.out.println("\n\nElementos comuns:\n");
            for (int num : comuns) {
                System.out.println(num);
            }
        } else {
            System.out.println("\n\nNão existem elementos comuns");
        }
        System.out.println();
    }
}
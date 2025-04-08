import java.util.Scanner;

public class Exc413 {
    public static void main(String[] args) {
        int[][] n = new int[5][5];
        int soma = 0;
        Scanner scanner = new Scanner(System.in);

        for (int L = 0; L < 5; L++) {
            for (int C = 0; C < 5; C++) {
                System.out.print("Digite o elemento [" + L + "][" + C + "]: ");
                n[L][C] = scanner.nextInt();
            }
        }

        System.out.println("\nToda a matriz:");
        for (int L = 0; L < 5; L++) {
            for (int C = 0; C < 5; C++) {
                System.out.print(n[L][C] + "\t");
            }
            System.out.println();
        }

        for (int L = 0; L < 5; L++) {
            for (int C = 0; C < 5; C++) {
                if (L + C > 4 && n[L][C] % 2 != 0) {
                    soma += n[L][C] * n[L][C];
                }
            }
        }

        double raiz = Math.sqrt(soma);
        System.out.printf("\nRaiz quadrada da soma dos quadrados dos ímpares abaixo da diagonal secundária: %.2f\n", raiz);

        scanner.close();
    }
}

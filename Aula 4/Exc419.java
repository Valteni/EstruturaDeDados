import java.util.Scanner;

public class Exc419 {
    public static void main(String[] args) {
        int[][] A = new int[5][5];
        int[][] B = new int[5][5];
        int[][] DIF = new int[5][5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos da matriz A:");
        for (int L = 0; L < 5; L++) {
            for (int C = 0; C < 5; C++) {
                System.out.print("A[" + (L + 1) + "][" + (C + 1) + "]: ");
                A[L][C] = scanner.nextInt();
            }
        }

        System.out.println("\nDigite os elementos da matriz B:");
        for (int L = 0; L < 5; L++) {
            for (int C = 0; C < 5; C++) {
                System.out.print("B[" + (L + 1) + "][" + (C + 1) + "]: ");
                B[L][C] = scanner.nextInt();
                DIF[L][C] = A[L][C] - B[L][C];
            }
        }

        System.out.println("\n\tMATRIZ DIFERENÇA:");
        for (int L = 0; L < 5; L++) {
            for (int C = 0; C < 5; C++) {
                System.out.print("\t" + DIF[L][C]);
            }
            System.out.println();
        }

        scanner.close();
    }
}

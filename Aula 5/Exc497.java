import java.util.Scanner;

public class Exc497 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[10];
        int n, c;

        for (int L = 0; L < 10; L++) {
            System.out.print("Digite número " + (L + 1) + ": ");
            num[L] = scanner.nextInt();
        }

        System.out.print("Digite número de busca: ");
        n = scanner.nextInt();

        ordena(num, 10);

        c = busca(num, 10, n);

        System.out.println("\nVETOR:");
        for (int L = 0; L < 10; L++) {
            System.out.println((L + 1) + " - " + num[L]);
        }

        if (c >= 0) {
            System.out.println("\nPosição no vetor: " + (c + 1));
        } else {
            System.out.println("\nNÃO ENCONTRADO");
        }

        scanner.close();
    }

    public static void ordena(int[] vet, int tam) {
        int aux;
        for (int L1 = 0; L1 < tam - 1; L1++) {
            for (int C1 = L1 + 1; C1 < tam; C1++) {
                if (vet[L1] > vet[C1]) {
                    aux = vet[L1];
                    vet[L1] = vet[C1];
                    vet[C1] = aux;
                }
            }
        }
    }

    public static int busca(int[] vet, int tam, int chave) {
        int ini = 0, fim = tam - 1, meio;

        while (ini <= fim) {
            meio = (ini + fim) / 2;

            if (chave == vet[meio]) {
                return meio;
            } else if (chave < vet[meio]) {
                fim = meio - 1;
            } else {
                ini = meio + 1;
            }
        }

        return -1;
    }
}

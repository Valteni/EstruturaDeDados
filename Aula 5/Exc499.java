import java.util.Scanner;

public class Exc499 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] num = new int[5];
        int op, flag = 0;

        for (int i = 0; i < 5; i++) {
            num[i] = 0;
        }

        do {
            System.out.println("\n\n\nMENU VETOR - FUNCAO");
            System.out.println("1 Dados do VETOR");
            System.out.println("2 Ordena VETOR");
            System.out.println("3 Imprime VETOR");
            System.out.println("4 Sai do programa");
            System.out.print("OPCAO: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    entrada(num);
                    flag = 1;
                    break;
                case 2:
                    if (flag == 1) {
                        ordena(num);
                    } else {
                        System.out.println("\nEscolha primeiro opcao 1!");
                    }
                    break;
                case 3:
                    if (flag == 1) {
                        imprime(num);
                    } else {
                        System.out.println("\nEscolha primeiro opcao 1!");
                    }
                    break;
                case 4:
                    System.out.println("Saindo do algoritmo...");
                    break;
                default:
                    System.out.println("\nOpcao invalida!");
                    break;
            }
        } while (op != 4);
    }

    public static void entrada(int[] vet) {
        System.out.println("\nEntrada do VETOR:");
        for (int i = 0; i < vet.length; i++) {
            System.out.print("Digite numero " + (i + 1) + ": ");
            vet[i] = sc.nextInt();
        }
    }

    public static void imprime(int[] vet) {
        System.out.println("\nVETOR:");
        for (int i = 0; i < vet.length; i++) {
            System.out.println((i + 1) + " - " + vet[i]);
        }
    }

    public static void ordena(int[] vet) {
        int aux;
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = i + 1; j < vet.length; j++) {
                if (vet[i] > vet[j]) {
                    aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                }
            }
        }
    }
}

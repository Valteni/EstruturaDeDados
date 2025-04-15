import java.util.Scanner;

public class Exc500 {

  private static final int TAMANHO = 5;
  private static int[] num = new int[TAMANHO];
  private static int[] num1 = new int[TAMANHO];
  private static int L, flag, flag1, op;
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    while (true) {
      mostrarMenu();
      op = scanner.nextInt();

      switch (op) {
        case 1:
          entradaDados(num, TAMANHO, "A");
          flag = 1;
          break;
        case 2:
          entradaDados(num1, TAMANHO, "B");
          flag1 = 1;
          break;
        case 3:
          if (flag == 1 && flag1 == 1) {
            imprimirDados(num, TAMANHO, "A");
            imprimirDados(num1, TAMANHO, "B");
          } else {
            System.out.println("\nÉ necessário digitar os dados dos vetores A e B antes de imprimi-los.");
          }
          break;
        case 4:
          if (flag == 1 && flag1 == 1) {
            somaVetores(num, num1, TAMANHO);
          } else {
            System.out.println("\nÉ necessário digitar os dados dos vetores A e B antes de somá-los.");
          }
          break;
        case 5:
          if (flag == 1 && flag1 == 1) {
            subtraiVetores(num, num1, TAMANHO);
          } else {
            System.out.println("\nÉ necessário digitar os dados dos vetores A e B antes de subtraí-los.");
          }
          break;
        case 6:
          System.out.println("\nSaindo do programa...");
          return;
        default:
          System.out.println("\nOpção inválida. Digite um número entre 1 e 6.");
      }
    }
  }

  private static void mostrarMenu() {
    System.out.println("\n\n\n");
    System.out.println("----- MENU -----");
    System.out.println("1. Digitar dados do vetor A");
    System.out.println("2. Digitar dados do vetor B");
    System.out.println("3. Imprimir dados dos vetores");
    System.out.println("4. Somar vetores");
    System.out.println("5. Subtrair vetores");
    System.out.println("6. Sair do programa");
    System.out.print("Digite a opção desejada: ");
  }

  private static void entradaDados(int[] vetor, int tamanho, String nomeVetor) {
    for (L = 0; L < tamanho; L++) {
      System.out.printf("Digite o %dº número do vetor %s: ", L + 1, nomeVetor);
      vetor[L] = scanner.nextInt();
    }
  }

  private static void imprimirDados(int[] vetor, int tamanho, String nomeVetor) {
    System.out.printf("\nVetor %s:\n", nomeVetor);
    for (L = 0; L < tamanho; L++) {
      System.out.printf("%dº número: %d\n", L + 1, vetor[L]);
    }
  }

  private static void somaVetores(int[] vetorA, int[] vetorB, int tamanho) {
    System.out.println("\nSOMA DOS VETORES:");
    for (L = 0; L < tamanho; L++) {
      System.out.printf("%dº número: %d\n", L + 1, vetorA[L] + vetorB[L]);
    }
  }

  private static void subtraiVetores(int[] vetorA, int[] vetorB, int tamanho) {
    System.out.println("\nSUBTRAÇÃO DOS VETORES:");
    for (L = 0; L < tamanho; L++) {
      System.out.printf("%dº número: %d\n", L + 1, vetorA[L] - vetorB[L]);
    }
  }
}
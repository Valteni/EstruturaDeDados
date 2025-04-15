import java.util.Scanner;

public class Exc495 {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome [" + (i + 1) + "]: ");
            nomes[i] = scanner.nextLine();
        }
        ordenarNomes(nomes, 5);

        System.out.println("\n\nNOMES ORDENADOS:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + nomes[i]);
        }

        scanner.close();
    }

    public static void ordenarNomes(String[] vet, int tam) {
        String aux;
        for (int i = 0; i < tam - 1; i++) {
            for (int j = i + 1; j < tam; j++) {
                if (vet[i].compareToIgnoreCase(vet[j]) > 0) {
                    aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                }
            }
        }
    }
}

import java.util.Scanner;

public class Exc370 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int MAX_VOOS = 1000;
        int[] lugares = new int[MAX_VOOS];
        String[] voos = new String[MAX_VOOS];
        
        System.out.print("\nEntre com o número de voos: ");
        int numVoos = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numVoos; i++) {
            System.out.print("\nEntre com a identificação do voo " + (i + 1) + ": ");
            voos[i] = scanner.nextLine();
            
            System.out.print("Entre com a quantidade de lugares disponíveis no voo " + voos[i] + ": ");
            lugares[i] = scanner.nextInt();
            scanner.nextLine();
        }
        
        System.out.print("\nEntre com o número do voo desejado ou 0 para terminar: ");
        String numeroVoo = scanner.nextLine();
        
        while (!numeroVoo.equals("0")) {
            boolean vooEncontrado = false;
            
            for (int i = 0; i < numVoos; i++) {
                if (voos[i].equals(numeroVoo)) {
                    vooEncontrado = true;
                    
                    if (lugares[i] > 0) {
                        lugares[i]--;
                        System.out.print("\nQual o número da identidade do cliente? ");
                        String id = scanner.nextLine();
                        
                        System.out.println("\nIdentidade: " + id + " Voo: " + numeroVoo);
                    } else {
                        System.out.println("\nNão existem mais lugares neste voo.");
                    }
                    break;
                }
            }
            
            if (!vooEncontrado) {
                System.out.println("\nNão existe este voo.");
            }
            
            System.out.print("\n\nEntre com o número do voo desejado ou 0 para terminar: ");
            numeroVoo = scanner.nextLine();
        }
        
        System.out.println("\nSistema encerrado.");
    }
}
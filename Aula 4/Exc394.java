import java.util.Scanner;

public class Exc394 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_ALUNOS = 50;
        
        String[] nomes = new String[MAX_ALUNOS];
        double[] nota1 = new double[MAX_ALUNOS];
        double[] nota2 = new double[MAX_ALUNOS];
        double[] media = new double[MAX_ALUNOS];
        
        boolean hasNames = false;
        boolean hasNota1 = false;
        boolean hasNota2 = false;
        
        String opcao;
        
        do {
            System.out.println("\n\nMENU");
            System.out.println("1 - ENTRAR NOMES");
            System.out.println("2 - ENTRAR 1 NOTA");
            System.out.println("3 - ENTRAR 2 NOTA");
            System.out.println("4 - CALCULAR MEDIA");
            System.out.println("5 - LISTAR NO DISPLAY");
            System.out.println("6 - SAIR");
            System.out.print("OPCAO: ");
            opcao = scanner.nextLine();
            
            switch (opcao) {
                case "1":
                    System.out.println("\nCadastro de Nomes:");
                    for (int i = 0; i < MAX_ALUNOS; i++) {
                        System.out.print("Digite " + (i+1) + " nome (máximo 30 caracteres): ");
                        nomes[i] = scanner.nextLine().toUpperCase();
                        
                        while (nomes[i].length() > 30) {
                            System.out.print("Nome muito longo. Digite novamente (máximo 30 caracteres): ");
                            nomes[i] = scanner.nextLine().toUpperCase();
                        }

                        if (nomes[i].length() < 30) {
                            nomes[i] = String.format("%-30s", nomes[i]);
                        }
                    }
                    hasNames = true;
                    break;
                    
                case "2":
                    if (!hasNames) {
                        System.out.println("\nNÃO TEM NOME CADASTRADO");
                        break;
                    }
                    System.out.println("\nCadastro da Primeira Nota (Peso 3):");
                    for (int i = 0; i < MAX_ALUNOS; i++) {
                        System.out.print("Digite 1 nota para " + nomes[i].trim() + ": ");
                        nota1[i] = scanner.nextDouble();
                        scanner.nextLine(); 
                    }
                    hasNota1 = true;
                    break;
                    
                case "3":
                    if (!hasNames) {
                        System.out.println("\nNÃO TEM NOME CADASTRADO");
                        break;
                    }
                    System.out.println("\nCadastro da Segunda Nota (Peso 7):");
                    for (int i = 0; i < MAX_ALUNOS; i++) {
                        System.out.print("Digite 2 nota para " + nomes[i].trim() + ": ");
                        nota2[i] = scanner.nextDouble();
                        scanner.nextLine();
                    }
                    hasNota2 = true;
                    break;
                    
                case "4":
                    if (!hasNames || !hasNota1 || !hasNota2) {
                        System.out.println("\nNEM TODOS OS DADOS ESTÃO CADASTRADOS");
                        break;
                    }
                    for (int i = 0; i < MAX_ALUNOS; i++) {
                        media[i] = (3 * nota1[i] + 7 * nota2[i]) / 10;
                    }
                    System.out.println("\nMédias calculadas com sucesso!");
                    break;
                    
                case "5":
                    if (!hasNames || !hasNota1 || !hasNota2) {
                        System.out.println("\nNEM TODOS OS DADOS ESTÃO CADASTRADOS");
                        break;
                    }
                    System.out.println("\nNOME\t\t\t\tNOTA1\tNOTA2\tMEDIA");
                    for (int i = 0; i < MAX_ALUNOS; i++) {
                        System.out.printf("%-30s\t%.1f\t%.1f\t%.1f%n", 
                        nomes[i].trim(), nota1[i], nota2[i], media[i]);
                    }
                    break;
                    
                case "6":
                    System.out.println("\nSaindo do sistema...");
                    break;
                    
                default:
                    System.out.println("\nOPÇÃO NÃO DISPONÍVEL");
            }
        } while (!opcao.equals("6"));
        
        scanner.close();
    }
}
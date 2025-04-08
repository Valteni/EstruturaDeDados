import java.util.Scanner;

public class Exc400 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUM_QUARTOS = 50;
        
        int[] leitos = new int[NUM_QUARTOS];
        double[] precos = new double[NUM_QUARTOS];
        String[] situacao = new String[NUM_QUARTOS];
        String[] dataEntrada = new String[NUM_QUARTOS];
        String[] dataSaida = new String[NUM_QUARTOS];
        int[] numDiarias = new int[NUM_QUARTOS];
        double[] despesas = new double[NUM_QUARTOS];
        String[] nomes = new String[NUM_QUARTOS];
        String[] telefones = new String[NUM_QUARTOS];
        
        boolean cadastrado = false;
        int opcao;
        
        do {
            System.out.println("\n\nHotel Fazenda Sucesso");
            System.out.println("1. Cadastrar quartos");
            System.out.println("2. Listar todos os quartos");
            System.out.println("3. Listar quartos desocupados");
            System.out.println("4. Alugar/Reservar quarto");
            System.out.println("5. Registrar despesas extras");
            System.out.println("6. Calcular despesa do quarto");
            System.out.println("7. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    if (cadastrado) {
                        System.out.println("\nAtenção. Dados já cadastrados!");
                    } else {
                        for (int i = 0; i < NUM_QUARTOS; i++) {
                            System.out.printf("\nQuarto %d:", i+1);
                            System.out.print("\nQuantidade de leitos: ");
                            leitos[i] = scanner.nextInt();
                            System.out.print("Preço do quarto: ");
                            precos[i] = scanner.nextDouble();
                            scanner.nextLine();
                            
                            situacao[i] = "L";
                            dataEntrada[i] = "XXXX";
                            dataSaida[i] = "XXXX";
                            numDiarias[i] = 0;
                            despesas[i] = 0.0;
                            nomes[i] = "";
                            telefones[i] = "";
                        }
                        cadastrado = true;
                        System.out.println("\nCadastro concluído!");
                    }
                    break;
                    
                case 2:
                    if (!cadastrado) {
                        System.out.println("\nEscolha a opção 1 primeiro!");
                        break;
                    }
                    for (int i = 0; i < NUM_QUARTOS; i++) {
                        System.out.printf("\nQuarto %d:", i+1);
                        System.out.println("\nSituação: " + (situacao[i].equals("L") ? "Livre" : 
                        situacao[i].equals("A") ? "Alugado" : "Reservado"));
                        
                        if (situacao[i].equals("A") || situacao[i].equals("R")) {
                            System.out.println("Hóspede: " + nomes[i]);
                            System.out.println("Telefone: " + telefones[i]);
                        }
                        System.out.println("Leitos: " + leitos[i]);
                        System.out.printf("Preço: R$ %.2f%n", precos[i]);
                        System.out.printf("Despesas: R$ %.2f%n", despesas[i]);
                        System.out.println("Data entrada: " + dataEntrada[i]);
                        System.out.println("Data saída: " + dataSaida[i]);
                        System.out.println("Dias reservados: " + numDiarias[i]);
                        
                        System.out.print("\nPressione Enter para continuar...");
                        scanner.nextLine();
                    }
                    break;
                    
                case 3:
                    if (!cadastrado) {
                        System.out.println("\nEscolha a opção 1 primeiro!");
                        break;
                    }
                    for (int i = 0; i < NUM_QUARTOS; i++) {
                        if (situacao[i].equals("L")) {
                            System.out.printf("\nQuarto %d:", i+1);
                            System.out.println("\nLeitos: " + leitos[i]);
                            System.out.printf("Preço: R$ %.2f%n", precos[i]);
                        }
                    }
                    System.out.print("\nPressione Enter para continuar...");
                    scanner.nextLine();
                    break;
                    
                case 4:
                    if (!cadastrado) {
                        System.out.println("\nEscolha a opção 1 primeiro!");
                        break;
                    }
                    System.out.print("\nAlugar (A) ou Reservar (R)? ");
                    String tipo = scanner.nextLine().toUpperCase();
                    
                    while (!tipo.equals("A") && !tipo.equals("R")) {
                        System.out.print("Resposta inválida. Digite A (aluguel) ou R (reserva): ");
                        tipo = scanner.nextLine().toUpperCase();
                    }
                    
                    if (tipo.equals("A")) {
                        System.out.print("Tem reserva? (S/N): ");
                        String temReserva = scanner.nextLine().toUpperCase();
                        
                        if (temReserva.equals("S")) {
                            System.out.print("Entre com o nome: ");
                            String nomeHospede = scanner.nextLine();
                            
                            int quartoReservado = -1;
                            for (int i = 0; i < NUM_QUARTOS; i++) {
                                if (nomes[i].equalsIgnoreCase(nomeHospede) && situacao[i].equals("R")) {
                                    quartoReservado = i;
                                    break;
                                }
                            }
                            
                            if (quartoReservado != -1) {
                                situacao[quartoReservado] = "A";
                                despesas[quartoReservado] = 0.0;
                                System.out.print("Data de entrada: ");
                                dataEntrada[quartoReservado] = scanner.nextLine();
                                System.out.print("Data de saída: ");
                                dataSaida[quartoReservado] = scanner.nextLine();
                                System.out.print("Número de diárias: ");
                                numDiarias[quartoReservado] = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Quarto alugado com sucesso!");
                            } else {
                                System.out.println("Reserva não encontrada!");
                                temReserva = "N";
                            }
                        }
                        
                        if (temReserva.equals("N")) {
                            System.out.println("\nQuartos disponíveis:");
                            for (int i = 0; i < NUM_QUARTOS; i++) {
                                if (situacao[i].equals("L")) {
                                    System.out.printf("Quarto %d - %d leitos - R$ %.2f%n", 
                                                    i+1, leitos[i], precos[i]);
                                }
                            }
                            
                            System.out.print("\nDigite o número do quarto: ");
                            int quarto = scanner.nextInt();
                            scanner.nextLine();
                            
                            while (quarto < 1 || quarto > NUM_QUARTOS || !situacao[quarto-1].equals("L")) {
                                System.out.print("Quarto inválido ou ocupado. Digite novamente: ");
                                quarto = scanner.nextInt();
                                scanner.nextLine();
                            }
                            
                            situacao[quarto-1] = "A";
                            despesas[quarto-1] = 0.0;
                            System.out.print("Nome do hóspede: ");
                            nomes[quarto-1] = scanner.nextLine();
                            System.out.print("Telefone: ");
                            telefones[quarto-1] = scanner.nextLine();
                            System.out.print("Data de entrada: ");
                            dataEntrada[quarto-1] = scanner.nextLine();
                            System.out.print("Data de saída: ");
                            dataSaida[quarto-1] = scanner.nextLine();
                            System.out.print("Número de diárias: ");
                            numDiarias[quarto-1] = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Quarto alugado com sucesso!");
                        }
                    } else {
                        System.out.println("\nQuartos disponíveis para reserva:");
                        for (int i = 0; i < NUM_QUARTOS; i++) {
                            if (situacao[i].equals("L")) {
                                System.out.printf("Quarto %d - %d leitos - R$ %.2f%n", 
                                                i+1, leitos[i], precos[i]);
                            }
                        }
                        
                        System.out.print("\nDigite o número do quarto: ");
                        int quarto = scanner.nextInt();
                        scanner.nextLine();
                        
                        while (quarto < 1 || quarto > NUM_QUARTOS || !situacao[quarto-1].equals("L")) {
                            System.out.print("Quarto inválido ou ocupado. Digite novamente: ");
                            quarto = scanner.nextInt();
                            scanner.nextLine();
                        }
                        
                        situacao[quarto-1] = "R";
                        System.out.print("Nome do hóspede: ");
                        nomes[quarto-1] = scanner.nextLine();
                        System.out.print("Telefone: ");
                        telefones[quarto-1] = scanner.nextLine();
                        System.out.print("Data de entrada: ");
                        dataEntrada[quarto-1] = scanner.nextLine();
                        System.out.print("Data de saída: ");
                        dataSaida[quarto-1] = scanner.nextLine();
                        System.out.print("Número de diárias: ");
                        numDiarias[quarto-1] = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Quarto reservado com sucesso!");
                    }
                    break;
                    
                case 5:
                    if (!cadastrado) {
                        System.out.println("\nEscolha a opção 1 primeiro!");
                        break;
                    }
                    System.out.print("\nNúmero do quarto: ");
                    int quartoDespesa = scanner.nextInt();
                    scanner.nextLine();
                    
                    while (quartoDespesa < 1 || quartoDespesa > NUM_QUARTOS) {
                        System.out.print("Número inválido. Digite novamente: ");
                        quartoDespesa = scanner.nextInt();
                        scanner.nextLine();
                    }
                    
                    if (situacao[quartoDespesa-1].equals("A")) {
                        System.out.print("Valor das despesas: R$ ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        despesas[quartoDespesa-1] += valor;
                        System.out.println("Despesas registradas com sucesso!");
                    } else {
                        System.out.println("Este quarto não está alugado no momento!");
                    }
                    break;
                    
                case 6:
                    if (!cadastrado) {
                        System.out.println("\nEscolha a opção 1 primeiro!");
                        break;
                    }
                    System.out.print("\nNúmero do quarto: ");
                    int quartoCheckout = scanner.nextInt();
                    scanner.nextLine();
                    
                    while (quartoCheckout < 1 || quartoCheckout > NUM_QUARTOS) {
                        System.out.print("Número inválido. Digite novamente: ");
                        quartoCheckout = scanner.nextInt();
                        scanner.nextLine();
                    }
                    
                    if (situacao[quartoCheckout-1].equals("A")) {
                        double total = (precos[quartoCheckout-1] * numDiarias[quartoCheckout-1]) + despesas[quartoCheckout-1];
                        System.out.printf("\nTotal a pagar: R$ %.2f%n", total);
                        
                        situacao[quartoCheckout-1] = "L";
                        despesas[quartoCheckout-1] = 0.0;
                        dataEntrada[quartoCheckout-1] = "XXXX";
                        dataSaida[quartoCheckout-1] = "XXXX";
                        numDiarias[quartoCheckout-1] = 0;
                        nomes[quartoCheckout-1] = "";
                        telefones[quartoCheckout-1] = "";
                        
                        System.out.println("Quarto liberado com sucesso!");
                    } else {
                        System.out.println("Este quarto não está alugado no momento!");
                    }
                    break;
                    
                case 7:
                    System.out.println("\nSaindo do sistema...");
                    break;
                    
                default:
                    System.out.println("\nOpção não disponível!");
            }
        } while (opcao != 7);
        
        scanner.close();
    }
}
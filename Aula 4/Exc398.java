import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Exc398 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_PRODUTOS = 50;
        
        int[] codigos = new int[MAX_PRODUTOS];
        int[] quantidades = new int[MAX_PRODUTOS];
        double[] precos = new double[MAX_PRODUTOS];
        double totalVendas = 0.0;
        int k = 0;
        
        System.out.println("CADASTRO DE PRODUTOS (Digite -1 para encerrar)");
        while (k < MAX_PRODUTOS) {
            System.out.print("\nDigite o código do produto ou -1 para encerrar: ");
            int codigo = scanner.nextInt();
            
            if (codigo == -1) break;
            
            codigos[k] = codigo;
            
            System.out.print("Digite a quantidade disponível: ");
            quantidades[k] = scanner.nextInt();
            
            System.out.print("Digite o preço de venda: ");
            precos[k] = scanner.nextDouble();
            
            k++;
        }
        
        System.out.println("\nPROCESSAMENTO DE VENDAS (Digite 0 para encerrar)");
        while (true) {
            System.out.print("\nDigite o código do produto (0 para sair): ");
            int codVenda = scanner.nextInt();
            
            if (codVenda == 0) break;
            
            int index = -1;
            for (int i = 0; i < k; i++) {
                if (codigos[i] == codVenda) {
                    index = i;
                    break;
                }
            }
            
            if (index == -1) {
                System.out.println("Produto Não-Cadastrado");
                continue;
            }
            
            System.out.print("Digite a quantidade requerida: ");
            int qtdVenda = scanner.nextInt();
            
            if (quantidades[index] < qtdVenda) {
                System.out.println("Estoque Insuficiente");
            } else {
                quantidades[index] -= qtdVenda;
                double valorVenda = qtdVenda * precos[index];
                totalVendas += valorVenda;
                System.out.printf("Venda realizada: R$ %.2f%n", valorVenda);
            }
        }
        
        System.out.println("\nRELATÓRIO FINAL");
        System.out.printf("Total vendido no dia: R$ %.2f%n", totalVendas);
        
        Produto[] produtos = new Produto[k];
        for (int i = 0; i < k; i++) {
            produtos[i] = new Produto(codigos[i], quantidades[i], precos[i]);
        }
        
        Arrays.sort(produtos, Comparator.comparingInt(Produto::getQuantidade).reversed());
        
        System.out.println("\nESTOQUE ATUAL (ordenado por quantidade decrescente):");
        System.out.println("Código\tQuantidade\tPreço");
        for (Produto p : produtos) {
            System.out.printf("%d\t%d\t\tR$ %.2f%n", 
            p.getCodigo(), p.getQuantidade(), p.getPreco());
        }
    }
    
    static class Produto {
        private int codigo;
        private int quantidade;
        private double preco;
        
        public Produto(int codigo, int quantidade, double preco) {
            this.codigo = codigo;
            this.quantidade = quantidade;
            this.preco = preco;
        }
        
        public int getCodigo() { return codigo; }
        public int getQuantidade() { return quantidade; }
        public double getPreco() { return preco; }
    }
}
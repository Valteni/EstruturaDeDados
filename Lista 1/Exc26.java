import java.util.Scanner;

public class Exc26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data, dia, mes, ano, ndata;
        
        System.out.print("\nDigite data no formato DDMMAA: ");
        data = scanner.nextInt();
        
        dia = data / 10000;
        mes = (data % 10000) / 100;
        ano = data % 100;
        
        ndata = mes * 10000 + dia * 100 + ano;
        
        System.out.println("\nDIA: " + dia);
        System.out.println("MES: " + mes);
        System.out.println("ANO: " + ano);
        System.out.println("\n\nDATA NO FORMATO MMDDAA: " + ndata);
        System.out.println("\n");
    }
}
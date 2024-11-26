import java.util.Scanner;

public class Programas {
    public static void main(String[] args) {
        // Programa 1: Capturar 5 palavras do teclado e mostrar como uma frase em uma única linha
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programa 1 - Digite 5 palavras:");
        String[] palavras = new String[5];

        for (int i = 0; i < 5; i++) {
            palavras[i] = scanner.next();
        }

        System.out.println("Frase formada:");
        for (String palavra : palavras) {
            System.out.print(palavra + " ");
        }
        System.out.println("\n");

        // Programa 2: Solicitar ao usuário um número entre 0 e 10 e escrevê-lo por extenso
        System.out.println("Programa 2 - Digite um número entre 0 e 10:");
        int numero = scanner.nextInt();

        switch (numero) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("Um");
                break;
            case 2:
                System.out.println("Dois");
                break;
            case 3:
                System.out.println("Três");
                break;
            case 4:
                System.out.println("Quatro");
                break;
            case 5:
                System.out.println("Cinco");
                break;
            case 6:
                System.out.println("Seis");
                break;
            case 7:
                System.out.println("Sete");
                break;
            case 8:
                System.out.println("Oito");
                break;
            case 9:
                System.out.println("Nove");
                break;
            case 10:
                System.out.println("Dez");
                break;
            default:
                System.out.println("Número inválido");
        }
        System.out.println("\n");

        // Programa 3: Imprimir os números pares do intervalo [0..99]
        System.out.println("Programa 3 - Números pares de 0 a 99:");
        for (int i = 0; i <= 99; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("\n");

        // Programa 4: Construir um array com capacidade de armazenar 100 inteiros e inicializar cada elemento do array com números de 1 a 100 e os imprimir utilizando a estrutura FOR
        System.out.println("Programa 4 - Elementos do array de 1 a 100:");
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(array[i]);
        }
        System.out.println("\n");

        // Programa 5: Receber via teclado 5 nomes e respectivos números de telefone e imprimir cada tupla em uma linha
        System.out.println("Programa 5 - Digite 5 nomes e respectivos números de telefone:");
        String[] nomes = new String[5];
        String[] telefones = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.next();
            System.out.print("Telefone " + (i + 1) + ": ");
            telefones[i] = scanner.next();
        }

        System.out.println("Nomes e respectivos números de telefone:");
        for (int i = 0; i < 5; i++) {
            System.out.println(nomes[i] + " - " + telefones[i]);
        }
    }
}

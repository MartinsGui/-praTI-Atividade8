//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1. Operação Matemática");
            System.out.println("2. Verificar Palíndromo");
            System.out.println("3. Sequência de Fibonacci e Número Invertido");
            System.out.println("4. Verificar Anagramas");
            System.out.println("5. Jogo de Adivinhação");
            System.out.println("6. Contar Palavras em uma Frase");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (option) {
                case 1:
                    mathOperation(scanner);
                    break;
                case 2:
                    checkPalindrome(scanner);
                    break;
                case 3:
                    fibonacciAndReverse(scanner);
                    break;
                case 4:
                    checkAnagrams(scanner);
                    break;
                case 5:
                    guessingGame(scanner);
                    break;
                case 6:
                    countWords(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }

    // 1. Operação Matemática
    private static void mathOperation(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        System.out.print("Digite o operador (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Erro: Divisão por zero!");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Operador inválido!");
                return;
        }
        System.out.println("Resultado: " + result);
    }

    // 2. Verificar Palíndromo
    private static void checkPalindrome(Scanner scanner) {
        System.out.print("Digite uma palavra: ");
        String word = scanner.nextLine().toLowerCase();
        String reversed = new StringBuilder(word).reverse().toString();
        if (word.equals(reversed)) {
            System.out.println("É um palíndromo.");
        } else {
            System.out.println("Não é um palíndromo.");
        }
    }

    // 3. Sequência de Fibonacci e Número Invertido
    private static void fibonacciAndReverse(Scanner scanner) {
        System.out.print("Quantos números da sequência de Fibonacci você quer ver? ");
        int n = scanner.nextInt();
        System.out.println("Sequência de Fibonacci:");
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
        }
        System.out.println();

        System.out.print("Digite um número para inverter: ");
        int num = scanner.nextInt();
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        System.out.println("Número invertido: " + reversed);
    }

    // 4. Verificar Anagramas
    private static void checkAnagrams(Scanner scanner) {
        System.out.print("Digite a primeira palavra: ");
        String word1 = scanner.nextLine().toLowerCase();
        System.out.print("Digite a segunda palavra: ");
        String word2 = scanner.nextLine().toLowerCase();

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("As palavras são anagramas.");
        } else {
            System.out.println("As palavras não são anagramas.");
        }
    }

    // 5. Jogo de Adivinhação
    private static void guessingGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(50) + 1;
        int guess;

        System.out.println("Tente adivinhar o número entre 1 e 50!");
        do {
            System.out.print("Seu palpite: ");
            guess = scanner.nextInt();

            if (guess < numberToGuess) {
                System.out.println("O número é maior! Tente novamente.");
            } else if (guess > numberToGuess) {
                System.out.println("O número é menor! Tente novamente.");
            } else {
                System.out.println("Parabéns! Você acertou.");
            }
        } while (guess != numberToGuess);
    }

    // 6. Contar Palavras em uma Frase
    private static void countWords(Scanner scanner) {
        System.out.print("Digite uma frase: ");
        String sentence = scanner.nextLine().trim();
        if (sentence.isEmpty()) {
            System.out.println("A frase contém 0 palavras.");
        } else {
            String[] words = sentence.split("\\s+");
            System.out.println("A frase contém " + words.length + " palavras.");
        }
    }
}

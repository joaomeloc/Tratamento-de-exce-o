//Você é responsável por desenvolver um sistema de controle para um elevador em um prédio. O sistema deve permitir que usuários interajam com o elevador, podendo entrar, sair, subir e descer andares. Para garantir a robustez do sistema, você deve implementar tratamento de exceções tanto na lógica do elevador quanto na interação com o usuário. Crie uma classe Main que permitirá a interação do usuário com o elevador através de um menu de opções. O programa deve:Solicitar a capacidade do elevador.Solicitar o total de andares do prédio.Oferecer um menu de opções para que o usuário possa escolher entre: Entrar no elevador; Sair do elevador; Subir um andar; Descer um andar; Parar o programa. O programa deve tratar entradas inválidas do usuário (por exemplo, inserir letras onde são esperados números) e continuar a execução até que o usuário escolha a opção de parar.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        int capacidade = 0;
        int totalAndares = 0;

        while (true) {
            try {
                System.out.println("Informe a capacidade do elevador: ");
                capacidade = scanner.nextInt();
                if (capacidade <= 0) {
                    System.out.println("Capacidade deve ser um número positivo.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();
            }
        }

        while (true) {
            try {
                System.out.println("Informe o total de andares do prédio: ");
                totalAndares = scanner.nextInt();
                if (totalAndares < 0) {
                    System.out.println("O número de andares deve ser um número não negativo.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();
            }
        }

        Elevador elevador = new Elevador(capacidade, totalAndares);

        do {
            try {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Entrar");
                System.out.println("2 - Sair");
                System.out.println("3 - Subir");
                System.out.println("4 - Descer");
                System.out.println("0 - Parar");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        elevador.entrar();
                        break;
                    case 2:
                        elevador.sair();
                        break;
                    case 3:
                        elevador.subir();
                        break;
                    case 4:
                        elevador.descer();
                        break;
                    case 0:
                        System.out.println("Programa encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); 
                opcao = -1; 
            }
        } while (opcao != 0);

        scanner.close();
    }
}
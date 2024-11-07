import java.util.Scanner;

public class Main {

    // Vetores
    static String[] vetorCliente = new String[5];
    static String[] vetorAnimal = new String[5];
    static String[] vetorTipoAnimal = new String[5];
    static String[] vetorServico = new String[5];
    static String[][] vetorStatus = new String[5][];

    static int contadorCliente = 0;
    static int contadorAgendamento = 0;

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("""
                    --------------- MENU ---------------
                    [1] Cadastrar Cliente e Animal
                    [2] Agendamento de Banho ou Tosa
                    [3] Gerar Relatórios
                    [4] Encerrar o programa
                    ------------------------------------
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 4) {
                System.out.println("Saindo do programa...");
                break;
            }

            switch (opcao) {

                case 1:
                    cadastrarCliente(entrada);
                    break;
                case 2:
                    agendarServico(entrada);
                    break;
                case 3:
                    gerarRelatorio();
                    break;
                default:
                    System.out.println("[ERRO] Opção inválida, tente novamente");
            }

        }
    }

    //Função para cadastrar cliente
    public static void cadastrarCliente(Scanner entrada) {
        if (contadorCliente < 5) {

            System.out.print("Nome do Cliente: ");
            vetorCliente[contadorCliente] = entrada.nextLine();
            System.out.print("Nome do Animal: ");
            vetorAnimal[contadorCliente] = entrada.nextLine();
            System.out.print("Tipo do Animal: ");
            vetorTipoAnimal[contadorCliente] = entrada.nextLine();
            contadorCliente++;

            System.out.println("\nCliente cadastrado com sucesso!");
        } else {
            System.out.println("\nLimite de clientes atingido!");
        }
    }

    public static void agendarServico (Scanner entrada) {

        if (contadorAgendamento < contadorCliente) {
            System.out.println("Agendamento para " + vetorCliente[contadorAgendamento] + " e seu animal " + vetorAnimal[contadorAgendamento]);
            System.out.print("Tipo de Serviço (Banho/Tosa): ");
            vetorServico[contadorAgendamento] = entrada.nextLine();
            System.out.println("Status do serviço (Agendado/Realizado): ");
            vetorStatus[contadorAgendamento] = new String[]{entrada.nextLine()};
            contadorAgendamento++;
            System.out.println("Serviço agendado com sucesso!");
        } else {
            System.out.println("Não há mais clientes sem agendamento!");
        }
    }

    // Função para gerar o relatório
    public static void gerarRelatorio() {
        System.out.println("---------------RELATORIO---------------");
        int totalAgendados = 0;
        int totalRealizados = 0;

        for (int i = 0; i < contadorAgendamento; i++) {
            System.out.println("[Cliente]: " + vetorCliente[i] +
                    ", [Animal]: " + vetorAnimal[i] +
                    ", [Tipo de Animal]: " + vetorTipoAnimal[i] +
                    ", [Serviço]: " + vetorServico[i] +
                    ", [Status]: " + vetorStatus[i]);

            if (vetorStatus[i].equals("Agendado")) {
                totalAgendados++;
            } else if (vetorStatus[i].equals("Realizado")) {
                totalRealizados++;
            }
        }

        System.out.println("\nTotal de serviços agendados: " + totalAgendados);
        System.out.println("Total de serviços realizados: " + totalRealizados);
    }
}

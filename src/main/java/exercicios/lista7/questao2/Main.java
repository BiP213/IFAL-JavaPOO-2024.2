package exercicios.lista7.questao2;

import java.util.Scanner;
import java.util.LinkedList;

/*
Questão 02: Escreva um programa para gerenciar as contas dos clientes de uma agência
bancária. Os dados dos clientes são: nome, número de conta e saldo. Forneça as
seguintes opções:
1. Cadastrar Cliente
2. Consultar dados de um cliente
3. Verificar saldo
4. Efetuar saque da conta
5. Efetuar depósito na conta
0. Sair
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Cliente> clientes = new LinkedList<>();
        Cliente cliente = null;
        int opcao;
        String tempNome;
        int tempNConta;
        double tempSaldo;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar dados de um cliente");
            System.out.println("3 - Verificar saldo");
            System.out.println("4 - Efetuar saque");
            System.out.println("5 - Efetuar depósito");
            System.out.println("0 - Finalizar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Removendo \n do input de tipos primitivos.

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastrando cliente...");
                    System.out.print("\nNome: ");
                    tempNome = scanner.nextLine();

                    cliente = new Cliente(tempNome);
                    clientes.add(cliente);

                    System.out.println("\nConta criada com sucesso!");
                    System.out.println("Cliente: " + cliente.getNome());
                    System.out.println("Número da conta: " + cliente.getNConta());
                    System.out.println("Saldo: " + cliente.getSaldo());
                    break;

                case 2:
                    System.out.println("\nConsultando dados de um cliente...");
                    System.out.println("Número da conta: ");
                    tempNConta = scanner.nextInt();
                    scanner.nextLine();

                    if (cliente != null) {
                        for (Cliente c : clientes) {
                            if (tempNConta == c.getNConta()) {
                                System.out.println("\nNome do cliente: " + c.getNome());
                                System.out.println("Número da conta: " + c.getNConta());
                                System.out.println("Saldo atual: R$" + c.getSaldo());
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nVerificando saldo...");
                    System.out.println("Número da conta: ");
                    tempNConta = scanner.nextInt();
                    scanner.nextLine();

                    if (cliente != null) {
                        for (Cliente c : clientes) {
                            if (tempNConta == c.getNConta()) {
                                System.out.println("\nNome do cliente: " + c.getNome());
                                System.out.println("Saldo atual: R$" + c.getSaldo());
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nEfetuando saque...");
                    System.out.println("Número da conta: ");
                    tempNConta = scanner.nextInt();
                    scanner.nextLine();

                    if (cliente != null) {
                        for (Cliente c : clientes) {
                            if (tempNConta == c.getNConta()) {
                                System.out.print("\nSaldo atual: R$" + c.getSaldo());
                                System.out.print("\nDigite o valor do saque: ");
                                tempSaldo = scanner.nextDouble();
                                scanner.nextLine();
                                c.sacar(tempSaldo);
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nEfetuando depósito...");
                    System.out.println("Número da conta: ");
                    tempNConta = scanner.nextInt();
                    scanner.nextLine();

                    if (cliente != null) {
                        for (Cliente c : clientes) {
                            if (tempNConta == c.getNConta()) {
                                System.out.print("\nSaldo atual: R$" + c.getSaldo());
                                System.out.print("\nDigite o valor do depósito: R$");
                                tempSaldo = scanner.nextDouble();
                                scanner.nextLine();
                                c.depositar(tempSaldo);
                            }
                        }
                    }
                    break;

                case 0:
                    System.out.println("\nFinalizando...");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
package exercicios.lista7.questao1;

import java.util.Scanner;
import java.util.LinkedList;

/*
Questão 01: Escreva um programa para gerenciar os estudantes de uma instituição de
ensino. Os dados dos estudantes são: nome, número de matrícula, endereço e 02 notas.
Forneça as seguintes opções:
1. Cadastrar um estudante
2. Calcular média de um estudante
3. Consultar matrícula de um estudante
4. Consultar endereço de um estudante
5. Calcular a média da turma
6. Exibir os nomes dos estudantes reprovados
0. Sair
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Estudante> estudantes = new LinkedList<>();
        Estudante estudante = null;
        int opcao;
        String tempNome, tempEndereco;
        int tempMatricula;
        double tempNota1, tempNota2;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar estudante");
            System.out.println("2 - Calcular média do estudante");
            System.out.println("3 - Consultar matrícula");
            System.out.println("4 - Consultar endereço");
            System.out.println("5 - Calcular média da turma");
            System.out.println("6 - Exibir nomes estudantes aprovados");
            System.out.println("0 - Finalizar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Removendo \n do input de tipos primitivos.

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastrando estudante...");
                    System.out.print("\nNome: ");
                    tempNome = scanner.nextLine();

                    System.out.print("Matrícula: ");
                    tempMatricula = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Endereço: ");
                    tempEndereco = scanner.nextLine();

                    System.out.print("Nota1: ");
                    tempNota1 = scanner.nextDouble();

                    System.out.print("Nota2: ");
                    tempNota2 = scanner.nextDouble();
                    scanner.nextLine();

                    estudante = new Estudante(tempNome, tempMatricula, tempEndereco, tempNota1, tempNota2);
                    estudantes.add(estudante);

                    System.out.println("\nEstudante " + estudante.getNome() + " cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\nCalculando média do estudante...");
                    System.out.println("Matrícula: ");
                    tempMatricula = scanner.nextInt();
                    scanner.nextLine();

                    if (estudante != null) {
                        for (Estudante e : estudantes) {
                            if (tempMatricula == e.getMatricula()) {
                                System.out.println(e.getNome() + " - Média: " + e.calcularMedia());
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nConsultando matrícula do estudante...");
                    System.out.println("Nome: ");
                    tempNome = scanner.nextLine();

                    if (estudante != null) {
                        for (Estudante e : estudantes) {
                            if (tempNome.equals(e.getNome())) {
                                System.out.println(e.getNome() + " - Matrícula: " + e.getMatricula());
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nConsultando endereço do estudante...");
                    System.out.println("Matrícula: ");
                    tempMatricula = scanner.nextInt();
                    scanner.nextLine();

                    if (estudante != null) {
                        for (Estudante e : estudantes) {
                            if (tempMatricula == e.getMatricula()) {
                                System.out.println(e.getNome() + " - Endereço: " + e.getEndereco());
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nCalculando média da turma...");
                    double somaNotasTurma = 0d;
                    int quantidadeEstudantes = estudantes.size();

                    for (Estudante e : estudantes) {
                        somaNotasTurma += e.calcularMedia();
                    }

                    // if e else inline.
                    double mediaTurma = quantidadeEstudantes > 0 ? somaNotasTurma / quantidadeEstudantes : 0;
                    System.out.println("Média da turma: " + mediaTurma);
                    break;

                case 6:
                    System.out.println("\nEstudantes Aprovados:");
                    boolean encontrouAprovados = false;

                    for (Estudante e : estudantes) {
                        if (e.Aprovado()) {
                            System.out.println(e.getNome());
                            encontrouAprovados = true;
                        }
                    }

                    if (!encontrouAprovados) {
                        System.out.println("Nenhum estudante foi aprovado.");
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
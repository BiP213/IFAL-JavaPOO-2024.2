package exercicios.lista7.questao3;

import java.util.Scanner;
import java.util.LinkedList;

/*
Questão 03: Crie uma classe Livro que possua: autor, editora, ISBN, título, Ano de
Edição. Faça um sistema que forneça as seguintes opções:
1. Cadastrar livro
2. Buscar livro por título
3. Listar livros por autor (mostrar os livros de um autor)
4. Listar todos os livros disponíveis
0. Sair
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Livro> livros = new LinkedList<>();
        Livro livro = null;
        int opcao;
        String tempTitulo, tempAutor, tempEditora, tempIsbn;
        int tempAnoEdicao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Buscar livro por título");
            System.out.println("3 - Listar livros por autor");
            System.out.println("4 - Listar todos os livros disponíveis");
            System.out.println("0 - Finalizar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Removendo \n do input de tipos primitivos.

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastrando livro...");
                    System.out.print("\nTítulo: ");
                    tempTitulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    tempAutor = scanner.nextLine();

                    System.out.print("Ano de edição: ");
                    tempAnoEdicao = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Editora: ");
                    tempEditora = scanner.nextLine();

                    System.out.print("Código ISBN: ");
                    tempIsbn = scanner.nextLine();

                    livro = new Livro(tempTitulo, tempAnoEdicao, tempAutor, tempEditora, tempIsbn);
                    livros.add(livro);

                    System.out.println("\nLivro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\nBuscando livro por título...");
                    System.out.print("Título: ");
                    tempTitulo = scanner.nextLine();

                    if (livro != null) {
                        for (Livro l : livros) {
                            if (tempTitulo.equals(l.getTitulo())) {
                                mostrarLivros(l);
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nListando livros por autor...");
                    System.out.print("Autor: ");
                    tempAutor = scanner.nextLine();

                    if (livro != null) {
                        for (Livro l : livros) {
                            if (tempAutor.equals(l.getAutor())) {
                                mostrarLivros(l);
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nListando todos os livros disponíveis...");

                    if (livro != null) {
                        for (Livro l : livros) {
                            mostrarLivros(l);
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

    private static void mostrarLivros(Livro l) {
        System.out.println("\nTítulo: " + l.getTitulo());
        System.out.println("Autor: " + l.getAutor());
        System.out.println("Ano de edição: " + l.getAnoEdicao());
        System.out.println("Editora: " + l.getEditora());
        System.out.println("Código ISBN: " + l.getIsbn());
    }
}
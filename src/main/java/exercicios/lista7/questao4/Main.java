package exercicios.lista7.questao4;

import java.util.Scanner;
import java.util.LinkedList;

/*
Questão 04: Faça um sistema para gerenciar Produtos de uma livraria. O Produto
possui: nome, código, preço e quantidade. O sistema deve fornecer as seguintes opções:
1. Cadastrar produto
2. Buscar Produto (procurar produto pelo nome)
3. Listar todos os produtos disponíveis
4. Efetuar venda de um produto
0. Sair
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Produto> produtos = new LinkedList<>();
        Produto produto = null;
        int opcao;
        String tempNome, tempCodigo;
        int tempQuantidade;
        double tempPreco;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto pelo nome");
            System.out.println("3 - Listar todos os produtos disponíveis");
            System.out.println("4 - Efetuar venda de um produto");
            System.out.println("0 - Finalizar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Removendo \n do input de tipos primitivos.

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastrando produto...");
                    System.out.print("\nNome: ");
                    tempNome = scanner.nextLine();

                    System.out.print("Código: ");
                    tempCodigo = scanner.nextLine();

                    System.out.print("Preço: ");
                    tempPreco = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Quantidade: ");
                    tempQuantidade = scanner.nextInt();
                    scanner.nextLine();

                    produto = new Produto(tempNome, tempCodigo, tempPreco, tempQuantidade);
                    produtos.add(produto);

                    System.out.println("\nProduto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\nBuscando produto pelo nome...");
                    System.out.print("\nNome: ");
                    tempNome = scanner.nextLine();

                    if (produto != null) {
                        for (Produto p : produtos) {
                            if (tempNome.equals(p.getNome())) {
                                mostrarProdutos(p);
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nListando todos os produtos disponíveis...");

                    if (produto != null) {
                        for (Produto p : produtos) {
                            mostrarProdutos(p);
                        }
                    }
                    break;

                case 4:
                    if (produto != null) {
                        venderProdutos(produtos);
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

    public static void mostrarProdutos(Produto p) {
        System.out.println("\nNome:       " + p.getNome());
        System.out.println("Código:     " + p.getCodigo());
        System.out.println("Preço:      R$" + p.getPreco());
        System.out.println("Quantidade: " + p.getQuantidade());
    }

    public static void venderProdutos(LinkedList<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
        int i;

        do {
            boolean produtoEncontrado = false;
            System.out.println("\nVendendo produtos...");
            System.out.print("Código: ");
            String tempCodigo = scanner.nextLine();

            for (Produto p : produtos) {
                if (tempCodigo.equals(p.getCodigo())) {
                    mostrarProdutos(p);

                    System.out.print("\nDigite a quantidade: ");
                    int tempQuantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (p.getQuantidade() >= tempQuantidade) {
                        double total = p.getPreco() * tempQuantidade;
                        p.setQuantidade(p.getQuantidade() - tempQuantidade);
                        System.out.println("\nVenda de " + tempQuantidade + "x " + p.getNome());
                        System.out.println("Total: R$" + total);
                        System.out.println("Venda efetuada com sucesso!");
                        produtoEncontrado = true;
                    } else {
                        System.out.println("Quantidade insuficiente para efetuar a venda.");
                        produtoEncontrado = true;
                    }
                    break;
                }
            }

            if (!produtoEncontrado) {
                System.out.println("Produto não encontrado.");
            }

            System.out.print("\nContinuar? 0-Sair: ");
            i = scanner.nextInt();
            scanner.nextLine();

        } while (i != 0);
    }
}

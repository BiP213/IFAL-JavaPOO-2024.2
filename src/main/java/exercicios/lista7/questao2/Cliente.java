package exercicios.lista7.questao2;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Cliente {
    // Criando uma lista de números únicos int
    private static final Set<Integer> numerosDeConta = new HashSet<>();
    private String nome;
    private int nConta;
    private double saldo;

    public String getNome() {
        return nome;
    }

    public int getNConta() {
        return nConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Acesso restrito, somente para uso da própria classe
    private int gerarNumeroDaConta() {
        Random nAleatorio = new Random();
        int numero;

        // Verificando se o número gerado já existe na lista
        do {
            // Gerando um número de 8 dígitos
            numero = 10000000 + nAleatorio.nextInt(90000000);
        } while (numerosDeConta.contains(numero));

        return numero;
    }

    public Cliente (String nome) {
        this.nome = nome;
        nConta = gerarNumeroDaConta();
        saldo = 0d;
    }

    public void depositar(double deposito) {
        if (deposito > 0) {
            saldo += deposito;
            System.out.println("\nOperação realizada com sucesso.");
            System.out.println("Novo saldo: R$" + saldo);
        }
    }

    public void sacar(double saque) {
        if (saque > 0 && saque <= saldo) {
            saldo -= saque;
            System.out.println("\nOperação realizada com sucesso.");
            System.out.println("Novo saldo: R$" + saldo);
        }
    }
}

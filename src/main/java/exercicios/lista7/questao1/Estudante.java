package exercicios.lista7.questao1;

public class Estudante {
    private String nome;
    private int matricula;
    private String endereco;
    private double nota1;
    private double nota2;

    // Construtores
    public Estudante(String nome, int matricula, String endereco, double nota1, double nota2) {
        this.nome = nome;
        this.endereco = endereco;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Estudante(String nome, int matricula, String endereco) {
        this.nome = nome;
        this.matricula = matricula;
        this.endereco = endereco;
        nota1 = 0;
        nota2 = 0;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getMatricula() {
        return matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    // Métodos da classe
    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public boolean Aprovado() {
        return ((nota1 + nota2) / 2) >= 7;
    }
}

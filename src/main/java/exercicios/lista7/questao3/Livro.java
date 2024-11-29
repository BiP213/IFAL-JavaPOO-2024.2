package exercicios.lista7.questao3;

public class Livro {
    private String titulo;
    private int anoEdicao;
    private String autor;
    private String editora;
    private String isbn;

    public String getTitulo() {
        return titulo;
    }

    public int getAnoEdicao() {
        return anoEdicao;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoEdicao(int anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Livro (String titulo, int anoEdicao, String autor, String editora, String isbn) {
        this.titulo = titulo;
        this.anoEdicao = anoEdicao;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
    }
}

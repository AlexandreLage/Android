package br.com.fiap.fipe;

/**
 * Created by logonrm on 11/05/2017.
 */

public class Marca {

    private int id;
    private String nome;

    public Marca() {

    }

    public Marca(int id, String nome) {

        this.id = id;
        this.nome = nome;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {

        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

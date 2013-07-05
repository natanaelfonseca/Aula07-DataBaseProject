package br.com.treinamento.domainmodel;

import java.io.Serializable;

/**
 * Created by natanaelfonseca on 19/06/13.
 */
public class Pessoa implements Serializable {

    private Long   id;
    private String nome;
    private String telefone;
    private String endereco;

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (endereco != null ? !endereco.equals(pessoa.endereco) : pessoa.endereco != null)
            return false;
        if (!id.equals(pessoa.id)) return false;
        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) return false;
        if (telefone != null ? !telefone.equals(pessoa.telefone) : pessoa.telefone != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

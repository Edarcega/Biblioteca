package entities;

import enums.EstadoUsuario;

import java.util.Date;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private Date nascimento;
    private int id;
    private EstadoUsuario status;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, Date nascimento, int id, EstadoUsuario status) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.id = id;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoUsuario getStatus() {
        return status;
    }

    public void setStatus(EstadoUsuario status) {
        this.status = status;
    }
}

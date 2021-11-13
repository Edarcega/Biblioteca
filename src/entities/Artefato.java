package entities;

import enums.EstadoArtefato;

public class Artefato {
    private String name;
    private String autor;
    private String tipo;
    private EstadoArtefato status;
    private int id;

    public Artefato(String titulo, String autor, String tipo, int idt) {
    }

    public Artefato(String name, String autor, String tipo, EstadoArtefato status, int id) {
        this.name = name;
        this.autor = autor;
        this.tipo = tipo;
        this.id = id;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EstadoArtefato getStatus() {
        return status;
    }

    public void setStatus(EstadoArtefato status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


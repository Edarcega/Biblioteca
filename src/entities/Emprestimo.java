package entities;

import enums.EstadoEmprestimo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimo {
    private Date momento;
    private EstadoEmprestimo status;
    private int id;
    private Usuario usuario;
    private List<Artefato> artefatos = new ArrayList<>();

    public Emprestimo() {
    }

    public Emprestimo(Date momento, EstadoEmprestimo status, int id, Usuario usuario) {
        this.momento = momento;
        this.status = status;
        this.id = id;
        this.usuario = usuario;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public EstadoEmprestimo getStatus() {
        return status;
    }

    public void setStatus(EstadoEmprestimo status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Artefato> getArtefatos() {
        return artefatos;
    }

    public void addAtf(Artefato artefato) {
        artefatos.add(artefato);

    }

    public void removAtf(Artefato artefato) {
        artefatos.remove(artefato);
    }

    public String resume() {
        String resume = "nome: " + usuario.getNome() + "\n"
                + " ID: " + usuario.getId() + "\n"
                + "**** Emprestimo **** \n"
                + concatArtefatos(artefatos);
        return null;
    }

    public String concatArtefatos(List<Artefato> artefatos){
        String listaArtefatos = null;
        for (Artefato x:artefatos) {
            listaArtefatos = listaArtefatos + x.getName() + "; \n";
        }
        return  listaArtefatos;
    }

}
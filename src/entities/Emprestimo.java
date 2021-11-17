package entities;

import enums.EstadoEmprestimo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimo {
    private Date momento;
    private EstadoEmprestimo status;
    private int id;
    private Usuario usuario;
    private List<Artefato> artefatoes = new ArrayList<>();

    public Emprestimo(Date momento, EstadoEmprestimo status, int id, Usuario usuario, List<Artefato> art) {
        this.momento = momento;
        this.status = status;
        this.id = id;
        this.usuario = usuario;
        this.artefatoes = art;
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
        return artefatoes;
    }

    public void addAtf(Artefato artefato) {
        artefatoes.add(artefato);

    }

    public void removAtf(Artefato artefato) {
        artefatoes.remove(artefato);
    }

    public void resume() {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("*****************************\n");
        System.out.print("-- Resumo do emprestimo -- \n");
        System.out.print("Data: " + sdf.format(momento) + "\n");
        System.out.print("Nome: " + usuario.getNome() + "\n");
        System.out.print("ID Usuário: " + usuario.getId() + "\n");
        System.out.print("-- Lista de itens --\n");
        int i = 1;

        for (Artefato x : artefatoes) {
            System.out.print("Artefato #" + i + "\n");
            System.out.print("- Título: " + x.getName() + "\n");
            System.out.print("- Autor: " + x.getAutor() + "\n");
            i++;
        }
    }

}
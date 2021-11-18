package entities;

import enums.EstadoArtefato;
import enums.EstadoEmprestimo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Emprestimo {
    private Date momento;
    private EstadoEmprestimo status;
    private int id;
    private Usuario usuario;
    private List<Artefato> artefatos = new ArrayList<>();

    public Emprestimo(Date momento, EstadoEmprestimo status, int id, Usuario usuario, List<Artefato> art) {
        this.momento = momento;
        this.status = status;
        this.id = id;
        this.usuario = usuario;
        this.artefatos = art;
    }

    public Emprestimo() {

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

    public List<Artefato> artDisponiveis(List<Artefato> artefato) {
        List<Artefato> result = artefato.stream().filter(x -> x.getStatus() == EstadoArtefato.DISPONIVEL).collect(Collectors.toList());
        return result;
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

        for (Artefato x : artefatos) {
            System.out.print("Artefato #" + i + "\n");
            System.out.print("- Título: " + x.getTitulo() + "\n");
            System.out.print("- Autor: " + x.getAutor() + "\n");
            i++;
        }
    }

}
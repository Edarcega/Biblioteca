package entities;

import enums.EstadoArtefato;
import enums.EstadoEmprestimo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    public void resume(List<Artefato> artefatos) {
        StringBuilder resume = new StringBuilder();
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        resume.append("*****************************\n");
        resume.append("-- Resumo do emprestimo -- \n");
        resume.append("Data: " + sdf.format(momento) + "\n");
        resume.append("Nome: " + usuario.getNome() + "\n");
        resume.append("ID Usuário: " + usuario.getId() + "\n\n");
        resume.append("-- Lista de itens --\n");
        System.out.print(resume.toString() + "\n");
        int i = 1;

        for (Artefato x : artefatos) {
            Date devolucao = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(this.momento);
            cal.add(Calendar.DATE,15);
            devolucao = cal.getTime();
            System.out.print("Artefato #" + i + "\n");
            resume.append("Artefato #" + i + "\n");
            System.out.print("- Título: " + x.getTitulo() + "\n");
            resume.append("- Título: " + x.getTitulo() + "\n");
            System.out.print("- Autor: " + x.getAutor() + "\n");
            resume.append("- Autor: " + x.getAutor() + "\n");
            System.out.print("- Data de devolução: " + sdf.format(devolucao));
            resume.append("- Data de devolução: " + sdf.format(devolucao));
            String gravar = resume.toString();
            String path = "/home/edimar/Documentos/resumeEmprestimo";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
                bw.write(gravar);
                bw.newLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }

            i++;
        }

    }

}
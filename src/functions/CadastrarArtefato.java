package functions;

import entities.Artefato;
import enums.EstadoArtefato;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarArtefato {
    private static List<Artefato> artefatos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static List<Artefato> cadastrar() {
        int i = 1;
        while (i == 1) {
            System.out.print("Titulo: ");
            String titulo = sc.nextLine();
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("Tipo:  ");
            String tipo = sc.nextLine();
            //System.out.print("ID: ");
            int idt = artefatos.size() + 1;
            artefatos.add(new Artefato(titulo, autor, tipo, EstadoArtefato.DISPONIVEL, idt));
            System.out.println("Cadastrar novo artefato ?");
            System.out.println("1 - SIM | 2 - Não");
            i = sc.nextInt();
            sc.nextLine();
        }

        return artefatos;

    }

    public static List<Artefato> importarCadastro() {
        String path = "/home/edimar/Documentos/Biblioteca/importarArtefatos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String listaArtefatos = br.readLine();
            while (listaArtefatos != null) {
                String[] fields = listaArtefatos.split(",");
                int idt = artefatos.size() + 1;
                artefatos.add(new Artefato(fields[0], fields[1], fields[2], EstadoArtefato.DISPONIVEL, idt));
                System.out.println("Titulo: " + artefatos.get(idt - 1).getTitulo());
                System.out.println("ID: " + artefatos.get(idt - 1).getId());
                listaArtefatos = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return artefatos;
    }
}

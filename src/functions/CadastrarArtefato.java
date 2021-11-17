package functions;

import entities.Artefato;
import enums.EstadoArtefato;

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
            System.out.print("ID: ");
            int idt = sc.nextInt();
            artefatos.add(new Artefato(titulo, autor, tipo, EstadoArtefato.RESERVADO, idt));
            sc.nextLine();
            System.out.println("Cadastrar novo artefato ?");
            System.out.println("1 - SIM | 2 - Não");
            i = sc.nextInt();
        }
        return artefatos;

    }

}

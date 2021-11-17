package applications;

import entities.Artefato;
import entities.Usuario;
import functions.CadastrarArtefato;
import functions.CadastrarUsuario;
import functions.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        List<Artefato> art = new ArrayList<>();
        final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        List<Usuario> usuarios = new ArrayList<>();
        List<Artefato> artefatos = new ArrayList<>();

        switch (Menu.menu()) {
            case 1:
                usuarios = CadastrarUsuario.cadastrar();
                break;
            case 2:
                artefatos = CadastrarArtefato.cadastrar();
                break;
        }
        System.out.println("Concluído");

        /*
        System.out.print("Quantos itens vai emprestar?");
        int qtd = sc.nextInt();public int menu ( ) {

        for (int i = 0; i < qtd; i++) {
            int atf = i + 1;
            System.out.print("-- Artefato #" + atf + ": \n");
            System.out.print("Titulo: ");
            String titulo = sc.nextLine();
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("Tipo:  ");
            String tipo = sc.nextLine();
            System.out.print("ID: ");
            int idt = sc.nextInt();
            art.add(new Acervo(titulo, autor, tipo, EstadoArtefato.RESERVADO, idt));
            sc.nextLine();
        }

        Emprestimo emprestimo = new Emprestimo(now, EstadoEmprestimo.EM_DIA, 1, usuario, art);
        
        emprestimo.resume();
        System.out.print("Concluído");

        System.out.print("\n");

        sc.close();

         */
    }

}

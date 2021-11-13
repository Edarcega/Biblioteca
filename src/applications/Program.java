package applications;

import entities.Artefato;
import entities.Usuario;
import enums.EstadoArtefato;
import enums.EstadoUsuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Quantos livros vai emprestar?");
        int qtd = sc.nextInt();
        sc.nextLine();
        System.out.println("\n");

        System.out.print(" --  Cadastre o usuário -- \n");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("email: ");
        String email = sc.nextLine();
        System.out.print("telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Nascimento: ");
        Date nascimento = sdf1.parse(sc.nextLine());
        System.out.print("ID: ");
        int id = sc.nextInt();
        Usuario usuario = new Usuario(nome, email, telefone, nascimento, id, EstadoUsuario.ATIVO);
        List<Artefato> art = new ArrayList<>();

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
            art.add(new Artefato(titulo, autor, tipo, EstadoArtefato.RESERVADO, idt));
        }

        sc.close();
    }

}

package applications;

import entities.Artefato;
import entities.Emprestimo;
import entities.Usuario;
import enums.EstadoArtefato;
import enums.EstadoEmprestimo;
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
        List<Artefato> art = new ArrayList<>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();

        System.out.print("Quantos itens vai emprestar?");
        int qtd = sc.nextInt();
        sc.nextLine();
        System.out.print("\n");

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
        sc.nextLine();

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
            sc.nextLine();
        }

        Emprestimo emprestimo = new Emprestimo(now, EstadoEmprestimo.EM_DIA, 1, usuario, art);

        emprestimo.resume();
        System.out.print("Concluído");

        System.out.print("\n");

        sc.close();
    }

}

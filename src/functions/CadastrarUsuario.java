package functions;

import entities.Usuario;
import enums.EstadoUsuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CadastrarUsuario {
    private int i;
    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private static List<Usuario> usuarios = new ArrayList<>();

    public static List<Usuario> cadastrar() throws ParseException {

        int i = 1;
        while (i == 1) {
            System.out.println(" ");
            System.out.print(" --  Cadastre o Usuário -- \n");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("email: ");
            String email = sc.nextLine();
            System.out.print("telefone: ");
            String telefone = sc.nextLine();
            System.out.print("Nascimento: ");
            Date nascimento = sdf1.parse(sc.nextLine());
            int id = usuarios.size() + 1;
            usuarios.add(new Usuario(nome, email, telefone, nascimento, id, EstadoUsuario.ATIVO));
            System.out.println("Cadartrar novo Usuário ?");
            System.out.println("1 - SIM | 2 - NÃO");
            i = sc.nextInt();
            System.out.print("\n");
            sc.nextLine();
        }


        return usuarios;
    }


    public static List<Usuario> importarCadastro() {
        String path = "/home/edimar/Documentos/Biblioteca/importarUsuarios.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String listaUsuarios = br.readLine();
            while (listaUsuarios != null) {
                String[] fields = listaUsuarios.split(",");
                int id = usuarios.size() + 1;
                Date nascimento = sdf1.parse(fields[3]);
                usuarios.add(new Usuario(fields[0], fields[1], fields[2], nascimento, id, EstadoUsuario.ATIVO));
                listaUsuarios = br.readLine();
            }
        } catch (IOException | ParseException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return  usuarios;
    }
}

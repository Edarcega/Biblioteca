package applications;

import entities.Artefato;
import entities.Emprestimo;
import entities.Usuario;
import enums.EstadoArtefato;
import enums.EstadoEmprestimo;
import functions.CadastrarArtefato;
import functions.CadastrarUsuario;
import functions.Menu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        List<Artefato> art = new ArrayList<>();
        //final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        List<Usuario> usuarios = new ArrayList<>();
        List<Artefato> artefatos = new ArrayList<>();
        Emprestimo emprestimo = new Emprestimo();
        int teste = 1;

        while (teste == 1) {
            switch (Menu.menu()) {
                case 1 -> usuarios = CadastrarUsuario.cadastrar();
                case 2 -> artefatos = CadastrarArtefato.cadastrar();
                case 3 -> {
                    if (usuarios.isEmpty() || artefatos.isEmpty()) {
                        if (usuarios.isEmpty()) {
                            System.out.println("Cadastro de usuários vazio!");
                        }
                        if (artefatos.isEmpty()) {
                            System.out.println("Cadastro de artefatos vazio!");
                        }
                        break;
                    }
                    System.out.println("Digite o ID do usuário");
                    System.out.print("ID: ");
                    int idu = sc.nextInt();
                    Usuario usr = usuarios.stream().filter(x -> x.getId() == idu).findFirst().orElse(null);
                    System.out.println("Usuário: " + usr.getNome());
                    System.out.print("\n");
                    System.out.print("Quantos artefatos serão emprestados: ");
                    int qtd = sc.nextInt();
                    System.out.print("\n");

                    for (int i = 0; i < qtd; i++) {
                        int val = i + 1;
                        System.out.println("-- Artefatos disponíveis --");
                        List<Artefato> artDisp = emprestimo.artDisponiveis(artefatos);
                        for (Artefato x : artDisp) {
                            System.out.println("Titulo: " + x.getTitulo());
                            System.out.println("ID: " + x.getId() + "\n");
                        }

                        System.out.print("Digite o ID do artefato desejado: ");
                        int id = sc.nextInt();

                        Artefato temp = artDisp.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
                        sc.nextLine();

                        art.add(temp);
                        temp.setStatus(EstadoArtefato.RESERVADO);

                    }

                    emprestimo = new Emprestimo(now, EstadoEmprestimo.EM_DIA, 1, usr, art);

                    emprestimo.resume(art);

                    System.out.println();

                    sc.nextLine();
                    break;
                }
            }

            System.out.println("1 - Continuar");
            System.out.println("2 - Sair");
            teste = sc.nextInt();
        } // fim do enquanto

        sc.nextLine();
        System.out.println("Até logo");

    }

}

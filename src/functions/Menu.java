package functions;

import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static int menu() {
        System.out.println("****** Escolha a funcionalidade: *****");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Cadastrar artefato");
        System.out.println("3 - Efetuar emprestimo");
        int esc = sc.nextInt();
        sc.nextLine();
        return esc;
    }
}

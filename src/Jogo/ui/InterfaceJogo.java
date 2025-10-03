package Jogo.ui;

import java.util.Scanner;

public class InterfaceJogo {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public int lerOpcao(int max) {
        int escolha;
        do {
            System.out.print("Escolha (1-" + max + "): ");
            escolha = scanner.nextInt();
        } while (escolha < 1 || escolha > max);
        return escolha;
    }

    public void mostrarSala(Sala sala) {
        System.out.println("\n=== " + sala.getNome() + " ===");
        System.out.println(sala.getDescricao());
    }
}

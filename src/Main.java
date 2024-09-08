import Entidades.*;
import Itens.Arma;
import Itens.ConsumivelCombate;
import Itens.Pocao;
import Jogo.Jogo;

import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Jogo jogo = new Jogo();
        Scanner input = new Scanner(System.in);
        Heroi heroi = null; // Inicializa o herói como null
        int escolha = 0;

        do {
            // Cria o herói
            heroi = jogo.criarPersonagem();

            // Inicia o Jogo
            if (heroi != null) {
                jogo.tresReinos(heroi); // Configura o jogo (salas, etc.)
            } else {
                System.out.println("Personagem não criada!");
            }

            if (heroi != null) { // Verifica se o herói foi criado
                // Mostrar opções de continuar jogando ou criar novo personagem
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"); // Limpa a tela
                System.out.println(">>> O jogo acabou! Você foi derrotado! ");
                System.out.println("\nO que você deseja fazer?\n");
                System.out.println("1. Jogar novamente com a mesma personagem");
                System.out.println("2. Criar uma nova personagem");
                System.out.println("3. Sair do jogo");
                System.out.println(" >>> ");

                escolha = input.nextInt();
                input.nextLine(); // Limpa o buffer do Scanner
            }
        } while (escolha != 3); // Continua o loop até o jogador escolher sair

        System.out.println("Obrigado por jogar!");
        input.close();
    }
}
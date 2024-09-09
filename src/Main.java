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
    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);

        Heroi heroi = null; // Inicializa o herói como null

        do {
            Jogo jogo = new Jogo();

            // Cria o herói
            heroi = jogo.criarPersonagem();
            jogo.tresReinos(heroi); // Executa o Jogo

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Para Jogar digite 1");

        }while (scanner.nextInt() != 1) ; // Continua o loop até o jogador não escolher jogar

        System.out.println("\nObrigado por jogar!\n");

    }
}
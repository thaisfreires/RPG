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
        Jogo jogo=new Jogo();
        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            // Cria o herói
            Heroi heroi = jogo.criarPersonagem();

            // Inicia o Jogo
            if (heroi != null) {
                jogo.tresReinos(heroi);
            }

            // Verifica se o jogador deseja jogar novamente
            System.out.println(">>> O jogo acabou! Você foi derrotado! ");
            System.out.println("\nO que você deseja fazer?\n");
            System.out.println("1. Jogar novamente com a mesma personagem");
            System.out.println("2. Criar uma nova personagem");
            System.out.println("3. Sair do jogo");
            System.out.println(" >>> ");

            escolha = input.nextInt();


        } while (escolha != 3); // Continua o loop até o jogador escolher sair

        System.out.println("Obrigado por jogar!");
    }
}
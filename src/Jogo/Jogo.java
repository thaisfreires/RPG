package Jogo;

import Entidades.Heroi;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private ArrayList<Sala> mapa;

    public Jogo(ArrayList<Sala> mapa) {
        this.mapa = new ArrayList<>();
    }
    public Heroi criarPersonagem(){
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha o tipo de Herói:");
        System.out.println("1. Cavaleiro");
        System.out.println("2. Feiticeiro");
        System.out.println("3. Arqueiro");
        int tipoHeroi = input.nextInt();

        System.out.println("Escolha a dificuldade:");
        System.out.println("1. Fácil");
        System.out.println("2. Difícil");
        int dificuldade = input.nextInt();

        int pontosCriacao = (dificuldade == 1) ? 300 : 220;
        int ouroInicial = (dificuldade == 1) ? 20 : 15;

        System.out.println("Você tem " + pontosCriacao + " pontos de criação para distribuir entre Vida e Força.");
        int pontosVida = 0, pontosForca = 0;

    }

}

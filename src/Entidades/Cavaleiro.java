package Entidades;

import Itens.Arma;
import Jogo.ConsoleColors;

import java.util.Scanner;

public class Cavaleiro extends Heroi{
    public Cavaleiro(String nome, int hp, int maxHp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, hp, maxHp, forca, nivel, ouro, armaPrincipal);
    }

    /**
     * Método de ataque npc x heroi com redução de 20% na vida do NPC
     * @param npc
     */
    @Override
    public void atacar(NPC npc) {
        System.out.println();

        //Força do inimigo diminuída em 20%
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\n " + npc.nome +" tem força reduzida em 20% " + ConsoleColors.RESET);
        npc.diminuirForcaInicial(0.20);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\n " + npc.nome +" preparando ataque... " + ConsoleColors.RESET);


        //Inimigo ataca primeiro
        int danoInimigo = npc.getForca();
        this.receberDano(danoInimigo);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + npc.getNome() + " atacou " + this.nome + " causando " + danoInimigo + " de dano!"+ ConsoleColors.RESET);


        // Escolha do tipo de ataque do Cavaleiro
        Scanner input = new Scanner(System.in);
        //Enviando opções ao utilizador
        System.out.println("\n --- ESCOLHA O TIPO DE ATAQUE --- ");
        System.out.println("1. Ataque Normal ");
        System.out.println("2. Ataque Especial ");
        System.out.println("3. Usar Consumível de Combate ou uma Poção de Vida/Força do seu Inventário\n");
        //Recebendo a opção escolhida pelo utilizador
        int opcao = input.nextInt();
        System.out.println(">>> " + opcao);

        switch (opcao) {
            case 1:
                System.out.println();

                // Ataque Normal do herói
                npc.hp -= this.forca + armaPrincipal.getAtaque();
                System.out.println("\n            ATAQUE DO HERÓI \n");
                System.out.println(this.nome + " segura o " + armaPrincipal.getNome() + " firmemente, preparando um golpe diagonal...");
                System.out.println("\n⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F\n");
                System.out.println(this.nome + " desferiu um golpe diagonal em " + npc.nome + ", causando " + (this.forca + armaPrincipal.getAtaque()) + " de dano!");

                pausas();


                System.out.println("\n            ATAQUE DO INIMIGO \n");
                System.out.println("O Inimigo contra-ataca com uma fúria impiedosa!");
                System.out.println("\n⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡ \n ");
                System.out.println(npc.nome + " tenta se esquivar, mas é atingido e causa " + npc.forca + " de dano em retorno!");


                break;
            case 2:
                System.out.println();

                // Ataque Especial
                npc.hp -= this.forca + armaPrincipal.getAtaqueEspecial();
                System.out.println(ConsoleColors.GREEN_BOLD + "\n            ATAQUE DO HERÓI \n" + ConsoleColors.RESET);
                System.out.println(this.nome + " dá um salto poderoso no ar, pronto para desferir um ataque devastador com sua " + armaPrincipal.getNome() + "...");
                System.out.println("\n⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F  ⛏\uFE0F\n");
                System.out.println(this.nome + " desce com força, golpeando " + npc.nome + " com um ataque especial, causando " + (this.forca + armaPrincipal.getAtaqueEspecial()) + " de dano!");

                pausas();


                System.out.println(ConsoleColors.RED_BOLD + "\n            ATAQUE DO INIMIGO \n" + ConsoleColors.RESET);
                System.out.println(npc.nome + " mal consegue reagir, sofrendo " + npc.forca + " de dano ao tentar contra-atacar!\n");
                System.out.println("\n⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  \n");
                break;
            case 3:
                System.out.println();

                usarConsumivel(npc);
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nAtaque! " +npc.nome + " atacou " + this.nome + " causando " + danoInimigo + " de dano!"+ ConsoleColors.RESET);
                System.out.println("\n⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  ⚡  \n");

                break;
            default:
                System.out.println("⚠ Opção Inválida ⚠");
        }

    }

    /**
     * Método para acessar os detalhes dos heróis
     */
    @Override
    public void detalhesHeroi() {
        super.detalhesHeroi();
    }


}

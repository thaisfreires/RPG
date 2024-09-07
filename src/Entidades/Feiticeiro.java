package Entidades;

import Itens.Arma;
import Jogo.ConsoleColors;

import java.util.Scanner;

public class Feiticeiro extends Heroi {
    public Feiticeiro(String nome, int hp, int maxHp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, hp, maxHp, forca, nivel, ouro, armaPrincipal);
    }

    /**
     * Método de ataque npc x heroi
     *
     * @param npc
     */
    @Override
    public void atacar(NPC npc) {
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );

        //Utilizador escolhe tipo de ataque
        Scanner input = new Scanner(System.in);
        //Enviando opções ao utilizador
        System.out.println("\n --- ESCOLHA O TIPO DE ATAQUE --- \n");
        System.out.println("1. Ataque Normal ");
        System.out.println("2. Ataque Especial ");
        System.out.println("3. Usar Consumível de Combate ou uma Poção de Vida/Força do seu Inventário");
        //Recebendo a opção escolhida pelo utilizador
        int opcao = input.nextInt();
        System.out.println(">>> " + opcao);

        switch (opcao) {
            case 1:
                // Ataque Normal do herói
                npc.hp -= this.forca + armaPrincipal.getAtaque();
                this.hp -= npc.forca;
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );

                System.out.println("\n            ATAQUE DO HERÓI \n");
                System.out.println(this.nome + " se prepara, segurando firmemente sua " + armaPrincipal.getNome() + "...");
                System.out.println("\n \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5 \n");
                System.out.println("Você atacou " + npc.nome + " com um ataque normal, causando " + (this.forca + armaPrincipal.getAtaque()) + " de dano!");

                Scanner scannerAtaque = new Scanner(System.in);
                System.out.println("\nPressione Enter para receber ataque");
                scannerAtaque.nextLine();

                System.out.println("\n            ATAQUE DO INIMIGO \n" + ConsoleColors.RESET);
                System.out.println(npc.nome + " reagiu e atacou " + this.nome + ", causando " + npc.forca + " de dano!" + ConsoleColors.RESET);
                System.out.println("\n \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8 \n");

                break;
            case 2:
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );

                // Ataque Especial do herói
                npc.hp -= this.forca + armaPrincipal.getAtaqueEspecial();
                this.hp -= npc.forca;
                System.out.println("\n            ATAQUE DO HERÓI \n");
                System.out.println(this.nome + " canaliza sua energia, preparando um ataque especial com " + armaPrincipal.getNome() + "!");
                System.out.println("\n \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5 \n");
                System.out.println(this.nome + " desferiu um ataque especial em " + npc.nome + ", causando " + (this.forca + armaPrincipal.getAtaqueEspecial()) + " de dano devastador!");

                scannerAtaque = new Scanner(System.in);
                System.out.println("\nPressione Enter para receber ataque");
                scannerAtaque.nextLine();

                System.out.println("\n            ATAQUE DO INIMIGO \n");
                System.out.println(npc.nome + " lutou bravamente e atacou " + this.nome + ", causando " + npc.forca + " de dano!");
                System.out.println("\n \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8  \uD83E\uDDE8 \n");

                break;
            case 3:
                usarConsumivel(npc);
                System.out.println("\nAtaque! " +npc.nome + " atacou " + this.nome + " causando " + npc.forca + " de dano!");
                System.out.println("\n \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5  \uD83D\uDCA5 \n");

                break;
            default:
                System.out.println("⚠ Opção Inválida ⚠");        }

    }

    /**
     * Método para acessar os detalhes dos heróis
     */
    @Override
    public void detalhesHeroi() {
        super.detalhesHeroi();
    }

}

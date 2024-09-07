package Entidades;

import Itens.Arma;
import Jogo.ConsoleColors;

import java.util.Scanner;

public class Arqueiro extends Heroi{
    public Arqueiro(String nome, int hp, int maxHp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, hp, maxHp, forca, nivel, ouro, armaPrincipal);
    }

    /**
     * Método de ataque npc x heroi
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

        //Utilizador escolhe o tipo de ataque
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
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );

                // Ataque Normal do Herói
                npc.hp -= this.forca + armaPrincipal.getAtaque();

                System.out.println(ConsoleColors.RED_BOLD + "\n--- ATAQUE DO HERÓI ---\n" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + this.nome + " avança rapidamente, segurando firmemente sua " + armaPrincipal.getNome() + " em posição de estocada...");
                System.out.println("\n~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~ \n");
                System.out.println(this.nome + " perfura " + npc.nome + " com uma estocada precisa, causando " + (this.forca + armaPrincipal.getAtaque()) + " de dano!" + ConsoleColors.RESET);

                Scanner scannerAtaque = new Scanner(System.in);
                System.out.println("\nPressione Enter para receber ataque");
                scannerAtaque.nextLine();

                // Ataque do Inimigo
                System.out.println(ConsoleColors.RED_BOLD + "\n--- ATAQUE DO INIMIGO ---\n" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + npc.nome + " reage rapidamente e ataca " + this.nome + ", causando " + npc.forca + " de dano!" + ConsoleColors.RESET);
                System.out.println("\n🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  \n");


                // Ataque do inimigo com 10% a mais de dano
                int danoInimigo = (int) (npc.getForca() * 1.1);
                this.receberDano(danoInimigo);
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

                // Ataque Especial do Herói
                npc.hp -= this.forca + armaPrincipal.getAtaqueEspecial();

                System.out.println(ConsoleColors.RED_BOLD + "\n--- ATAQUE DO HERÓI ---\n" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + this.nome + " invoca um poder antigo, canalizando energia em sua " + armaPrincipal.getNome() + "...");
                System.out.println("\n~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" );
                System.out.println(this.nome + " atacou " + npc.nome + " com um ataque especial, causando " + (this.forca + armaPrincipal.getAtaqueEspecial()) + " de dano!" + ConsoleColors.RESET);
                System.out.println();
                scannerAtaque = new Scanner(System.in);
                System.out.println("Pressione Enter para receber ataque");
                scannerAtaque.nextLine();

                // Ataque do Inimigo
                System.out.println(ConsoleColors.RED_BOLD + "\n--- ATAQUE DO INIMIGO ---\n" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED + npc.nome + " tenta se defender, mas é atingido com força. Em retaliação, ataca " + this.nome + ", causando " + npc.forca + " de dano!" + ConsoleColors.RESET);
                System.out.println("\n🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  \n");


                // 10% a mais de dano para o inimigo
                danoInimigo = (int) (npc.getForca() * 1.1);
                this.receberDano(danoInimigo);
                break;
            case 3:
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
                System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );

                usarConsumivel(npc);
                // Ataque do inimigo com 10% a mais de dano
                danoInimigo = (int) (npc.getForca() * 1.1); // 10% a mais de dano
                this.receberDano(danoInimigo);
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nAtaque! " +npc.nome + " atacou " + this.nome + " causando " + danoInimigo + " de dano!"+ ConsoleColors.RESET);
                System.out.println("🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  🔥  ");
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

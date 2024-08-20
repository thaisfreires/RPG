package Entidades;

import Itens.Arma;
import Itens.Item;
import Jogo.ConsoleColors;

import java.util.Scanner;

public class Arqueiro extends Heroi{
    public Arqueiro(String nome, int hp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, hp, forca, nivel, ouro, armaPrincipal);
    }

    /**
     * Método de ataque npc x heroi
     * @param npc
     */
    @Override
    public void atacar(NPC npc) {
        npc.hp -=  this.forca;
        this.hp -= npc.forca;
        dano(0.1);

        //SOMAR O ATAQUE DA ARMA
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nAtaque! O Arqueiro " +this.nome+" atacou o " + npc.nome +" !!! " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "\nAtaque! O " + npc.nome +" atacou o Arqueiro "+this.nome+" !!! " + ConsoleColors.RESET);

        //Verifica se ainda existe vida
        if (npc.hp <= 0){
            System.out.println(ConsoleColors.GREEN_BOLD + npc.nome + " DERROTADO! ");
            System.out.println(ConsoleColors.GREEN_BOLD + this.nome + "é o VENCEDOR!!!!");
            this.hp += 10;
            this.forca += 1;
            System.out.println(ConsoleColors.GREEN_BOLD + " Você alcançou o NÍVEL " + (this.nivel += 1) + "!");
            npc.getInventarioNPC();


            //Lista os itens do Inventário de NPC
            int i = 1;
            for(Item item : npc.inventarioNPC){
                System.out.println(ConsoleColors.BLUE + i +": " + item.nome + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "Deseja aceitar esse item? " + item.nome + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "1. SIM " + item.nome + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "2. NÃO " + item.nome + ConsoleColors.RESET);

                Scanner input = new Scanner(System.in);
                int opcao=input.nextInt();

                //Oferece opções para o utilizador adicionar ou não os itens do NPC no inventário
                switch(opcao){
                    case 1:
                        inventario.add(item);
                        System.out.println(ConsoleColors.BLUE + "item adicionado " + item.nome + ConsoleColors.RESET);
                    case 2:
                        System.out.println(ConsoleColors.BLUE + "item descartado " + item.nome + ConsoleColors.RESET);
                }

                i++;
            }
        }
        //Verifica se o herói está vivo
        if (this.hp <=0){
            System.out.println(ConsoleColors.BLUE + this.nome + "perdeu o Jogo! " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + " Boa sorte na próxima! " + ConsoleColors.RESET);

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

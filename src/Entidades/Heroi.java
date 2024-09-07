package Entidades;

import Itens.*;
import Jogo.ConsoleColors;
import Itens.Pocao;
import Itens.ConsumivelCombate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public abstract class Heroi extends Entidade {
    int nivel;
    int ouro;
    Arma armaPrincipal;
    ArrayList<Item> inventario;

    public Heroi(String nome, int hp, int maxHp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, hp, maxHp, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<Item>();
    }

    /**
     * Método abstrato para implementação nas subclassses
     *
     * @param npc
     */
    public abstract void atacar(NPC npc);

    /**
     * Método para acessar os detalhes dos heróis
     */
    public void detalhesHeroi() {
        super.mostrarDetalhes();
        System.out.println("Nível: " + this.nivel + " | Ouro: " + this.ouro + " moedas");
        System.out.println("Arma Principal: " + armaPrincipal.getNome() + " | Ataque da arma: " + armaPrincipal.getAtaque() + " | Ataque Especial da arma: " + armaPrincipal.getAtaqueEspecial());
        System.out.println();
    }

    /**
     * Método que adiciona um item no inventário do herói
     */
    public void adicionarItem(Item item){
        this.inventario.add(item);
    }
    /**
     * Método para remover um item do inventário do herói
     */
    public void removerItem(Item item){
        this.inventario.remove(item);
    }
    /**
     * Método para usar consumível com o input do utilizador.
     */
    public void usarConsumivel (NPC npc){
        if (this.inventario.isEmpty()){
            System.out.println(ConsoleColors.RED + " **** INVENTÁRIO VAZIO " + ConsoleColors.RESET);
            return;
        }
        //Lista os itens do Inventário de Consumíveis
        int i = 1;
        for (Item item : this.inventario) {
            if (item instanceof ConsumivelCombate || item instanceof Pocao) {
                System.out.println(ConsoleColors.BLUE + i + ": " + item.nome + ConsoleColors.RESET);
                i++;
            }
        }
        System.out.println(ConsoleColors.BLUE + "Escolha um item para consumir >>>>  " + ConsoleColors.RESET);
        //Recebe a escolha do utilizador

        Scanner input = new Scanner(System.in);
        int itemEscolhido = input.nextInt();

        if (itemEscolhido > 0 && itemEscolhido <= this.inventario.size()) {
            Item item = this.inventario.get(itemEscolhido - 1);

            if (item instanceof ConsumivelCombate) {
                usarConsumivelCombate((ConsumivelCombate) item, npc);
            } else if (item instanceof Pocao) {
                usarPocao((Pocao) item);
            } else {
                System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Item inválido." + ConsoleColors.RESET);
            }
        } else if (itemEscolhido == 0) {
            System.out.println(" >>> Saindo do inventário ");
        } else {
            System.out.println("⚠ Opção Inválida ⚠");        }

    }
    /**
     * Método que escolhe um consumível e o remove do inventário
     */
    public void usarConsumivelCombate (ConsumivelCombate consumivelCombate, NPC npc){
        npc.hp -= consumivelCombate.getAtaqueInstantaneo(); //Aplica o dano ao NPC
        System.out.println();
        System.out.println(ConsoleColors.BLUE + "Item Usado: " + consumivelCombate.nome + " causando " + consumivelCombate.getAtaqueInstantaneo() + " de dano!" + ConsoleColors.RESET);
        this.inventario.remove(consumivelCombate); //Remove o item do inventário
    }

    /**
     * Método para usar uma poção
     */
    public void usarPocao (Pocao pocao){
        this.forca += pocao.getMaisForca(); //Aumenta força
        //Checa o máximo de vida
        if (this.hp < this.maxHp){
            this.hp += pocao.getCura();//Aumenta vida
        }
        if (this.hp > this.maxHp){
            this.hp = this.maxHp;
            System.out.println(ConsoleColors.PURPLE + "Poção ultrapassa o máximo de vida. Deseja adicionar somente até o máximo?" + ConsoleColors.RESET);
        }

        System.out.println(ConsoleColors.PURPLE + "ITEM USADO >>> " + pocao.nome  + ConsoleColors.RESET);
        this.inventario.remove(pocao); //Remove o item do inventário
    }
    /**
     * Método para escolher pocão para se curar
     */
    public void curar() {
        if (this.inventario.isEmpty()){
            System.out.println(ConsoleColors.RED + " **** INVENTÁRIO VAZIO " + ConsoleColors.RESET);
            return;
        }
        //Lista as poções do Inventário de Consumíveis
        int i = 1;
        for (Item item : this.inventario) {
            if (item instanceof Pocao) {
                System.out.println(ConsoleColors.PURPLE + i + ". " + item.nome + ConsoleColors.RESET);
                i++;
            }
        }
        System.out.println(ConsoleColors.PURPLE + "0: Cancelar" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD + "POÇÃO ESCOLHIDA >>> " + ConsoleColors.RESET);
        //Recebe a escolha do utilizador
        Scanner input = new Scanner(System.in);
        int itemEscolhido = input.nextInt();
        //Opção para não usar poção
        if (itemEscolhido == 0) {
            System.out.println(ConsoleColors.PURPLE + "Ação cancelada." + ConsoleColors.RESET);
            return;
        }
        if (itemEscolhido > 0 && itemEscolhido <= this.inventario.size()) {
            Item item = this.inventario.get(itemEscolhido - 1);
            if (item instanceof Pocao) {
                usarPocao((Pocao) item);
            }else {
                System.out.println("⚠ Opção Inválida ⚠");
                return;
            }
        }else {
            System.out.println("⚠ Opção Inválida ⚠");
            return;
        }
    }

    /**
     * Método para subir o nível quando o NPC for derrotado
     */
    public void subirNivel () {
        this.maxHp += 10; // Aumenta o maxHp ao subir de nível
        this.hp += 10;
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp; // Limita a vida ao maxHp
        }
        this.nivel++;
        System.out.println(ConsoleColors.GREEN_BOLD + "\n ***** PARABÉNS! Você alcançou o NÍVEL " + (this.nivel) + " ***** \n");
    }

    public ArrayList<Item> getInventario () {
        return inventario;
    }

    public int getNivel () {
        return nivel;
    }

    public int getOuro () {
        return ouro;
    }

    public void setNivel ( int nivel){
        this.nivel = nivel;
    }

    public void setOuro ( int ouro){
        this.ouro = ouro;
    }

    public void setInventario (ArrayList <Item> inventario) {
        this.inventario = inventario;
    }

    public Arma getArmaPrincipal () {
        return armaPrincipal;
    }

    public void setArmaPrincipal (Arma armaPrincipal){
        this.armaPrincipal = armaPrincipal;

    }


}




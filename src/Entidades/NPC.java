package Entidades;

import Itens.Consumivel;
import Itens.Item;
import Jogo.ConsoleColors;

import java.util.ArrayList;

import java.util.ArrayList;

public class NPC extends Entidade {
    ArrayList<Item> inventarioNPC;
    int ouro;

    public NPC(String nome, int hp, int forca, int ouro) {
        super(nome, hp, forca);
        this.inventarioNPC = new ArrayList<>();
        this.ouro = ouro;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("-------------------------------------------------");
        super.mostrarDetalhes();
        System.out.println("OURO: " + ouro);
        System.out.println("-------------------------------------------------");
    }
    public void lerInventarioNPC(){
        //Checa se o inventário está vazio
        if (this.inventarioNPC.isEmpty()){
            System.out.println(ConsoleColors.RED_BOLD + "Inventário vazio! " + ConsoleColors.RESET);
            return;
        }
        //Lista os itens do Inventário de NPC
        int i = 1;
        for(Item item : this.inventarioNPC){
            System.out.println(ConsoleColors.BLUE + i +": " + item.nome + ConsoleColors.RESET);
            i++;
        }
    }

    /**
     * Método para diminuir a Força Inicial do Inimigo.
     * @param percentual porcentagem a ser dimunuida/100.
     */
    public void diminuirForcaInicial(double percentual) {
        int quantidade = (int) (this.forca * percentual);
        this.forca -= quantidade;
    }
    public void fimNPC(){
        if (this.hp <= 0) {
            System.out.println(ConsoleColors.RED_BOLD + this.nome + " derrotado! " + ConsoleColors.RESET);
        }
    }

    public ArrayList<Item> getInventarioNPC() {
        return inventarioNPC;
    }

    public void setInventarioNPC(ArrayList<Item> inventarioNPC) {
        this.inventarioNPC = inventarioNPC;
    }

    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }
}


package Entidades;

import Itens.Item;
import Jogo.ConsoleColors;

import java.util.ArrayList;
import java.util.Scanner;

public class NPC extends Entidade {
    int ouro;

    public NPC(String nome, int maxHp, int hp, int forca, int ouro) {
        super(nome, maxHp, hp, forca);
        this.ouro = ouro;
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Ouro: " + ouro + "moedas");
        System.out.println("-------------------------------------------------");
    }

    /**
     * Método para diminuir a Força Inicial do Inimigo.
     * @param percentual porcentagem a ser dimunuida/100.
     */
    public void diminuirForcaInicial(double percentual) {
        int quantidade = (int) (this.forca * percentual);
        this.forca -= quantidade;
    }


    public int getOuro() {
        return ouro;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }


}


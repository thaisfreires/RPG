package Jogo;

import Entidades.NPC;
import Entidades.Vendedor;
import Itens.Item;

import java.util.ArrayList;

public class Sala {
    private String nome;
    private int id;
    private ArrayList<Integer> idSalaConectada;
    private ArrayList<NPC> inimigosNaSala;
    private Vendedor vendedorPresente;
    private ArrayList<Item> itemPerdido;
    private int danoArmadilha;
    private int ouroPerdido;

    public Sala(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.idSalaConectada = new ArrayList<>();
        this.inimigosNaSala = inimigosNaSala;
        this.vendedorPresente = vendedorPresente;
        this.itemPerdido = itemPerdido;
        this.danoArmadilha = danoArmadilha;
        this.ouroPerdido = ouroPerdido;
    }
    public void boasVindas() {
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "BEM VINDO A SALA * " + this.nome +" *" + ConsoleColors.RESET);
    }

}

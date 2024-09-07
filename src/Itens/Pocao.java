package Itens;

import Entidades.Entidade;
import Entidades.Heroi;
import Jogo.ConsoleColors;

import java.util.ArrayList;

public class Pocao extends Consumivel {
    int cura;
    int maisForca;

    public Pocao(String nome, int precoOuro, int cura, int maisForca) {
        super(nome, precoOuro);
        this.cura = cura;
        this.maisForca = maisForca;
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Cura: " + this.cura + " | Mais Força: " + this.maisForca);
    }

    public int getCura() {
        return cura;
    }

    public int getMaisForca() {
        return maisForca;
    }
}


package Itens;

import java.util.ArrayList;

public class Arma extends Item {
    String nome;
    int ataque;
    int ataqueEspecial;

    public Arma(String nome, int precoOuro, int ataque, int ataqueEspecial) {
        super(nome, precoOuro);
        this.nome=nome;
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println(" Nome da Arma: " + this.nome + " | Ataque: " + this.ataque + " | Ataque Especial: " + this.ataqueEspecial);
    }

    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

}


package Itens;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {
    int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int precoOuro, int ataqueInstantaneo) {
        super(nome, precoOuro);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Ataque Instantaneo: " + this.ataqueInstantaneo);
    }

    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }
}


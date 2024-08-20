package Itens;

public class ConsumivelCombate extends Consumivel {
    int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int precoOuro, int ataqueInstantaneo) {
        super(nome, precoOuro);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Ataque Instantaneo: " + ataqueInstantaneo);
    }

    public int getAtaqueInstantaneo() {
        return ataqueInstantaneo;
    }
}


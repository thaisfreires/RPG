package Jogo.eventos;

import Entidades.Heroi.Heroi;
import Entidades.Vendedor;
import Itens.Arma;
import Itens.ConsumivelCombate;
import Itens.Pocao;

public class Eventoloja implements Evento{

    @Override
    public void executar(Heroi heroi) {
        Vendedor vendedor = new Vendedor();
        vendedor.adicionarItemLoja(new Arma("Espada de Aço Valiriano", 50, 20, 35));
        vendedor.adicionarItemLoja(new Pocao("Poção de Vida", 25, 25, 0));
        vendedor.adicionarItemLoja(new ConsumivelCombate("Flecha de Fogo", 10, 15));

        vendedor.abrirLoja(heroi);
    }
}

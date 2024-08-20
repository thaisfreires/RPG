package Entidades;

import Itens.*;
import Jogo.ConsoleColors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Vendedor {
    ArrayList<Item> loja;

    public Vendedor() {
        this.loja = new ArrayList<>();
    }

    /**
     * Método que imprime 10 itens aleatórios da loja.
     */
    public void imprimirLoja() {
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "Bem Vindo á esta loja! Aqui você encontrará vários itens que precisará" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "Aqui estão os itens disponíveis: " + ConsoleColors.RESET);

        //Escolhendo itens aleatorios
        Collections.shuffle(loja);

        //Imprimir máximo 10 itens
        int i = 1;
        for (Item itemLoja : loja) {
            while (i < 10){
                System.out.println(ConsoleColors.BLUE_BACKGROUND + i + ". NOME: "+ itemLoja.nome + "PREÇO: " + itemLoja.getPrecoOuro() + "OURO" + ConsoleColors.RESET);
                i++;
            }
        }
    }

    /**
     * Método que checa se a compra pode ser efetuada e acrescenta no inventário do herói
     * @param heroi
     */
    public void vender(Heroi heroi) {

        //Checa se existe itens na loja
        if (this.loja.isEmpty()) {
            System.out.println(ConsoleColors.RED_BOLD + "Não existe itens nessa loja. " + ConsoleColors.RESET);
            return;
        }

        //Lista os itens disponíveis na loja
        imprimirLoja();

        //Recebe input sobre escolha do item
        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + " - Digite o número do item escolhido ou digite 0 para sair da loja: ");
        int escolha = input.nextInt();

        //Pegar item pelo index
        Item itemLoja = this.loja.get(escolha - 1);
        do {
            if (heroi.ouro >= itemLoja.getPrecoOuro()) {
                //Checar se é uma Poção
                if (itemLoja instanceof Pocao) {
                    heroi.getInventario().add((Pocao) itemLoja);
                    System.out.println(ConsoleColors.PURPLE + "O item selecionado para compra é uma POÇÃO " + ConsoleColors.RESET);
                }
                //Checar se é uma Arma
                if (itemLoja instanceof Arma) {
                    System.out.println(ConsoleColors.YELLOW_BOLD + "O item selecionado para compra é uma ARMA. Sua ARMA será substituída " + ConsoleColors.RESET);
                    heroi.setArmaPrincipal((Arma) itemLoja);
                }
                //Checa se é Consumível
                if (itemLoja instanceof ConsumivelCombate) {
                    System.out.println(ConsoleColors.GREEN_BOLD + "O item selecionado para compra é um CONSUMÍVEL DE COMBATE " + ConsoleColors.RESET);
                    heroi.getInventario().add((ConsumivelCombate) itemLoja);
                }
                //Subtrai o ouro do herói para a venda
                heroi.setOuro(heroi.ouro - itemLoja.getPrecoOuro());
                //Confirmação ao utilizador
                System.out.println(ConsoleColors.BLUE + "COMPRA EFETUADA COM SUCESSO! " + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "Você adquiriu: " + itemLoja.nome + ConsoleColors.RESET);
            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Ouro Insuficiente para compra" + ConsoleColors.RESET);
            }

        } while (escolha != 0);
    }



}


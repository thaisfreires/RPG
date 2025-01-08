package Entidades;

import Entidades.Heroi.Heroi;
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
        System.out.println();
        System.out.println(ConsoleColors.YELLOW + "\n        -- ITENS DISPONÍVEIS -- \n" + ConsoleColors.RESET);

        //Embaralhando os item da loja
        Collections.shuffle(loja);

        //Definindo máximo de 10 itens
        int i = 0;
        while (i >= 0 && i <= 10){
                Item itemLoja = loja.get(i);
                System.out.println(ConsoleColors.YELLOW + (i + 1) + ". Item: " + itemLoja.nome + " | Preço: " + itemLoja.getPrecoOuro() + " moedas de ouro" + ConsoleColors.RESET);
                i++;
        }
    }

    /**
     * Método que checa se a compra pode ser efetuada e acrescenta no inventário do herói
     * @param heroi criado
     */
    public void vender(Heroi heroi) {

        //Lista os itens disponíveis na loja
        this.imprimirLoja();

        Scanner input = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW + "\n - Digite o número do item escolhido ou digite 0 para sair da loja >>> " + ConsoleColors.RESET);

        int itemEscolhido = input.nextInt();

        // Checa se o item é válido
        if (itemEscolhido > 0 && itemEscolhido <= this.loja.size()) {
            // Pegar item pelo index
            Item itemLoja = this.loja.get(itemEscolhido - 1);

            if (heroi.ouro >= itemLoja.getPrecoOuro()) {
                //Checar se é uma Poção
                if (itemLoja instanceof Pocao) {
                    System.out.println(ConsoleColors.PURPLE + "O item selecionado para compra é uma POÇÃO " + ConsoleColors.RESET);
                }
                //Checar se é uma Arma
                if (itemLoja instanceof Arma) {
                    System.out.println(ConsoleColors.BLUE + "O item selecionado para compra é uma ARMA. Sua ARMA será substituída " + ConsoleColors.RESET);
                    // Remove a arma atual do herói
                    if (heroi.getArmaPrincipal() != null) {
                        heroi.getInventario().remove(heroi.getArmaPrincipal());
                    }
                    heroi.setArmaPrincipal((Arma) itemLoja);
                }
                //Checa se é Consumível
                if (itemLoja instanceof ConsumivelCombate) {
                    System.out.println(ConsoleColors.GREEN + "O item selecionado para compra é um CONSUMÍVEL DE COMBATE " + ConsoleColors.RESET);
                }
                //Subtrai o ouro do herói para a venda
                heroi.setOuro(heroi.ouro - itemLoja.getPrecoOuro());
                // Adiciona o item ao inventário
                heroi.getInventario().add(itemLoja);
                //Confirmação ao utilizador
                System.out.println(ConsoleColors.GREEN_BOLD + " -- COMPRA EFETUADA COM SUCESSO! -- " + ConsoleColors.RESET);
                System.out.println(ConsoleColors.YELLOW + "\nVocê adquiriu: " + itemLoja.nome);
                System.out.println("Preço: " + itemLoja.getPrecoOuro());
                System.out.println("Ouro restante: " + heroi.ouro + " moedas de ouro\n" + ConsoleColors.RESET);
            } else {
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Ouro Insuficiente para compra" + ConsoleColors.RESET);
                return;
            }
        } else if (itemEscolhido == 0) {
            System.out.println(ConsoleColors.WHITE + ">>> Saindo da loja." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + ">>> Opção Inválida" + ConsoleColors.RESET);
        }

    }

    public void adicionarItemLoja(Item item){
        loja.add(item);
    }



}


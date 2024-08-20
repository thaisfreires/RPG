package Itens;

import Jogo.ConsoleColors;

import java.util.ArrayList;

public abstract class Item {
    public String nome;
    int precoOuro;
    ArrayList<String> heroisValidos;

    public Item(String nome, int precoOuro) {
        this.nome = nome;
        this.precoOuro = precoOuro;
        this.heroisValidos = new ArrayList<>();
    }

    public void mostrarDetalhes() {
        System.out.println("Nome: " + nome + " Preço: " + precoOuro + " Heróis Válidos: " + heroisValidos);
    }

    public String getNome() {
        return nome;
    }

    public int getPrecoOuro() {
        return precoOuro;
    }

    public ArrayList<String> getHeroisValidos() {
        return heroisValidos;
    }

    public void lerListaHeroisValidos(){
        //Checa se o inventário está vazio
        if (this.heroisValidos.isEmpty()){
            System.out.println(ConsoleColors.RED_BOLD + "Lista vazia! " + ConsoleColors.RESET);
            return;
        }
        //Lista os itens da lista de heróis válidos
        int i = 1;
        for(String item : this.heroisValidos){
            System.out.println(ConsoleColors.BLUE + i +": " + item + ConsoleColors.RESET);
            i++;
        }

    }
}

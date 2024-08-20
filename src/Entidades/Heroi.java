package Entidades;

import Itens.Arma;
import Itens.Item;
import Itens.Pocao;
import Jogo.ConsoleColors;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Heroi extends Entidade {
    int nivel;
    int ouro;
    Arma armaPrincipal;
    ArrayList<Item> inventario;

    public Heroi(String nome, int hp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, hp, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<Item>();
    }

    /**
     * Método abstrato para implementação nas subclassses
     *
     * @param npc
     */
    public abstract void atacar(NPC npc);

    /**
     * Método para acessar os detalhes dos heróis
     */
    public void detalhesHeroi() {
        System.out.println("-------------------------------------------------");
        System.out.println("Herói " + this.nome);
        System.out.println("Vidas " + this.hp);
        System.out.println("Força " + this.forca);
        System.out.println("Nível " + this.nivel);
        System.out.println("Ouro " + this.ouro);
        System.out.println("Arma " + armaPrincipal.getNome());
        System.out.println("-------------------------------------------------");
    }

    /**
     * Método para calcular um dano por porcentagem
     *
     * @param percentual
     */
    public void dano(double percentual) {
        int quantidade = (int) (this.forca * percentual / 100);
        this.forca -= quantidade;
    }

    /**
     * Método de escolha de tipo de Ataque.
     */
    public void ataque(NPC NPC) {
        Scanner input = new Scanner(System.in);
        //Enviando opções ao utilizador
        System.out.println(ConsoleColors.BLUE + " --- Escolha um tipo de ataque --- " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "1. Ataque Normal " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "2. Ataque Especial " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "3. Usar Consumível" + ConsoleColors.RESET);
        //Recebendo a opção escolhida pelo utilizador
        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                ataqueNormal(NPC);
                break;
            case 2:
                ataqueEspecial(NPC);
                break;
            case 3:
                usarConsumivel();
                break;
            default:
                System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Opção Inválida" + ConsoleColors.RESET);

        }
    }

    /**
     * Método de ataque normal em que diminui a força/vida do inimigo e do heroi + o ataque da Arma.
     */
    public void ataqueNormal(NPC npc) {
        //Ataque ao inimigo
        npc.hp -= this.forca + armaPrincipal.getAtaque();
        //Ataque ao herói
        this.hp -= npc.forca;
    }

    /**
     * Método especial de ataque em que diminui vida + força + força especial da Arma.
     */
    public void ataqueEspecial(NPC npc) {
        //Ataque ao inimigo
        npc.hp -= this.forca + armaPrincipal.getAtaqueEspecial();
        //Ataque ao herói
        this.hp -= npc.forca;
    }

    /**
     * Método que lê os itens do Inventário de Consumíveis.
     */
    public void lerInventarioConsumiveis() {
        //Checa se o inventário está vazio
        if (this.inventario.isEmpty()) {
            System.out.println(ConsoleColors.RED_BOLD + "Inventário vazio! " + ConsoleColors.RESET);
            return;
        }
        //Lista os itens do Inventário de Consumíveis
        int i = 1;
        for (Item item : this.inventario) {
            System.out.println(ConsoleColors.BLUE + i + ": " + item.nome + ConsoleColors.RESET);
            i++;
        }

    }

    /**
     * Método para usar consumível com o input do utilizador.
     */
    public void usarConsumivel() {
        lerInventarioConsumiveis();
        System.out.println(ConsoleColors.BLUE + "Escolha um item para consumir: " + ConsoleColors.RESET);
        //Recebe a escolha do utilizador

        Scanner input = new Scanner(System.in);
        int itemEscolhido = input.nextInt();

        Item item = this.inventario.get(itemEscolhido - 1);
        // ADICIONAR EFEITO DO CONSUMIVEL

        //Remove o item esolhido do inventário Consumíveis
        System.out.println(ConsoleColors.BLUE + "Item Usado: " + item.nome + ConsoleColors.RESET);
        this.inventario.remove(item);
    }

    /**
     * Método para escolher e usar uma porção
     */
    public void usarPocao() {
        //Lista as Poções disponíveis
        System.out.println(ConsoleColors.PURPLE + " --- Escolha uma poção --- " + ConsoleColors.RESET);
        int i = 1;
        for (Item item : this.inventario) {
            if (item instanceof Pocao) {
                System.out.println(ConsoleColors.PURPLE + i + ": " + item.nome + ConsoleColors.RESET);
                i++;
            }
        }
        //Recebe a escolha do utilizador
        Scanner input = new Scanner(System.in);
        int itemEscolhido = input.nextInt();

        //Busca os atributos de Poção
        Item item = this.inventario.get(itemEscolhido - 1);
        if (item instanceof Pocao) {
            Pocao itemPocao = (Pocao) item;

            //Usando a porção para aumentar vida/força
            this.hp += itemPocao.getCura();
            this.forca += itemPocao.getMaisForca();

            //Remove o item esolhido do inventário Consumíveis
            this.inventario.remove(itemPocao);
            System.out.println(ConsoleColors.PURPLE + "Item Escolhido: " + itemPocao.nome + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Opção Inválida" + ConsoleColors.RESET);
            return;
        }
    }

    public ArrayList<Item> getInventario () {
        return inventario;
    }

    public int getNivel() {
        return nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }

    public Arma getArmaPrincipal() {
        return armaPrincipal;
    }

    public void setArmaPrincipal(Arma armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }
}



package Entidades;

public abstract class Entidade {
    String nome;
    int hp;
    int forca;

    public Entidade(String nome, int hp, int forca) {
        this.nome = nome;
        this.hp = hp;
        this.forca = forca;
    }

    public void mostrarDetalhes() {
        System.out.println("NOME ENTIDADE: | " + nome + " | VIDA: " + hp + " HP" +" | FORÇA: " + forca);
    }

}


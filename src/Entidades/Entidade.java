package Entidades;

public abstract class Entidade {
    String nome;
    int maxHp;
    int hp;
    int forca;

    public Entidade(String nome, int maxHp, int hp, int forca) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.hp = hp;
        this.forca = forca;
    }

    public void mostrarDetalhes() {
        System.out.println("Nome:  " + nome + " | Vida: " + hp + " hp" + " | Máximo de vida: " + maxHp + " maxHp" + " | Força: " + forca);
    }

    /**
     * Método para verificar se a entidade está morta
     * @return true
     */
    public boolean estaMorto(){
        if (this.hp <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Método para matar herói ao cair na armadilha do Jogo
     */
    public void morrer(){
        this.hp = 0;
        this.maxHp = 0;

    }

    /**
     * Método para receber dano
     */
    public void receberDano(int dano) {
        this.hp -= dano;
    }

    public String getNome() {
        return nome;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getForca() {
        return forca;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

}


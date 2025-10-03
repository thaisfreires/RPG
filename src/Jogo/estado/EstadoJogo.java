package Jogo.estado;

import Entidades.Heroi.Heroi;

public class EstadoJogo {
    private Heroi heroi;
    private Sala salaAtual;
    private boolean jogoAcabou = false;

    public EstadoJogo(Heroi heroi, Sala salaInicial) {
        this.heroi = heroi;
        this.salaAtual = salaInicial;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public Sala getSalaAtual() {
        return salaAtual;
    }

    public void setSalaAtual(Sala sala) {
        this.salaAtual = sala;
    }

    public boolean isJogoAcabou() {
        return jogoAcabou;
    }

    public void encerrarJogo() {
        this.jogoAcabou = true;
    }
}

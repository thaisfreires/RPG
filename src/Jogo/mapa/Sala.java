package Jogo.mapa;

import Entidades.Heroi.Heroi;
import Jogo.eventos.Evento;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int id;
    private String nome;
    private List<Sala> salasDisponiveis;
    private List<Evento> eventos;

    public Sala(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.salasDisponiveis = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public void conectarSala(Sala proximaSala) {
        this.salasDisponiveis.add(proximaSala);
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void entrar(Heroi heroi) {
        for (Evento e : eventos) {
            e.executar(heroi);
        }
    }

    public List<Sala> getSalasDisponiveis() {
        return salasDisponiveis;
    }

    public String getNome() {
        return nome;
    }
}

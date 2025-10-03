package Jogo;

import Jogo.estado.EstadoJogo;
import Jogo.eventos.Evento;
import Jogo.ui.InterfaceJogo;

public class MotorJogo {
    private EstadoJogo estado;
    private InterfaceJogo ui;

    public MotorJogo(EstadoJogo estado, InterfaceJogo ui) {
        this.estado = estado;
        this.ui = ui;
    }

    public void executar(){
        while (!estado.isJogoAcabou()) {
            Sala sala = estado.getSalaAtual();
            ui.mostrarSala(sala);

            // Executa todos os eventos da sala
            for (Evento e : sala.getEventos()) {
                e.executar(estado, ui);
                if (estado.isJogoAcabou()) return;
            }

            // Escolher próxima sala
            if (!sala.getConexoes().isEmpty()) {
                ui.mostrarMensagem("Escolha para onde ir:");
                for (int i = 0; i < sala.getConexoes().size(); i++) {
                    ui.mostrarMensagem((i + 1) + ". " + sala.getConexoes().get(i).getNome());
                }
                int escolha = ui.lerOpcao(sala.getConexoes().size());
                estado.setSalaAtual(sala.getConexoes().get(escolha - 1));
            } else {
                ui.mostrarMensagem("Você chegou ao fim!");
                estado.encerrarJogo();
            }
        }

    }
}

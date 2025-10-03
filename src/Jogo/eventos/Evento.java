package Jogo.eventos;

import Entidades.Heroi.Heroi;
import Jogo.estado.EstadoJogo;
import Jogo.ui.InterfaceJogo;

public interface Evento {
    void executar(Heroi heroi);

}

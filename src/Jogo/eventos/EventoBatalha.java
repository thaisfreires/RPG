package Jogo.eventos;

import Entidades.Heroi.Heroi;
import Entidades.NPC;
import Jogo.estado.EstadoJogo;
import Jogo.ui.InterfaceJogo;

public class EventoBatalha implements Evento{
    private NPC inimigo;

    public EventoBatalha(NPC inimigo) {
        this.inimigo = inimigo;
    }

    @Override
    public void executar(Heroi heroi) {
        System.out.println("⚔️ Você encontrou " + inimigo.getNome() + "!");
        while (!inimigo.estaMorto() && !heroi.estaMorto()) {
            heroi.atacar(inimigo);
            if (!inimigo.estaMorto()) {
                inimigo.atacar(heroi);
            }
        }

        if (heroi.estaMorto()) {
            System.out.println("💀 Você foi derrotado...");
        } else {
            System.out.println("🏆 " + inimigo.getNome() + " foi derrotado!");
        }
    }
}

package Jogo;

import Entidades.Heroi;/*
public boolean derrotaNPC (NPC npc){
        //Verifica se ainda existe vida
        if (npc.estaMorto()) {
            System.out.println(ConsoleColors.GREEN_BOLD + npc.nome + " DERROTADO! ");
            System.out.println(ConsoleColors.GREEN_BOLD + this.nome + "é o VENCEDOR!!!!");

            //Sobe o nível e ajusta vida do herói
            this.subirNivel();

            // Aumenta a força do herói
            this.setForca(this.getForca() + 1);

            //Transfere os itens do NPC para o Heroi como recompensa
            npc.recompensaNPC(this);

            // Transfere o ouro do NPC para o herói
            this.setOuro(this.getOuro() + npc.getOuro());

            return true; // NPC derrotado
        }else {
            System.out.println(ConsoleColors.RED + "Cuidado! O inimigo ainda está vivo e pronto pra mais um ataque! " + ConsoleColors.RESET);
            return false; //NPC vivo
        }
    }


public boolean derrotaHeroi(Heroi heroi){
    if (heroi.getHp() <= 0){
        System.out.println(ConsoleColors.RED + "Você foi derrotado!" + ConsoleColors.RESET);
        return true; //Herói morreu
    }
    return false; //Herói está vivo
}


public class Rascunhos {
    switch (salaAtual.getId()) {
        case 1:
            salaAtual.salaDoVendedor(heroi, vendedor);
            break;
        case 2:
            salaAtual.salaDeEldoria(heroi, littleFinger);
            break;
        case 3:
            salaAtual.salaDeThaloria(heroi, reiDoGelo);
            break;
        case 4:
            salaAtual.salaDeRavenfell(heroi, vaghar);
            break;
        case 5:
            salaAtual.salaDoPocoDosDesejos(heroi);
            break;
        case 6:
            salaAtual.salaMisteriosa(heroi);
            break;
        default:
            System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Opção Inválida" + ConsoleColors.RESET);
    }
}
    // Método para gerenciar o combate
    private void combate(Heroi heroi, NPC npc) {
        while (!derrotaNPC(NPC npc) {
            // Ataque do Herói
            heroi.atacar(npc);
        }
    }
    // Lógica do combate contra o Dragão Vhagar
        boolean heroiVenceu = lutar(heroi, vaghar);

        if (heroiVenceu) {
            // Herói venceu
            System.out.println(ConsoleColors.GREEN_BOLD + "O Herói venceu!" + ConsoleColors.RESET);
            heroi.subirNivel(); // Sobe de nível
            heroi.curar(10);  // Cura 10 pontos de vida
            heroi.setForca(heroi.getForca() + 1); // Aumenta a força em 1
            heroi.setOuro(heroi.getOuro() + vaghar.getOuro()); // Pega o ouro do NPC
            vaghar.recompensaNPC(heroi); // Recompensa do NPC
        } else {
            // NPC venceu
            System.out.println(ConsoleColors.RED_BOLD + "O Dragão Vhagar venceu!" + ConsoleColors.RESET);
        }
                    System.out.println(ConsoleColors.RED + "Cuidado! O inimigo ainda está vivo e pronto pra mais um ataque! " + ConsoleColors.RESET);




*/
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

// MEU MAIN

        Jogo jogo = new Jogo();
        Scanner input = new Scanner(System.in);
        int escolha = 0;
        Heroi heroi = null; // Inicializa o herói como null

        do {
            if (escolha == 1) { // Jogar novamente com a mesma personagem
                if (heroi != null) { // Verifica se o herói já foi criado
                    jogo.tresReinos(); // Configura o jogo (salas, etc.)
                    jogo.jogar(); // Inicia o loop principal do jogo
                } else {
                    System.out.println("Você precisa criar um personagem primeiro!");
                }
            } else if (escolha == 2) { // Criar uma nova personagem
                heroi = jogo.criarPersonagem();
            } else if (escolha == 3) { // Sair do jogo
                break; // Sai do loop
            } else {
                System.out.println("Opção inválida.");
            }

            // Verifica se o jogador deseja jogar novamente
            if (heroi != null) {
                System.out.println(">>> O jogo acabou! Você foi derrotado! ");
                System.out.println("\nO que você deseja fazer?\n");
                System.out.println("1. Jogar novamente com a mesma personagem");
                System.out.println("2. Criar uma nova personagem");
                System.out.println("3. Sair do jogo");
                System.out.println(" >>> ");

                escolha = input.nextInt();
                input.nextLine(); // Limpa o buffer do Scanner
            }

        } while (true); // Continua o loop até o jogador escolher sair

        System.out.println("Obrigado por jogar!");
        input.close();
    }
            gerenciarSalas(heroi, sala0, sala1, sala2, sala3, sala4, sala5);

          do{
                //Salas nível 1
                if (heroi.getNivel() == 1) {
                    sala0 .conectar(sala1); // Vendedor para Eldoria
                    sala0.conectar(sala2); // Vendedor para Thaloria
                    sala0.conectar(sala3); // Vendedor para Ravenfell
                }

                //Salas nível 2
                if (heroi.getNivel() == 2) {
                    sala1.conectar(sala3); // Eldoria para Ravenfell
                    sala1.conectar(sala2); // Eldoria para Thaloria

                    sala2.conectar(sala3); // Thaloria para Ravenfell
                    sala2.conectar(sala0); // Thaloria para Vendedor

                    sala3.conectar(sala5); // Ravenfell para Sala misteriosa
                    sala3.conectar(sala0); // Ravenfell para Vendedor
                    sala3.conectar(sala2); // Ravenfell para Thaloria
                }

                //Salas nível 3
                if (heroi.getNivel() == 3) {
                    sala0.conectar(sala4); // Vendedor para Fonte da Harmonia
                    sala0.conectar(sala5); // Vendedor para Sala Misteriosa

                    sala1.conectar(sala4); // Eldoria para Fonte da Harmonia
                    sala1.conectar(sala5); // Eldoria para Sala Misteriosa

                    sala2.conectar(sala4); // Thaloria para Fonte da Harmonia
                    sala2.conectar(sala5); // Thaloria para Sala Misteriosa

                    sala3.conectar(sala4); // Ravenfell para Fonte da Harmonia
                    sala3.conectar(sala5); // Ravenfell para Sala Misteriosa

                    sala5.conectar(sala4); // Sala Misteriosa para Fonte da Harmonia
                }
            }while (heroi.getNivel() <= 3);



            public void gerenciarSalas(Heroi heroi) {
        int nivel = heroi.getNivel();

        do {
            switch (nivel) {
                case 1:
                    salas.get(0).conectar(salas.get(1)); // Conectar Vendedor para Eldoria
                    salas.get(0).conectar(salas.get(2)); // Conectar Vendedor para Thaloria
                    salas.get(0).conectar(salas.get(3)); // Conectar Vendedor para Ravenfell
                    break;

                case 2:
                    salas.get(1).conectar(salas.get(3)); // Eldoria para Ravenfell
                    salas.get(1).conectar(salas.get(2)); // Eldoria para Thaloria

                    salas.get(2).conectar(salas.get(3)); // Thaloria para Ravenfell
                    salas.get(2).conectar(salas.get(0)); // Thaloria para Vendedor

                    salas.get(3).conectar(salas.get(5)); // Ravenfell para Sala Misteriosa
                    salas.get(3).conectar(salas.get(0)); // Ravenfell para Vendedor
                    break;

                case 3:
                    salas.get(0).conectar(salas.get(4)); // Vendedor para Fonte da Harmonia
                    salas.get(0).conectar(salas.get(5)); // Vendedor para Sala Misteriosa

                    salas.get(1).conectar(salas.get(4)); // Eldoria para Fonte da Harmonia
                    salas.get(1).conectar(salas.get(5)); // Eldoria para Sala Misteriosa

                    salas.get(3).conectar(salas.get(4)); // Ravenfell para Fonte da Harmonia
                    salas.get(3).conectar(salas.get(5)); // Ravenfell para Sala Misteriosa
                    break;

                default:
                    System.out.println("Nenhuma conexão disponível para o nível do herói.");
                    break;
            }

            // Aqui podemos sair do loop após definir as conexões
            nivel = 0; // Para sair do loop (simulação)
        } while (nivel > 0);
    }

  NPC vaghar = new NPC("Dragão Vaghar", 200, 200, 25, 120);
        NPC littleFinger = new NPC("Bruxo Little Finger", 150, 150, 15, 80);
        NPC reiDoGelo = new NPC("Rei do Gelo", 190, 190, 20, 110);
        NPC serpente = new NPC("Serpente Guardiã", 100, 100, 15, 0);

    }

    public void opcoesDeMovimento(int indexId) {
        ArrayList<Sala> opcoes = salaAtual.getSalasDisponiveis();

        if (indexId >= 0 && indexId < opcoes.size()) {
            salaAtual = opcoes.get(indexId);
        } else {
            System.out.println("Não há movimentações disponível.");
        }
    }

}
*/
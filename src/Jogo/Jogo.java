package Jogo;

import Entidades.*;
import Itens.Arma;
import Itens.ConsumivelCombate;
import Itens.Pocao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private ArrayList<Sala> salas;
    private Sala salaAtual;

    public Jogo() {
        this.salas = new ArrayList<>();
    }


    /**
     * Método que imprime o conteudo de um ficheiro na consola
     *
     * @param path Caminho para o ficheiro
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static void imprimirFicheiro(String path) throws FileNotFoundException {

        Scanner scannerFicheiro = new Scanner(new File(path));

        while (scannerFicheiro.hasNext()) {
            String linhaAtual = scannerFicheiro.nextLine();
            System.out.println(linhaAtual);
        }

    }

    /**
     * Método para criação do Personagem e categoria do Jogo adicionango pontos de vida e força.
     *
     * @return herói selecionado para o jogo
     */
    public Heroi criarPersonagem() throws FileNotFoundException {

        imprimirFicheiro("src/Arquivos/BemVindo");
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("\nPressione Enter para jogar...");
        input.nextLine();
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );

        // Recebe input para qual herói escolher
        System.out.println(ConsoleColors.CYAN_BOLD + "\n======================================================================" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BOLD + "                     Escolha seu Herói         " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "======================================================================" + ConsoleColors.RESET);
        System.out.println();

        System.out.println(ConsoleColors.RED_BOLD + "1. Feiticeira Rainha Daenerys" + ConsoleColors.RESET);
        System.out.println("   A destemida rainha e feiticeira, com o poder de controlar as chamas");
        System.out.println("   e manipular a magia antiga.");
        System.out.println();

        System.out.println(ConsoleColors.GREEN_BOLD + "2. Arqueira Arya" + ConsoleColors.RESET);
        System.out.println("   A ágil arqueira e sobrevivente, equipada com habilidades excepcionais");
        System.out.println("   de combate à distância e astúcia nas sombras.");
        System.out.println();

        System.out.println(ConsoleColors.BLUE_BOLD + "3. Cavaleira Brienne" + ConsoleColors.RESET);
        System.out.println("   A valente cavaleira e defensora, conhecida por sua força imbatível" );
        System.out.println("   e lealdade inabalável, sempre pronta para o combate corpo a corpo.");
        System.out.println();

        System.out.print(ConsoleColors.YELLOW_BOLD + " >>>> " + ConsoleColors.RESET);

        int tipoHeroi = input.nextInt();

        // Recebe o input do nível de dificuldade
        System.out.println(ConsoleColors.CYAN_BOLD + "\n======================================================================" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BOLD + "                      Nível de Dificuldade        " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "======================================================================" + ConsoleColors.RESET);
        System.out.println();

        System.out.println(ConsoleColors.PURPLE + "1. Fácil" + ConsoleColors.RESET);
        System.out.println("   Uma jornada mais tranquila, ideal para");
        System.out.println( "   novos aventureiros que buscam um desafio");
        System.out.println("   mais acessível.");
        System.out.println();

        System.out.println(ConsoleColors.RED_BOLD + "2. Difícil" + ConsoleColors.RESET);
        System.out.println("   Um caminho desafiador e perigoso,");
        System.out.println("   para aqueles que buscam uma verdadeira");
        System.out.println("   prova de coragem e habilidades.");
        System.out.println();
        System.out.print(ConsoleColors.YELLOW_BOLD + " >>>> " + ConsoleColors.RESET);

        int dificuldade = input.nextInt();

        // Pontos adquiridos de acordo com o nível de dificuldade
        int pontosCriacao = (dificuldade == 1) ? 300 : 220;
        // Ouro para início de jogo
        int ouroInicial = (dificuldade == 1) ? 20 : 15;

        // Distribui com o input do utilizador os Pontos de Criação
        int pontosVida = 0, pontosForca = 0;

        while (pontosCriacao > 0) {
            System.out.println(ConsoleColors.CYAN_BOLD + "\n======================================================================" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW_BOLD + "             Distribuição de Pontos de Criação   " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN_BOLD + "======================================================================" + ConsoleColors.RESET);
            System.out.println();

            System.out.println("Você tem " + pontosCriacao + " pontos de criação disponíveis!");
            System.out.println("\nDistribua esses pontos entre Vida e Força para personalizar seu herói.");
            System.out.println("1 ponto de criação = 1 xp (vida) e 5 pontos de criação = 1 ponto de Força. ");
            System.out.println("Por exemplo, 100 Pontos = 20 de Força ");
            System.out.println();

            // Solicita pontos de Vida ao usuário
            System.out.print(ConsoleColors.YELLOW_BOLD + "Pontos de Vida >>>> " + ConsoleColors.RESET);
            int vidaInicial = input.nextInt();

            // Solicita pontos de Força ao usuário
            System.out.print(ConsoleColors.YELLOW_BOLD + "Pontos de Força >>>> " + ConsoleColors.RESET);
            int forcaInicial = input.nextInt();

            // Calcula os pontos totais usados com base nos pontos inseridos
            int pontosUsados = vidaInicial + (forcaInicial * 5);

            if (pontosUsados > pontosCriacao) {
                // Se total exceder os pontos disponíveis
                System.out.println(ConsoleColors.RED_BOLD + "Você não pode alocar mais pontos do que os pontos de criação disponíveis!" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED_BOLD + "Por favor, tente novamente." + ConsoleColors.RESET);
            } else if (pontosUsados < pontosCriacao) {
                // Se ainda restarem pontos após a distribuição
                System.out.println(ConsoleColors.YELLOW_BOLD + "Você ainda tem " + (pontosCriacao - pontosUsados) + " pontos de criação disponíveis." + ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED_BOLD + "Distribua todos os pontos antes de continuar." + ConsoleColors.RESET);

                // Atualiza os valores de vida e força, mas ainda restam pontos a distribuir
                pontosVida += vidaInicial;
                pontosForca += forcaInicial;
                pontosCriacao -= pontosUsados;
            } else {
                // Se o custo total for exatamente igual aos pontos disponíveis
                pontosVida += vidaInicial;
                pontosForca += forcaInicial;
                pontosCriacao -= pontosUsados;
            }

            System.out.println(); // Para espaçamento
        }

        // Cria um herói baseado no tipo escolhido e lhe atribui uma Arma Inicial
        Heroi heroi;
        Arma armaInicial;

        switch (tipoHeroi) {
            case 1:
                armaInicial = new Arma("Cetro Mágico", 15, 10, 20);
                heroi = new Feiticeiro("Feiticeira Rainha Daenerys ", pontosVida, pontosVida, pontosForca, 1, ouroInicial, armaInicial);
                break;
            case 2:
                armaInicial = new Arma("Arco Longo", 15, 8, 15);
                heroi = new Arqueiro("Arqueira Arya", pontosVida, pontosVida, pontosForca, 1, ouroInicial, armaInicial);
                break;
            case 3:
                armaInicial = new Arma("Espada Longa", 15, 12, 18);
                heroi = new Cavaleiro("Cavaleira Brienne", pontosVida, pontosVida, pontosForca, 1, ouroInicial, armaInicial);
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD + "Escolha inválida! A Rainha será atribuída por padrão." + ConsoleColors.RESET);
                armaInicial = new Arma("Cetro Mágico", 15, 10, 20);
                heroi = new Feiticeiro("Rainha Daenerys", pontosVida, pontosVida, pontosForca, 1, ouroInicial, armaInicial);
                break;
        }
        // Verificação final
        if (heroi != null) {
            System.out.println(ConsoleColors.YELLOW + "\n >>>>  HERÓI CRIADO COM SUCESSO  <<<< \n" );
            heroi.detalhesHeroi();
            System.out.println(ConsoleColors.RESET);
            System.out.println();
            System.out.println("\nPressione Enter para começar o jogo...");
            input = new Scanner(System.in);
            input.nextLine();

        } else {
            System.out.println("Erro na criação do herói.");
        }

        // Retorna o herói criado
        return heroi;
    }

    public void tresReinos(Heroi heroi) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                            ║");
        System.out.println("║   Bem-vindo ao mundo de '3 Reinos'!                        ║");
        System.out.println("║   Os três reinos estão em caos, e apenas você pode         ║");
        System.out.println("║   restaurar a paz.                                         ║");
        System.out.println("║   Sua missão é derrotar o dragão Vaghar,                   ║");
        System.out.println("║   o bruxo Little Finger, e o Rei do Gelo.                  ║");
        System.out.println("║   Prepare-se para os desafios que estão por vir!           ║");
        System.out.println("║                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("\nPressione Enter para continuar...");
        input.nextLine();

        // Instanciando os itens para o Vendedor
        Vendedor vendedor = new Vendedor();

        vendedor.adicionarItemLoja(new Arma("Espada de Aço Valiriano", 50, 20, 35));
        vendedor.adicionarItemLoja(new Arma("Arco do Lobo Gigante", 45, 18, 30));
        vendedor.adicionarItemLoja(new Arma("Cetro da Luz", 40, 15, 28));
        vendedor.adicionarItemLoja(new Pocao("Poção de Vida", 25, 25, 0)); // Cura 25 de vida
        vendedor.adicionarItemLoja(new Pocao("Poção de Força", 30, 0, 10)); // Aumenta força em 10
        vendedor.adicionarItemLoja(new ConsumivelCombate("Flecha de Fogo", 10, 15)); // Ataque instantâneo
        vendedor.adicionarItemLoja(new ConsumivelCombate("Bombas de Gelo", 15, 20)); // Ataque instantâneo
        vendedor.adicionarItemLoja(new Pocao("Elixir da Resistência", 35, 0, 15)); // Aumenta força em 15
        vendedor.adicionarItemLoja(new Arma("Cajado dos Antigos", 50, 17, 32));
        vendedor.adicionarItemLoja(new ConsumivelCombate("Lâminas Envenenadas", 20, 25)); // Ataque instantâneo
        vendedor.adicionarItemLoja(new Pocao("Poção do Vigor", 40, 30, 0)); // Cura 30 de vida
        vendedor.adicionarItemLoja(new Pocao("Poção de Velocidade", 20, 0, 8)); // Aumenta força em 8
        vendedor.adicionarItemLoja(new Arma("Espada Curta", 20, 10, 15));

        // Instanciando os inimigos
        NPC vaghar = new NPC("Dragão Vaghar", 200, 200, 35, 120);
        NPC littleFinger = new NPC("Bruxo Little Finger", 150, 150, 25, 80);
        NPC reiDoGelo = new NPC("Rei do Gelo", 190, 190, 30, 110);
        NPC serpente = new NPC("Serpente Guardiã", 100,100,15,0);

        // Instanciando as salas
        salas = new ArrayList<>(); // Inicializando o ArrayList de salas
        salas.add(new Sala(0, "Vendedor"));
        salas.add(new Sala(1, "Eldoria - O Bosque Encantado, lar de mistérios e magia antiga."));
        salas.add(new Sala(2, "Thaloria - As Montanhas Geladas do Norte, onde o frio e o perigo são constantes."));
        salas.add(new Sala(3, "Ravenfell - O Reino Sombrio, com o fosso do dragão e sombras traiçoeiras."));
        salas.add(new Sala(4, "Fonte da Harmonia"));
        salas.add(new Sala(5, "Caverna Misteriosa"));

        //Buscando as conexões entre as salas
        gerenciarSalas(heroi);

        // Iniciando o jogo na Sala do Vendedor
        salaAtual = salas.get(0);

        // Loop do jogo
        while (!heroi.estaMorto()) {
            // Executando a sala atual
            executarSalaAtual(heroi, vendedor, littleFinger, reiDoGelo, vaghar, serpente);

            // Mostrar opções de movimento
            direcao(heroi);
        }
    }

    /**
     * Método que gerencia as conexões possíveis entre as salas
     */
    public void gerenciarSalas(Heroi heroi){
        //Salas nível 1
        if (heroi.getNivel() == 1) {
            salas.get(0).adicionarSalasDisponiveis(1); // Vendedor para Eldoria
            salas.get(0).adicionarSalasDisponiveis(2); // Vendedor para Thaloria
            salas.get(0).adicionarSalasDisponiveis(3); // Vendedor para Ravenfell
        }

        //Salas nível 2
        if (heroi.getNivel() == 2) {
            salas.get(1).adicionarSalasDisponiveis(3); // Eldoria para Ravenfell
            salas.get(1).adicionarSalasDisponiveis(2); // Eldoria para Thaloria

            salas.get(2).adicionarSalasDisponiveis(3); // Thaloria para Ravenfell
            salas.get(2).adicionarSalasDisponiveis(0); // Thaloria para Vendedor

            salas.get(3).adicionarSalasDisponiveis(5); // Ravenfell para Sala misteriosa
            salas.get(3).adicionarSalasDisponiveis(0); // Ravenfell para Vendedor
            salas.get(3).adicionarSalasDisponiveis(3); // Ravenfell para Thaloria
        }
        //Salas nível 3
            if (heroi.getNivel() == 3) {
                salas.get(0).adicionarSalasDisponiveis(4); // Vendedor para Fonte da Harmonia
                salas.get(0).adicionarSalasDisponiveis(5); // Vendedor para Sala Misteriosa

                salas.get(1).adicionarSalasDisponiveis(4); // Eldoria para Fonte da Harmonia
                salas.get(1).adicionarSalasDisponiveis(5); // Eldoria para Sala Misteriosa

                salas.get(2).adicionarSalasDisponiveis(4); // Thaloria para Fonte da Harmonia
                salas.get(2).adicionarSalasDisponiveis(5); // Thaloria para Sala Misteriosa

                salas.get(3).adicionarSalasDisponiveis(4); // Ravenfell para Fonte da Harmonia
                salas.get(3).adicionarSalasDisponiveis(5); // Ravenfell para Sala Misteriosa

                salas.get(5).adicionarSalasDisponiveis(4); // Sala Misteriosa para Fonte da Harmonia
            }

    }
    private void executarSalaAtual(Heroi heroi, Vendedor vendedor, NPC littleFinger, NPC reiDoGelo, NPC vaghar, NPC serpente) throws FileNotFoundException {
        switch (salaAtual.getId()) {
            case 0:
                salaAtual.salaDoVendedor(heroi, vendedor);
                break;
            case 1:
                salaAtual.salaDeEldoria(heroi, littleFinger);
                break;
            case 2:
                salaAtual.salaDeThaloria(heroi, reiDoGelo);
                break;
            case 3:
                salaAtual.salaDeRavenfell(heroi, vaghar);
                break;
            case 4:
                salaAtual.salaFonteDaHarmonia(heroi, serpente);
                break;
            case 5:
                salaAtual.salaMisteriosa(heroi);
                break;
            default:
                System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Opção Inválida" + ConsoleColors.RESET);
        }
    }
    private void direcao(Heroi heroi) {
        System.out.println(ConsoleColors.CYAN_BOLD + "\n======================================================================\n" + ConsoleColors.RESET);
        if (heroi.getNivel() == 1) { // Mostrar opções de reino na fase 1
            System.out.println("Você está à beira de uma decisão crucial em sua jornada.");
            System.out.println("Os três reinos estão em caos, e sua escolha determinará o início de sua missão.\n");
            System.out.println(ConsoleColors.YELLOW_BOLD + "\uD83D\uDCAA Qual reino você escolherá para começar sua busca pela Pedra da Paz?");
            System.out.println();


            for (int i = 0; i < salaAtual.getSalasDisponiveis().size(); i++) {
                //Lendo as salas disponíveis para esse nível
                int idProximaSala = salaAtual.getSalasDisponiveis().get(i);
                System.out.println((i + 1) + ". " + salas.get(idProximaSala).getNome());
            }
            Scanner input = new Scanner(System.in);
            System.out.println("Digite o número correspondente ao reino desejado >>> " );
            int escolha = input.nextInt();

            if (escolha > 0 && escolha <= salaAtual.getSalasDisponiveis().size()) {
                salaAtual = salas.get(salaAtual.getSalasDisponiveis().get(escolha));
            } else {
                System.out.println(ConsoleColors.RED + "Opção Inválida" + ConsoleColors.RESET);
            }

        } else if (heroi.getNivel() == 2) { // Mostrar opções de caminho na fase 2
            System.out.println("Você avançou em sua jornada e agora se depara com novos caminhos.");
            System.out.println("Cada caminho leva a desafios diferentes e oportunidades únicas.");
            System.out.println(ConsoleColors.YELLOW_BOLD + "Qual direção você escolherá para continuar sua busca pela Pedra da Paz?" + ConsoleColors.RESET);
            System.out.println();
            for (int i = 0; i < salaAtual.getSalasDisponiveis().size(); i++) {
                //Lendo as salas disponíveis para esse nível
                int idProximaSala = salaAtual.getSalasDisponiveis().get(i);
                System.out.println((i + 1) + ". " + salas.get(idProximaSala).getNome());
            }
            System.out.println(ConsoleColors.YELLOW_BOLD + "Digite o número correspondente ao caminho desejado >>> " + ConsoleColors.RESET);

        } else if (heroi.getNivel() == 3) { // Mostrar opções para a pedra da paz na fase 3
            System.out.println(ConsoleColors.BLUE_BOLD + "Você chegou ao fim de sua jornada, onde os desafios finais o aguardam.");
            System.out.println("A batalha decisiva se aproxima e você precisa fazer uma escolha crítica.");
            System.out.println(ConsoleColors.YELLOW_BOLD + "Qual será o seu próximo passo para completar a missão e restaurar a paz?" + ConsoleColors.RESET);
            System.out.println();
            for (int i = 0; i < salaAtual.getSalasDisponiveis().size(); i++) {
                //Lendo as salas disponíveis para esse nível
                int idProximaSala = salaAtual.getSalasDisponiveis().get(i);
                System.out.println((i + 1) + ". " + salas.get(idProximaSala).getNome());
            }
            System.out.println(ConsoleColors.YELLOW_BOLD + "Digite o número correspondente ao desafio que deseja enfrentar >>> " + ConsoleColors.RESET);
            System.out.println("0. Usar Poções");
        }
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= salaAtual.getSalasDisponiveis().size()) {
            salaAtual = salas.get(salaAtual.getSalasDisponiveis().get(escolha - 1));
        } else if (escolha == 0) {
            heroi.curar();
        } else {
            System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Opção Inválida" + ConsoleColors.RESET);
        }
    }
}
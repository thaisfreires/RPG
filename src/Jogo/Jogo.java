package Jogo;

import Entidades.*;
import Itens.Arma;
import Itens.ConsumivelCombate;
import Itens.Pocao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    public ArrayList<Sala> salas;
    private Sala salaAtual;
    private Heroi primeiroHeroi;

    public Jogo() {
        this.salas = new ArrayList<>();
        configurarSalas();
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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

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
        System.out.println("   A valente cavaleira e defensora, conhecida por sua força imbatível");
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
        System.out.println("   novos aventureiros que buscam um desafio");
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
            heroi = new Clone(heroi.getNome(), heroi.getHp(),heroi.getMaxHp(),heroi.getForca(),heroi.getNivel(),heroi.getOuro(),heroi.getArmaPrincipal());
            primeiroHeroi = heroi.clonar();

            System.out.println(ConsoleColors.YELLOW + "\n >>>>  HERÓI CRIADO COM SUCESSO  <<<< \n");
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

    public void configurarSalas(){


        //Instanciando as salas
        Sala sala0 = new Sala(0, "Vendedor");
        Sala sala1 = new Sala(1, "Eldoria - O Bosque Encantado, lar de mistérios e magia antiga.");
        Sala sala2 = new Sala(2, "Thaloria - As Montanhas Geladas do Norte, onde o frio e o perigo são constantes.");
        Sala sala3 = new Sala(3, "Ravenfell - O Reino Sombrio, com o fosso do dragão e sombras traiçoeiras.");
        Sala sala4 = new Sala(4, "Fonte da Harmonia");
        Sala sala5 = new Sala(5, "Caverna Misteriosa");

        //Adicionando as salas
        salas.add(sala0);
        salas.add(sala1);
        salas.add(sala2);
        salas.add(sala3);
        salas.add(sala4);
        salas.add(sala5);

        // Começar na sala 0
        salaAtual = sala0;

        //Adicionar conexões entre as salas
        sala0.conectar(sala1); // Vendedor para Eldoria
        sala0.conectar(sala2); // Vendedor para Thaloria
        sala0.conectar(sala3); // Vendedor para Ravenfell

        sala1.conectar(sala3); // Eldoria para Ravenfell
        sala1.conectar(sala2); // Eldoria para Thaloria

        sala2.conectar(sala3); // Thaloria para Ravenfell
        sala2.conectar(sala0); // Thaloria para Vendedor

        sala3.conectar(sala5); // Ravenfell para Sala misteriosa
        sala3.conectar(sala0); // Ravenfell para Vendedor
        sala3.conectar(sala2); // Ravenfell para Thaloria

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

    /**
     * Método de execução do jogo
     * @param heroi já criado
     * @throws FileNotFoundException
     */
    public void tresReinos(Heroi heroi) throws FileNotFoundException, CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                            ║");
        System.out.println("║   Bem-vindo ao mundo de '3 Reinos'!                        ║");
        System.out.println("║   Os três reinos estão em caos, e apenas você pode         ║");
        System.out.println("║   restaurar a paz.                                         ║");
        System.out.println("║   Sua missão é derrotar o dragão Vaghar,                   ║");
        System.out.println("║   o bruxo Little Finger, e o Rei do Gelo e encontrar       ║");
        System.out.println("║   a PEDRA DA PAZ que está perdida.                         ║");
        System.out.println("║   Prepare-se para os desafios que estão por vir!           ║");
        System.out.println("║                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("\nPressione Enter para continuar...");
        input.nextLine();


        salaAtual = getSalaAtual();


        do{
            // Executar a sala atual
            executarSalaAtual(heroi);

            // Mostrar opções de movimento
            direcao();

        }while (!salaAtual.jogoAcabou);

        opcoesFimDeJogo(heroi);

    }

    /**
     * Método com opções para o fim ou recomeço do jogo.
     * @param heroi clonado ou recriado
     * @throws FileNotFoundException caso nao encontre o arquivo
     * @throws CloneNotSupportedException
     */
    public void opcoesFimDeJogo(Heroi heroi) throws FileNotFoundException, CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("1. Jogar novamente com a mesma personagem");
        System.out.println("2. Jogar novamente com nova personagem ");
        System.out.println("3. Sair");
        int escolha = input.nextInt();
        input.nextLine(); // Limpa o buffer do Scanner

        switch (escolha) {
            case 1:
                heroi = primeiroHeroi.clonar();
                // Reseta o jogo (reinicia o nível do herói e a sala atual)
                heroi.setNivel(1);
                setSalaAtual(salas.get(0)); // Volta para a sala inicial
                salaAtual.jogoAcabou = false; // Reseta o jogoAcabou
                tresReinos(heroi);
                break;
            case 2:
                criarPersonagem();
                tresReinos(heroi);
                break;
            case 3:
                System.out.println("\nObrigado por jogar!\n");
                System.exit(0);
                break;
        }

    }


    /**
     * Método para executar a lógica da sala atual
     */
    private void executarSalaAtual(Heroi heroi) throws FileNotFoundException, CloneNotSupportedException {

        switch (salaAtual.getId()) {
            case 0:
                salaAtual.salaDoVendedor(heroi);
                break;
            case 1:
                salaAtual.salaDeEldoria(heroi);
                break;
            case 2:
                salaAtual.salaDeThaloria(heroi);
                break;
            case 3:
                salaAtual.salaDeRavenfell(heroi);
                break;
            case 4:
                salaAtual.salaFonteDaHarmonia(heroi);
                break;
            case 5:
                salaAtual.salaMisteriosa(heroi);
                break;
            default:
                System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Opção Inválida" + ConsoleColors.RESET);
        }
    }

    /**
     * Método para mostrar as opções de direções
     */
    private void direcao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n------------------------------------------------------------");
        System.out.println("Opções de Movimento:");

        //Mostrar as opções de salas disponíveis diretamente da sala atual
        ArrayList<Sala> salasDisponiveis = salaAtual.getSalasDisponiveis();

        for (int i = 0; i < salasDisponiveis.size(); i++) {
            Sala proximaSala = salasDisponiveis.get(i); // Acessa a sala diretamente da lista
            System.out.println((i + 1) + ". " + proximaSala.getNome());
        }
        System.out.println("Digite o número correspondente ao movimento desejado >>> ");

        //Lê a escolha do usuário
        int escolhaSalaAtual = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do Scanner

        //Processando a escolha
        if (escolhaSalaAtual > 0 && escolhaSalaAtual <= salasDisponiveis.size()) {
            // Atualiza a sala atual com a sala escolhida usando o método setSalaAtual
            setSalaAtual(salasDisponiveis.get(escolhaSalaAtual - 1));
        } else {
            System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Opção Inválida" + ConsoleColors.RESET);
        }
    }


    public Sala getSalaAtual() {
        return salaAtual;
    }

    public void setSalaAtual(Sala novaSalaAtual) {
        this.salaAtual = novaSalaAtual;
    }
}

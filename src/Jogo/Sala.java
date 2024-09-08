package Jogo;

import Entidades.Heroi;
import Entidades.NPC;
import Entidades.Vendedor;
import Itens.Arma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sala {
    protected int id;
    protected String nome;
    protected ArrayList<Integer> salasDisponiveis;
    private ArrayList<Sala> salas;


    public Sala(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.salasDisponiveis = new ArrayList<>();
        this.salas = new ArrayList<>();

    }
    public void conectar(int id){
        if (!salasDisponiveis.contains(getId())) {  // Evitar duplicatas
            salasDisponiveis.add(getId());  // Adiciona a sala à lista de conexões
            System.out.println("Sala " + this.id + " conectada à sala " + salas);
        }
    }


    public ArrayList<Integer> getSalasDisponiveis() {
        return salasDisponiveis;
    }

    /**
     * Sala do Vendedor onde são vendidos itens para a jornada do utilizador
     * @param heroi criado
     * @param vendedor criado
     * @throws FileNotFoundException caso não encontre o arquivo
     */
    public void salaDoVendedor(Heroi heroi, Vendedor vendedor) throws FileNotFoundException {
        System.out.println(ConsoleColors.YELLOW);
        imprimirFicheiro("src/Arquivos/EscritoLoja");
        System.out.println();
        System.out.println("\n -- Aqui você encontrará vários itens que precisará para sua jornada -- \n");
        int opcao;

        do{
            //Oferece opções ao utilizador
            System.out.println("\n1. Ver os itens à venda");
            System.out.println("2. Comprar um item");
            System.out.println("3. Sair da loja");

            //Recebe a escolha do utilizador e acessa o conteúdo escolhido
            Scanner input = new Scanner(System.in);
            opcao = input.nextInt();
            System.out.println(">>> " + opcao);


                switch (opcao) {
                    case 1:
                        vendedor.imprimirLoja();
                        break;
                    case 2:
                        vendedor.vender(heroi);
                        break;
                    case 3:
                        System.out.println(">>> Saindo da loja\n");
                        break;
                    default:
                        System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Opção Inválida\n" + ConsoleColors.RESET);
                }
        }while (opcao != 3);
    }

    /**
     * Método que imprime o conteudo de um ficheiro na consola
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
     * Nessa Sala tem um ataque e no final apresenta poções a serem usadas
     * @param heroi criado pelo utilizador
     * @param littleFinger npc da Sala
     * @throws FileNotFoundException caso não encontre o arquivo
     */
    public void salaDeEldoria(Heroi heroi, NPC littleFinger) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        imprimirFicheiro("src/Arquivos/reino");

        System.out.println(ConsoleColors.PURPLE + "\nVocê caminha pelo " + ConsoleColors.GREEN_BOLD + "Bosque Encantado de Eldoria" + ConsoleColors.PURPLE + ", quando a névoa começa a se intensificar." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "De repente, uma figura sombria emerge das sombras, envolta em um manto negro." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "O ar fica mais pesado e um frio arrepiante percorre sua espinha." + ConsoleColors.RESET);
        System.out.println();
        pausas();

        imprimirFicheiro("src/Arquivos/magoVendedor");
        System.out.println(ConsoleColors.RED_BOLD + "\nBruxo Little Finger: " + ConsoleColors.RESET + "Bem-vindo a Eldoria, forasteiro... Eu sou Little Finger, o guardião das trevas que permeiam este bosque.");
        System.out.println(ConsoleColors.RED_BOLD + "Bruxo Little Finger: " + ConsoleColors.RESET + "Vejo que sua jornada é ousada, mas será sua última. A Pedra da Paz? Ah, uma lenda tão tola quanto os tolos que a buscam.");
        System.out.println(ConsoleColors.RED_BOLD + "Bruxo Little Finger: " + ConsoleColors.RESET + "Você não passará por aqui sem enfrentar o verdadeiro poder que habita esta terra.");
        System.out.println();

        System.out.println(ConsoleColors.PURPLE + "Você se prepara para o combate..." + ConsoleColors.RESET);
        System.out.println();

        System.out.println(ConsoleColors.RED_BOLD + "Bruxo Little Finger: " + ConsoleColors.RESET + "Coragem... um traço admirável, mas fútil. As trevas de Eldoria não conhecem piedade, e eu sou seu mestre.");
        System.out.println(ConsoleColors.RED_BOLD + "Bruxo Little Finger: " + ConsoleColors.RESET + "Vou apreciar ver sua determinação se transformar em desespero. Prepare-se para ser consumido pelas sombras!");
        System.out.println();
        pausas();

        System.out.println(ConsoleColors.PURPLE + "O combate começa..." + ConsoleColors.RESET);

        //Método de combate entre heroi e npc
        combate(heroi, littleFinger);
        System.out.println(ConsoleColors.PURPLE + "Com o Bruxo Little Finger derrotado, o caminho à frente começa a se abrir." + ConsoleColors.RESET);
        //Método que permite o herói usar porçoes do seu inventário antes de seguir
        saidaSala(heroi);
        System.out.println();
    }

    public void salaDeThaloria(Heroi heroi, NPC reiDoGelo) throws FileNotFoundException {
        imprimirFicheiro("src/Arquivos/thaloria");

        System.out.println(ConsoleColors.PURPLE + "Você avança pelas " + ConsoleColors.CYAN_BOLD + "Montanhas Geladas de Thaloria" + ConsoleColors.PURPLE + ", onde o vento uiva e o frio corta como lâminas." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "A neve densa cobre o caminho, tornando cada passo uma luta contra os elementos." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "De repente, o ar ao seu redor fica ainda mais gelado, e você percebe uma presença imponente emergindo da nevasca." + ConsoleColors.RESET);
        System.out.println();
        pausas();

        System.out.println(ConsoleColors.CYAN_BOLD + "Rei do Gelo: " + ConsoleColors.RESET + "Intruso! Você ousa desafiar o domínio das montanhas geladas? Eu sou o Rei do Gelo, o senhor deste reino congelado.");
        System.out.println(ConsoleColors.CYAN_BOLD + "Rei do Gelo: " + ConsoleColors.RESET + "A Pedra da Paz? Sua busca é vã, pois seu calor não pode penetrar a frieza de Thaloria.");
        System.out.println(ConsoleColors.CYAN_BOLD + "Rei do Gelo: " + ConsoleColors.RESET + "Você jamais deixará este lugar vivo. Seu destino está selado no gelo eterno.");
        System.out.println();

        System.out.println(ConsoleColors.PURPLE + "Você sente o frio aumentar à medida que se prepara para o combate..." + ConsoleColors.RESET);
        System.out.println();

        System.out.println(ConsoleColors.CYAN_BOLD + "Rei do Gelo: " + ConsoleColors.RESET + "Prepare-se para ser congelado nas profundezas do esquecimento! Meu poder é absoluto nas terras geladas de Thaloria.");
        System.out.println();
        pausas();

        System.out.println(ConsoleColors.PURPLE + "O combate começa..." + ConsoleColors.RESET);
        // Método de combate entre heroi e NPC
        combate(heroi, reiDoGelo);
        pausas();
        System.out.println(ConsoleColors.PURPLE + "Com o Rei do Gelo derrotado, o gelo ao seu redor começa a derreter, revelando uma passagem entre as montanhas." + ConsoleColors.RESET);
        // Método que permite o herói usar poções do seu inventário antes de seguir

        saidaSala(heroi);
        System.out.println();


    }

    public void salaDeRavenfell(Heroi heroi, NPC vaghar) throws FileNotFoundException {
        imprimirFicheiro("src/Arquivos/reinoDragao");

        System.out.println(ConsoleColors.PURPLE + "Você adentra o sombrio e desolado " + ConsoleColors.RED_BOLD + "Reino de Ravenfell" + ConsoleColors.PURPLE + ", onde as cinzas dos vulcões pintam o céu de vermelho e o calor sufocante emana do solo." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "Cavernas gigantescas e montanhas escarpadas dominam o horizonte, e você sente uma presença ancestral vigiando cada passo que dá." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "De repente, um rugido ensurdecedor ecoa pelas montanhas, e o chão treme sob seus pés." + ConsoleColors.RESET);
        System.out.println();
        pausas();

        imprimirFicheiro("src/Arquivos/dragao");
        System.out.println(ConsoleColors.RED_BOLD + "Vhagar: " + ConsoleColors.RESET + "Quem ousa entrar em meu domínio? Eu sou Vhagar, o antigo e último dos grandes dragões! Este reino é meu, e nenhum mortal sobreviverá para contar a história.");
        System.out.println(ConsoleColors.RED_BOLD + "Vhagar: " + ConsoleColors.RESET + "A Pedra da Paz? Tolice... Nem mesmo ela pode salvar você do fogo que está prestes a consumir sua carne e ossos.");
        System.out.println();

        System.out.println(ConsoleColors.PURPLE + "O calor se intensifica enquanto você se prepara para enfrentar o dragão mais temido de todos os tempos..." + ConsoleColors.RESET);
        System.out.println();

        System.out.println(ConsoleColors.RED_BOLD + "Vhagar: " + ConsoleColors.RESET + "Sinta o poder do meu fogo, tolo mortal! Suas esperanças serão reduzidas a cinzas em um instante." + ConsoleColors.RESET);
        System.out.println();
        pausas();

        System.out.println(ConsoleColors.PURPLE + "O combate começa..." + ConsoleColors.RESET);
        // Método de combate entre heroi e NPC
        combate(heroi, vaghar);
        System.out.println(ConsoleColors.PURPLE + "Com Vhagar derrotado, as chamas que cobriam as montanhas começam a apagar, revelando um caminho que leva adiante." + ConsoleColors.RESET);
        // Método que permite o herói usar poções do seu inventário antes de seguir
        saidaSala(heroi);
        System.out.println();
        System.out.println();

    }

    public void salaFonteDaHarmonia(Heroi heroi, NPC serpente) throws FileNotFoundException {
        imprimirFicheiro("src/Arquivos/poçoDesejos");

        System.out.println(ConsoleColors.CYAN + "Você chega à " + ConsoleColors.BLUE_BOLD + "Fonte da Harmonia" + ConsoleColors.CYAN + ". O local é envolto em uma aura mágica e pacífica, com águas que emitem uma luz suave e tranquilizadora." + ConsoleColors.RESET);
        pausas();

        //Descrição do ambiente
        System.out.println(ConsoleColors.CYAN + "À medida que se aproxima, o ambiente começa a vibrar levemente, e você avista a Pedra da Paz repousando no fundo da fonte." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN + "De repente, uma presença ameaçadora se manifesta. Das sombras ao redor da fonte, um inimigo surge com um olhar ameaçador." + ConsoleColors.RESET);
        System.out.println();

        System.out.println(ConsoleColors.RED_BOLD + "Serpente Guardiã: " + ConsoleColors.RESET + "Você ousa buscar a harmonia enquanto eu ainda existo? A Pedra da Paz não será sua sem uma última provação!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD + "Serpente Guardiã: " + ConsoleColors.RESET + "Você terá que enfrentar a escuridão antes de obter a luz. Prepare-se!" + ConsoleColors.RESET);
        System.out.println();

        pausas();
        System.out.println(ConsoleColors.CYAN + "Você se prepara para a batalha decisiva, sabendo que enfrentar o inimigo é o último passo antes de reivindicar a Pedra da Paz." + ConsoleColors.RESET);
        System.out.println();

        System.out.println(ConsoleColors.CYAN + "Para esse combate você terá sua força aumentada e uma nova Arma está na sua frente." + ConsoleColors.RESET);
        heroi.setForca(100);
        heroi.setArmaPrincipal(new Arma("Machado do Guerreiro", 0, 22, 35));
        System.out.println("Arma " + heroi.getArmaPrincipal() + " | Ataque: " + heroi.getArmaPrincipal().getAtaque() + " | Ataque Especial : " + heroi.getArmaPrincipal().getAtaqueEspecial());
        System.out.println("Força: " + heroi.getForca());
        imprimirFicheiro("src/Arquivos/MachadoFinal");
        pausas();

        // Método de combate entre herói e inimigoFinal
        combate(heroi, serpente);
        pausas();
        imprimirFicheiro("src/Arquivos/Fireworks");
        System.out.println(ConsoleColors.CYAN + "\nApós derrotar a Serpente Guardiã, a fonte volta a brilhar suavemente, revelando a Pedra da Paz." + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD + "Você segura a Pedra da Paz com um sentimento de realização e esperança renovada. Você alcançou seu objetivo. PARABÉNS!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "OS 3 REINOS ESTÃO EM FESTA!!");


        imprimirFicheiro("src/Arquivos/musica");
        imprimirFicheiro("src/Arquivos/Winner");
        System.out.println();

    }

    public void salaMisteriosa(Heroi heroi) throws FileNotFoundException {
        System.out.println(ConsoleColors.YELLOW + "Você entrou na Sala Misteriosa!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "O que você irá encontrar aqui?" + ConsoleColors.RESET);

        Random random = new Random();
        int chanceArmadilha = random.nextInt(100);

        if (chanceArmadilha < 50) {
            int dano = random.nextInt(30) + 1; // Dano entre 1 e 30
            System.out.println(ConsoleColors.RED_BOLD + "Cuidado!" + ConsoleColors.RESET + " Ao dar o primeiro passo, o chão se abre e lanças afiadas disparam das paredes!");
            System.out.println(ConsoleColors.RED_BOLD + "Você foi atingido por uma armadilha e perdeu " + dano + " de vida!" + ConsoleColors.RESET);
            heroi.receberDano(dano);
        } else {
            int chanceMorte = random.nextInt(100);
            if (chanceMorte < 50) {
                System.out.println(ConsoleColors.RED_BOLD + "Perigo mortal!" + ConsoleColors.RESET + " Um gás venenoso preenche a sala rapidamente.");
                System.out.println(ConsoleColors.RED_BOLD + "Você inalou o veneno e sua visão começa a escurecer... você não sobreviveu." + ConsoleColors.RESET);
                heroi.morrer();
                imprimirFicheiro("src/Arquivos/GAMEOVER");
            } else {
                System.out.println(ConsoleColors.GREEN_BOLD + "Sorte a sua!" + ConsoleColors.RESET + " A sala parecia perigosa, mas você conseguiu passar por ela sem maiores problemas.");
                System.out.println(ConsoleColors.GREEN_BOLD + "Você sai da Sala Misteriosa ileso, mas com os nervos à flor da pele." + ConsoleColors.RESET);
            }
        }
    }

    /**
     * Método de combate para definir quando a luta termina
     * @param heroi
     * @param npc checa derrota do npc
     */
    public void combate(Heroi heroi, NPC npc) throws FileNotFoundException {
        //Definir ataque enquanto o NPC estiver vivo
        while (!npc.estaMorto()) { // Continua o loop enquanto o NPC estiver vivo

            heroi.atacar(npc);

            if (npc.estaMorto()) {
                System.out.println(ConsoleColors.GREEN_BOLD + "\n======================================================================\n" + ConsoleColors.RESET);

                System.out.println(ConsoleColors.GREEN_BOLD + npc.getNome() + " foi DERROTADO e você venceu o combate! \n" + ConsoleColors.RESET);

                //Sobe o nível e ajusta vida do herói
                heroi.subirNivel();
                // Aumenta a força do herói
                heroi.setForca(heroi.getForca() + 1);
                System.out.println(ConsoleColors.GREEN_BOLD +"+ 1 Força" + ConsoleColors.RESET);

                System.out.println(ConsoleColors.GREEN_BOLD +"+ " + npc.getOuro() + " ouro" + ConsoleColors.RESET);
                // Transfere o ouro do NPC para o herói
                heroi.setOuro(heroi.getOuro() + npc.getOuro());
                System.out.println();
                System.out.println(ConsoleColors.GREEN_BOLD + "\n*** Você alcançou o NÍVEL " + (heroi.getNivel()) + " \n");

                heroi.detalhesHeroi();
                System.out.println(ConsoleColors.GREEN_BOLD + "\n======================================================================\n" + ConsoleColors.RESET);

                System.out.println();
                break; // Sai do loop
            }

            // Verifica se o herói morreu, mesmo que o NPC ainda esteja vivo
            if (heroi.estaMorto()) {
                imprimirFicheiro("src/Arquivos/GAMEOVER");
                System.out.println(ConsoleColors.RED_BOLD + heroi.getNome() + " FOI DERROTADO! GAME OVER." + ConsoleColors.RESET);
                break; // Sai do loop
            }
        }

    }

    public void saidaSala(Heroi heroi){

        System.out.println(ConsoleColors.CYAN_BOLD + "              ****************************************************" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "              *    " + ConsoleColors.GREEN_BOLD + "Você está pronto para continuar sua jornada!" + ConsoleColors.CYAN_BOLD + "       *" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "              ****************************************************" + ConsoleColors.RESET);
        System.out.println();
    }


    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    private void pausas() {
        System.out.println("Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}

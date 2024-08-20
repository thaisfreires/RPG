import Entidades.*;
import Itens.Arma;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Arma espada = new Arma("Espada",50,100,120);
        Arma flecha = new Arma("Flecha",30,70,90);
        Arma canhao= new Arma("Canhão",100,150,200);


        Arqueiro arqueiro = new Arqueiro("Fulano",200,100,1,100, flecha);
        Feiticeiro feiticeiro = new Feiticeiro("Neném",350,200,2,300, espada);
        Cavaleiro cavaleiro = new Cavaleiro("Ciclano", 500,400,3,500, canhao);


        NPC dragao = new NPC("DRAGÃO DROGOS",100,100,90);
        NPC soldado = new NPC("SOLDADO RYAN",150,150,90);
        NPC urso = new NPC("THE BEAR",200,200,100);

        //Pocao vida25=new Pocao()

        //Vendedor vendedor = new Vendedor();
        //vendedor.imprimirLoja();

/**
        dragao.mostrarDetalhes();
        cavaleiro.mostrarDetalhes();
        cavaleiro.atacar(dragao);
        dragao.mostrarDetalhes();
        cavaleiro.detalhesHeroi();


        arqueiro.detalhesHeroi();
        soldado.mostrarDetalhes();
        arqueiro.atacar(soldado);
        arqueiro.mostrarDetalhes();
        soldado.mostrarDetalhes();

**/
        cavaleiro.detalhesHeroi();
        cavaleiro.usarPocao();
        cavaleiro.detalhesHeroi();


    }
}

import acoes.Efeito;
import personagens.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static ArrayList<Personagem> personagens = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static Personagem personagem;

    public static void main(String[] args) {
        iniciarPersonagens();

        boolean flag = true;

        System.out.println("Bem vindo à nossa campanha de RPG!!!");

        System.out.println("Escolha seu personagem e inicie a sua aventura");
        personagens.forEach( p -> {
            System.out.println(personagens.indexOf(p)+1 + " - " + p.getNome());
        });

        do {
            System.out.print("Qual será sua opção: ");
            int opc = sc.nextInt();
            try {
                personagem = personagens.get(opc-1);
                System.out.println("Você selecionou o: " +  personagem.getNome());
                flag = false;
            } catch (IndexOutOfBoundsException err){
                System.out.println("Verifique a opção selecionada!");
            }
        } while (flag);
    }

    public static void iniciarPersonagens(){
        Bardo bardo = new Bardo(110, "Bardo", 10, 0, 20, 1, 10, Efeito.NENHUM);
        Guerreiro guerreiro = new Guerreiro(125, "Guerreiro", 5, 0, 20, 1, 15, Efeito.NENHUM);
        Barbaro barbaro = new Barbaro(140, "Barbaro", 5, 0, 20, 1, 18, Efeito.NENHUM);
        Mago mago = new Mago(100, "Mago", 5, 0, 20, 1, 12, Efeito.NENHUM);
        Ladino ladino = new Ladino(110, "Ladino", 5, 0, 20, 1, 14, Efeito.NENHUM);

        personagens.addAll(Arrays.asList(bardo, guerreiro, barbaro, mago, ladino));
    }
}
import entidades.*;

import java.util.*;

public class Main {

    public static ArrayList<Personagem> personagens = new ArrayList<>(Arrays.asList(
            new Personagem(100, "Bardo", 10, 15),
            new Personagem(120, "Barbaro", 11, 15),
            new Personagem(90, "Mago", 14, 15),
            new Personagem(110, "Guerreiro", 12, 15)
    ));
    public static ArrayList<Inimigo> inimigos = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static Personagem personagem;

    public static void main(String[] args) {
        boolean flag = true;

        System.out.println("Bem vindo à nossa campanha de RPG!!!");
        System.out.println("Escolha seu personagem e inicie a sua aventura");

        personagens.forEach( p -> {
            System.out.println("\nPersonagem " + (personagens.indexOf(p)+1) + ": ");
            p.mostrarAtributos();
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
            } catch (InputMismatchException err){
                System.out.println("Digita um numero aí meu!");
            }
        } while (flag);

        if (personagem != null) iniciarRaid();
    }

    public static void gerarInimigos(int levelPersonagem){
        for (int i = 0; i < getRandom(1, 5); i++){
            int n = getRandom(1, 5);
            Inimigo inimigo;
            if (n == 1) inimigo = new Inimigo("Lobo", 50 * (levelPersonagem+1)*1.5, 3 + (levelPersonagem-1)*2,levelPersonagem*1.5);
            else if (n == 2) inimigo = new Inimigo("Goblin", 55 * (levelPersonagem+1)*1.5, 3 + (levelPersonagem-1)*2,levelPersonagem*1.7);
            else if (n == 3) inimigo = new Inimigo("Troll", 60 * (levelPersonagem+1)*1.5, 3 + (levelPersonagem-1)*2,levelPersonagem*1.9);
            else if (n == 4) inimigo = new Inimigo("Zumbi", 55 * (levelPersonagem+1)*1.5, 3 + (levelPersonagem-1)*2,levelPersonagem*2.1);
            else if (n == 5) inimigo = new Inimigo("Urso", 55 * (levelPersonagem+1)*1.5, 3 + (levelPersonagem-1)*2,levelPersonagem*2.3);
            else throw new NoSuchElementException("Ocorreu um erro ao criar um inimigo!");
            inimigos.add(inimigo);
        }
    }

    public static void iniciarRodada(){
        gerarInimigos(personagem.getLevel());
//        inimigos.forEach(System.out::println);
        int turno = 1;
        while (inimigos.size() > 0 && personagem.getHp() > 0){
            System.out.println("Turno: " + turno);
            System.out.println("Sua vez de atacar!");

            imprimirInimigos();

            System.out.println("Seus ataques:");
            personagem.mostrarAtaques();

            System.out.print("Qual inimigo deseja atacar: ");
            int opc = sc.nextInt();

            Inimigo inimigoTurno = inimigos.get(opc-1);
            int danoAtaque = personagem.getDanoBase();
            inimigoTurno.tomarDano(danoAtaque);
            System.out.printf("Você desferiu uma quantidade de %d de dano!!!", danoAtaque);

            if (inimigoTurno.getHp() <= 0){
                inimigos.remove(inimigoTurno);
                System.out.println("Inimigo morto!");
                personagem.addXp(inimigoTurno.getXpDrop());
            }

            System.out.println("Vez dos inimigos!");
            for (Inimigo inimigo : inimigos){
                personagem.tomarDano(inimigo.desferirDano());
                System.out.println("O inimigo " + inimigo.getNome() +
                        " desferiu a você uma quantidade de " + inimigo.getDano() +
                        " de dano, lhe resta " + personagem.getHp() + " pontos de vida");
            }
            turno ++;
        }
    }

    public static void imprimirInimigos(){
        for (Inimigo inimigo : inimigos){
            System.out.println("Inimigo numero " + (inimigos.indexOf(inimigo)+1));
            System.out.println("Nome: " + inimigo.getNome());
            System.out.println("Vida: " + inimigo.getHp());
            System.out.println("Dano: " + inimigo.getDano() + "\n");
        }
    }

    public static void iniciarRaid(){
        for (int i = 1; i <= 3; i++){
            System.out.println("Rodada: " + i);
            iniciarRodada();
        }
        personagem.setHp(personagem.getHpBase());
        System.out.println("Um boss apareceu!!!");
    }

    public static int getRandom(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

//    public static void abrirBau(){
//        int n = (int)Math.floor(Math.random()*(5-1+1)+1);
//        System.out.println("Você encontrou um baú no caminho para próxima raid!!");
//
//
//
//        char opc = sc.next().charAt(0);
//    }

}
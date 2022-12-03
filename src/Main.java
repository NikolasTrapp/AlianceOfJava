import ataques.ListaAtaques;
import entidades.*;
import equipamentos.Equipamento;

import java.util.*;

public class Main {

    //Lista de personagens pré cadastrados
    public static ArrayList<Personagem> personagens = new ArrayList<>(Arrays.asList(
            new Personagem(120, "Monge", 10, 5),
            new Personagem(115, "Ladino", 13, 5),
            new Personagem(130, "Guerreiro", 12, 5),
            new Personagem(140, "Barbaro", 50, 5),
            new Personagem(105, "Mago", 8, 6),
            new Personagem(105, "Clérigo", 7, 5),
            new Personagem(110, "Bardo", 9, 5)
    ));
    public static ArrayList<Chefao> chefoes = new ArrayList<>(Arrays.asList(
            new Chefao(250, "Golem", 15, 20),
            new Chefao(175, "Rei troll", 17, 30),
            new Chefao(150, "Dragão", 20, 40)
    ));
    public static int estagio = 0;

    //Lista de inimigos que será gerada ao decorrer do jogo
    public static ArrayList<Inimigo> inimigos = new ArrayList<>();
    //Personagem selecionado
    public static Personagem personagem;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Iniciando o jogo
        System.out.println("Bem vindo à nossa campanha de RPG!!!");
        System.out.println("Escolha seu personagem e inicie a sua aventura");

        //Listando os personagens cadastrados
        personagens.forEach( p -> {
            System.out.println("\nPersonagem " + (personagens.indexOf(p)+1) + ": ");
            p.mostrarAtributos();
        });

        //Mandando usuário selecionar o personagem
        personagem = (Personagem) escolherCriatura(personagens);
        //Garantindo que haverá um personagem, caso haja, iniciar as 3 rodadas
        if (personagem != null) iniciarRaid();

        System.out.println("Acabou, obrigado por jogar!");
    }

    public static void gerarInimigos(int levelPersonagem){
        /**
         * Esta função cria os inimigos e adiciona-os na lista principal de inimigos.
         *
         * @param levelPersonagem O level atual do personagem.
         */
        for (int i = 0; i < 4; i++){
            int n = getRandom(1, 5);
            if (n == 1) inimigos.add(new Inimigo("Lobo", 50 * (levelPersonagem+1)*0.5, 3 + (levelPersonagem-1)*2,levelPersonagem*3));
            else if (n == 2) inimigos.add(new Inimigo("Goblin", 55 * (levelPersonagem+1)*0.5, 3 + (levelPersonagem-1)*2,levelPersonagem*3));
            else if (n == 3) inimigos.add(new Inimigo("Troll", 60 * (levelPersonagem+1)*0.5, 3 + (levelPersonagem-1)*2,levelPersonagem*3));
            else if (n == 4) inimigos.add(new Inimigo("Zumbi", 65 * (levelPersonagem+1)*0.5, 3 + (levelPersonagem-1)*2,levelPersonagem*3));
            else if (n == 5) inimigos.add(new Inimigo("Urso", 70 * (levelPersonagem+1)*0.5, 3 + (levelPersonagem-1)*2,levelPersonagem*3));
            else throw new NoSuchElementException("Ocorreu um erro ao criar um inimigo!");
        }
    }

    public static boolean iniciarRodada(){
        /**
         * Esta função controla uma unica onda de inimigos, ela gera os inimigos a
         * partir do nivel de xp do personagem, e logo em seguida ela controla o combate
         * pedindo ao usuário o ataque que ele deseja desferir e fazendo os inimigos
         * atacarem ele, além de verificar se todos os inimigos possuem algum efeito.
         */
        gerarInimigos(personagem.getLevel()); //Gerar inimigos
        int turno = 1; //Numero do turno atual
        while (inimigos.size() > 0 && personagem.getHp() > 0){
            System.out.println("Turno: " + turno);
            System.out.println("Sua vez de atacar!");

            //Imprimindo os inimigos na tela
            inimigos.forEach(inimigo -> inimigo.imprimirInimigo(inimigos.indexOf(inimigo)+1));

            System.out.print("Qual inimigo deseja atacar: ");
            //Chamando a função de escolha de inimigo
            Inimigo inimigoTurno = (Inimigo) escolherCriatura(inimigos);

            //Chamando a função de ataque do personagem e desferindo o dano retornado ao inimigo
            int danoAtaque = personagem.atacar(inimigoTurno);
            inimigoTurno.tomarDano(danoAtaque);

            System.out.printf("Você desferiu uma quantidade de %d de dano ao %s!!!%n", danoAtaque, inimigoTurno.getNome());
            matarInimigo(inimigoTurno); //Verificar se o inimigo morreu

            //Turno dos inimigos
            System.out.println("Vez dos inimigos!");
            for (Inimigo inimigo : inimigos){
                verificarSeInimigoMorreu(inimigo); //Verificar se o inimigo possui um efeito e se vai morrer
                //Atacar o personagem
                int dano = personagem.tomarDano(inimigo.atacar(personagem));
                System.out.println("O inimigo " + inimigo.getNome() +
                        " desferiu a você uma quantidade de " + dano +
                        " de dano, lhe resta " + personagem.getHp() + " pontos de vida");
            }
            turno ++;
            if (personagem.getHp() <= 0) return true;
        }
        return false;
    }

    public static Criatura escolherCriatura(ArrayList<? extends Criatura> lista){
        /**
         * Esta função tem o papel de permitir o usuário escolher uma criatura, sendo
         * que esta pode ser um inimigo ou o seu personagem, ela trata as exceções como
         * IndexOutOfBoundsException (Caso o usuário escolha algo que não existe)
         * e InputMismatchException (Caso o usuário digite uma letra).
         *
         * @param lista A lista de criaturas que o sistema deseja fazer uma escolha.
         *
         * @return A criatura escolhida.
         */
        boolean flag = true;
        do {
            try{
                System.out.print("Qual será sua opção: ");
                int opc = sc.nextInt()-1; //Pegando a opção -1
                Criatura criatura = lista.get(opc); //Pegando a criatura
                System.out.println("Você selecionou o: " +  criatura.getNome());
                flag = false; //Encerrando o loop
                return criatura; //Retornando a criatura
            } catch (IndexOutOfBoundsException err){
                System.out.println("Verifique a opção selecionada!");
            } catch (InputMismatchException err){
                System.out.println("Digita um numero aí meu!");
                sc.next(); //Consumir o log de erro
            }
        } while(flag);
        return null;
    }

    public static void verificarSeInimigoMorreu(Inimigo inimigo){
        /**
         * Esta função tem o papel de verificar se o inimigo vai morrer
         * para o seu efeito (Caso ele possua algum).
         *
         * @param inimimo O inimigo para verificar se vai morrer para o efeito.
         */
        inimigo.tomarDano(inimigo.validarDanoEfeito());
        matarInimigo(inimigo);
    }

    public static void matarInimigo(Inimigo inimigo){
        /**
         * Esta função tem o papel de verificar se o inimigo morreu.
         *
         * @param inimigo O inimigo para verificar se está morto.
         */
        if (inimigo.getHp() <= 0){
            inimigos.remove(inimigo);
            System.out.println("Inimigo morto!");
            personagem.addXp(inimigo.getXpDrop());
        }
    }

    public static void iniciarRaid(){
        /**
         * Esta função controla as partes da caminhada, cada caminhada possui 3 ondas
         * de inimigos e ao fim de cada há um BOSS e um baú, além de que o personagem
         * cura sua vida.
         */
        for (int i = 1; i <= 1; i++){
            System.out.println("Rodada: " + i);
            if (iniciarRodada()) {
                System.out.println("Você morreu!");
                return;
            }
        }
        System.out.println(personagem);
        personagem.setHp(personagem.getHpBase());
        System.out.println("Sua vida foi restaurada!");
        abrirBau();
        System.out.println("Um boss apareceu!!!");
        batalharComBoss();
    }

    public static void batalharComBoss(){
        Chefao chefao = chefoes.get(estagio);
        int turno = 1;
        while (chefao.getHp() > 0 && personagem.getHp() > 0){
            System.out.println("Turno: " + turno);
            System.out.println("Sua vez de atacar!");

            int danoAtaque = personagem.atacar(chefao);
            chefao.tomarDano(danoAtaque);

            System.out.printf("Você desferiu uma quantidade de %d de dano ao %s!!!%n", danoAtaque, chefao.getNome());

            if (chefao.getHp() <= 0){
                inimigos.remove(chefao);
                System.out.println("Chefão morto!");
                personagem.addXp(chefao.getXpDrop());
                break;
            }
            int dano = personagem.tomarDano(chefao.atacar(personagem));

            System.out.println("O inimigo " + chefao.getNome() +
                    " desferiu a você uma quantidade de " + dano +
                    " de dano, lhe resta " + personagem.getHp() + " pontos de vida");
            turno++;
        }
        estagio++;
    }

    public static int getRandom(int min, int max){
        /**
         * Esta função retorna um nímero aleatório com base no numero minimo
         * e no numero máximo informados.
         *
         * @param min Numero minimo.
         * @param max Numero máximo.
         *
         * @return O numero sorteado.
         */

        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public static void abrirBau(){
        System.out.println("Você encontrou um baú no caminho para próxima raid!!");
        Equipamento equipamento = ListaAtaques.pegarEquipamento(getRandom(1, 100));
        System.out.println("Você ganhou um(a): " + equipamento.getNome() + "\n Veja seus atributos:");
        equipamento.imprimirAtributos();

        if (personagem.getEquipamento() == null){
            personagem.setEquipamento(equipamento);
            System.out.println("Você equipou um(a): " + equipamento.getNome());
        } else {
            System.out.println("Você deseja substituir o seu " + personagem.getEquipamento().getNome() +
                    " por um " + equipamento.getNome() + "? s - Sim, n - Não");
            char resposta = sc.next().charAt(0);
            if (resposta == 's' || resposta == 'S') {
                personagem.setEquipamento(equipamento);
                System.out.println("Você equipou um(a): " + equipamento.getNome());
            }
            else System.out.println("Ok, fica pra próxima");
        }
    }

}
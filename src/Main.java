import entidades.*;
import equipamentos.Equipamento;
import ataques.ListaAtaques;

import java.util.*;

public class Main {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	
    //Lista de personagens pré cadastrados
    public static ArrayList<Personagem> personagens = new ArrayList<>(Arrays.asList(
            new Personagem(100, "Bardo", 10, 15),
            new Personagem(120, "Barbaro", 11, 15),
            new Personagem(90, "Mago", 14, 15),
            new Personagem(110, "Guerreiro", 12, 15)
    ));
    //Lista de inimigos que será gerada ao decorrer do jogo
    public static ArrayList<Inimigo> inimigos = new ArrayList<>();
    //Personagem selecionado
    public static Personagem personagem = new Personagem(120, "Barbaro", 11, 15);
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Iniciando o jogo
    	
    	abrirBau();
        System.out.println(ANSI_PURPLE+"Bem vindo à nossa campanha de RPG!!!");
        System.out.println("Escolha seu personagem e inicie a sua aventura"+ANSI_RESET);

        //Listando os personagens cadastrados
        personagens.forEach( p -> {
            System.out.println("\nPersonagem " + (personagens.indexOf(p)+1) + ": ");
            p.mostrarAtributos();
        });

        //Mandando usuário selecionar o personagem
        personagem = (Personagem) escolherCriatura(personagens);
        //Garantindo que haverá um personagem, caso haja, iniciar as 3 rodadas
        if (personagem != null) iniciarRaid();
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

    public static void iniciarRodada(){
        /**
         * Esta função controla uma unica onda de inimigos, ela gera os inimigos a
         * partir do nivel de xp do personagem, e logo em seguida ela controla o combate
         * pedindo ao usuário o ataque que ele deseja desferir e fazendo os inimigos
         * atacarem ele, além de verificar se todos os inimigos possuem algum efeito.
         */
        gerarInimigos(personagem.getLevel()); //Gerar inimigos
        int turno = 1; //Numero do turno atual
        while (inimigos.size() > 0 && personagem.getHp() > 0){
            System.out.println(ANSI_PURPLE+"Turno: " + turno+ANSI_RESET);
            System.out.println(ANSI_GREEN+"Sua vez de atacar!"+ANSI_RESET);

            //Imprimindo os inimigos na tela
            inimigos.forEach(inimigo -> inimigo.imprimirInimigo(inimigos.indexOf(inimigo)+1));

            System.out.print(ANSI_YELLOW+"Qual inimigo deseja atacar: "+ANSI_RESET);
            //Chamando a função de escolha de inimigo
            Inimigo inimigoTurno = (Inimigo) escolherCriatura(inimigos);

            //Chamando a função de ataque do personagem e desferindo o dano retornado ao inimigo
            int danoAtaque = personagem.atacar(inimigoTurno);
            inimigoTurno.tomarDano(danoAtaque);

            System.out.printf(ANSI_YELLOW+"Você desferiu uma quantidade de %d de dano ao %s!!!%n", danoAtaque, inimigoTurno.getNome()+ANSI_RESET);
            matarInimigo(inimigoTurno); //Verificar se o inimigo morreu

            //Turno dos inimigos
            System.out.println(ANSI_RED +"Vez dos inimigos!"+ANSI_RESET);
            for (Inimigo inimigo : inimigos){
                verificarSeInimigoMorreu(inimigo); //Verificar se o inimigo possui um efeito e se vai morrer
                //Atacar o personagem
                int dano = personagem.tomarDano(inimigo.atacar(personagem));
                System.out.println(ANSI_RED + "O inimigo " + inimigo.getNome() +
                        " desferiu a você uma quantidade de " + dano +
                        " de dano, lhe resta " + personagem.getHp() + " pontos de vida"+ANSI_RESET);
            }
            turno ++;
        }
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
                System.out.print(ANSI_GREEN+"Qual será sua opção: "+ANSI_RESET);
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
        for (int i = 1; i <= 3; i++){
            System.out.println("Rodada: " + i);
            iniciarRodada();
        }
        personagem.setHp(personagem.getHpBase());
        System.out.println("Um boss apareceu!!!");
        abrirBau();
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
        int n = getRandom(1, 100);
        System.out.println("Você encontrou um baú no caminho para próxima raid!!");
        Equipamento eq = pegarEquipamento(n);
        System.out.println(eq);
        System.out.println("Você ganhou o equipamento " + eq.getNome() + " você deseja equipa-lo?");
        System.out.println("Digite s = Sim ou n = Não");
        char opc = sc.next().charAt(0);
        System.out.println(opc);
        if(opc == 's' || opc == 'S') {
        	personagem.setEquipamento(eq);
        } else {
        	System.out.println("Você não equipou com " + eq.getNome());
        }
        System.out.println(personagem.getEquipamento());
    }
    
    public static Equipamento pegarEquipamento(int n) {
    	
    	for (int i = 0; i < ListaAtaques.equipamentos.size(); i++) {
			Equipamento eq = ListaAtaques.equipamentos.get(i);
			
    		if(eq.validarChance(n)) {
				return eq;
			}
		}
    	return null;
    }

}
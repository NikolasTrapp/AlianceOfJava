package entidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

import ataques.Ataque;
import ataques.AtaqueBasico;
import ataques.AtaqueEspecial;
import ataques.ListaAtaques;
import ataques.TipoEfeito;
import equipamentos.Equipamento;
import equipamentos.Tipo;

public class Personagem extends Criatura {

	private int mp;
	private double xp = 9;
	private int xpBar = 10;
	private int level = 1;
	private int mpBase;

	private Equipamento equipamento;
	private ArrayList<AtaqueBasico> ataquesBasicos = new ArrayList<>();
	private ArrayList<AtaqueEspecial> ataqueEspecial = new ArrayList<>();

	private Scanner sc = new Scanner(System.in);

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";

	public Personagem(double hpBase, String nome, int danoBase, int mp) {
		super(hpBase, nome, danoBase);
		this.mp = mp;
		this.mpBase = mp;
		carregarAtaques();
	}

	public void mostrarAtaques() {
		/**
		 * Esta função mostra os ataques que o personagem possui.
		 */
		System.out.println();
		System.out.println(ANSI_PURPLE + "Ataques Básicos:" + ANSI_RESET);
		imprimirAtaques(ataquesBasicos);
		System.out.println();
		System.out.println(ANSI_YELLOW + "Ataques Especiais:" + ANSI_RESET);
		imprimirAtaques(ataqueEspecial);
	}

	private void imprimirAtaques(ArrayList<? extends Ataque> ataques) {
		/**
		 * Esta função imprime os ataques básicos ou avançados que o personagem possui.
		 *
		 * @param ataques Lista de ataques do personagem.
		 */
		ataques.forEach(atk -> {
			System.out
					.println("Ataque " + "\"" + atk.getNome() + "\"" + ", numero: " + (ataques.indexOf(atk) + 1) + ":");
			atk.mostrarAtributos();
		});
	}

	public void mostrarAtributos() {
		/**
		 * Esta função mostra os atributos do personagem
		 */
		System.out.println(ANSI_PURPLE + "----------ATRIBUTOS----------" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Nome: " + getNome());
		System.out.println("HP: " + getHpBase());
		System.out.println("Dano: " + getDanoBase());
		System.out.println("MP: " + getMp() + ANSI_RESET);
		System.out.println(ANSI_BLUE + "\n-----------ATAQUES-----------" + ANSI_RESET);
		mostrarAtaques();
	}

	public void addXp(double xp) {
		/**
		 * Esta função faz a lógica de adicionar xp ao personagem, aumentando o seu
		 * nivel caso atinja a quantidade necessária da xp bar e em seguida carrega
		 * novos ataques caso haja algum.
		 *
		 * @param xp A quantidade de xp para ser adicionada.
		 */
		System.out.println(ANSI_GREEN + "\n☆☆☆ Você ganhou " + xp + " de XP!!! ☆☆☆" + ANSI_RESET);

		if (getXp() + xp >= getXpBar()) {
			setXp((getXp() + xp) % getXpBar());
			this.level++;
			setHp(getHpBase());
			System.out.println(
					ANSI_YELLOW + "\n☆☆☆☆ Parabéns, Você subiu de nivel e recuperou sua Vida!!! ☆☆☆☆" + ANSI_RESET);
			setXpBar(getXpBar() + 10);
			for (AtaqueEspecial ataque : ataqueEspecial) {
				ataque.uparSkill();
			}
			for (AtaqueBasico ataque : ataquesBasicos) {
				ataque.uparSkill();
			}
			trocarAtaque();
			setMp(getMpBase());
		} else {
			this.xp += xp;
		}
		System.out.println("\nAinda te restam " + (getXpBar() - getXp()) + " para subir ao nível " + (getLevel() + 1));
	}

	@Override
	public int tomarDano(int dano) {
		/**
		 * Esta função faz a parte da lógica do personagem tomar dano, ela verifica se o
		 * personagem não possui nenhum efeito de ATAQUE ou se ele tem algum equipamento
		 * que o proteja de danos, em seguida retorna o dano a causado.
		 *
		 * @param dano O dano a ser causado ao personagem.
		 *
		 * @return O dano causado ao personagem.
		 */
		if (!getEfeito().equals(ListaAtaques.pegarEfeito("Nenhum"))
				&& getEfeito().getTipoEfeito() != TipoEfeito.STATUS) {
			int danoEfeito = validarDanoEfeito();
			System.out.println(
					getNome() + " sofreu " + danoEfeito + " pontos de dano do efeito " + getEfeito().getNome());
			dano += danoEfeito;
			getEfeito().addTurno();
		}
		dano -= verificarEquipamento(Tipo.DEFESA);
		setHp(getHp() - dano + verificarEquipamento(Tipo.CURA));
		return dano;
	}

	@Override
	public int atacar(Criatura inimigo) {
		/**
		 * Esta função se responsabiliza pela função de atacar algum inimigo/boss, ela
		 * faz as verificações se o personagem possui efeitos de BUFF, DEBUFF ou status,
		 * ou algum equipamento que aumente seu dano e retorna o dano que ele irá
		 * causar. Também aplica um efeito ao inimigo caso o ataque selecionado tenha
		 * algum.
		 *
		 * @param inimigo O inimigo a ser atacado e aplicado um possivel efeito.
		 *
		 * @return O dano total do ataque desferido.
		 */
		Ataque ataque = escolherAtaque();
		if (ataque == null)
			return 0;
		int dano = getDanoBase();
		dano += ataque.calcularDanoAtaque();
		dano += verificarEfeitoBuffDebuff();
		dano += verificarEquipamento(Tipo.ATAQUE);
		inimigo.passarEfeito(ataque);
		return dano;
	}

	private int verificarEquipamento(Tipo tipo) {
		/**
		 * Esta função verifica se o usuário possui algum equipamento com base no efeito
		 * que ele deseja obter, caso tenha ele verifica se o equipamento possui usos
		 * sobressalentes e retorna o numero da proteção ou dano extra.
		 *
		 * @param tipo O tipo do equipamento que se deseja verificar.
		 *
		 * @return O numero de dano ou proteção aplicada.
		 */
		if (equipamento == null)
			return 0;
		if (equipamento.getUsos() <= 0) {
			setEquipamento(null);
			return 0;
		}
		if (equipamento.getTipo() == tipo) {
			return equipamento.usar();
		}
		return 0;
	}

	public void carregarAtaques() {
		/**
		 * Esta função carrega os ataques que são pertencentes a este personagem.
		 */
		this.ataquesBasicos = ListaAtaques.ataquesBasicos.stream()
				.filter(ataque -> ataque.verificarPertencePersonagem(getNome(), getLevel())
						&& getLevel() <= ataque.getNivelMinimo())
				.collect(Collectors.toCollection(ArrayList::new));
		this.ataqueEspecial = ListaAtaques.ataquesEspecial.stream()
				.filter(ataque -> ataque.verificarPertencePersonagem(getNome(), getLevel())
						&& getLevel() <= ataque.getNivelMinimo())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public Ataque escolherAtaque() {
		/**
		 * Esta função permite ao personagem escolher qual ataque ele irá desferir
		 * fazendo os de tipo de aatque e custo de mp.
		 *
		 * @return O ataque escolhido
		 */
		boolean flag = true;
		if (verificarEfeitoStatus())
			return null;
		System.out.println("Seus ataques:");
//        mostrarAtaques();
		while (flag) {
			try {
				System.out.println(ANSI_CYAN + "Qual tipo de ataque você gostaria de usar? Basico (b) ou Especial (e):"
						+ ANSI_RESET);
				char opc = sc.next().charAt(0);
				System.out.println(ANSI_CYAN + "Qual o numero do ataque que gostarias de usar:" + ANSI_RESET);
				int ataque = sc.nextInt() - 1;

				if (opc == 'b' || opc == 'B') {
					flag = false;
					return ataquesBasicos.get(ataque);
				} else if (opc == 'e' || opc == 'E') {
					AtaqueEspecial ataqueEs = ataqueEspecial.get(ataque);
					if (ataqueEs.getCustoMP() <= getMp()) {
						reduzirMp(ataqueEs.getCustoMP());
						flag = false;
						return ataqueEs;
					} else {
						System.out.println(
								"Você não possui pontos de MP suficientes para utilizar este ataque! seus pontos: "
										+ getMp());
					}
				} else {
					System.out.println(ANSI_RED + "Verifique a opção informada!" + ANSI_RESET);
				}
			} catch (IndexOutOfBoundsException err) {
				System.out.println(ANSI_RED + "Verifique a opção selecionada!" + ANSI_RESET);
			} catch (InputMismatchException err) {
				System.out.println("Digita um numero aí meu!");
			}
		}
		return null;
	}

	private void trocarAtaque() {
		/**
		 * Esta é uma função privada que só o personagem tem que faz o sistema de troca
		 * de ataques, caso o mesmo deseje trocar algum ataque que veio.
		 */
		// Vai ser chamada quando o personagem upar de nivel
		AtaqueBasico novoAtaqueBasico = (AtaqueBasico) checharNivelAtaque(ListaAtaques.ataquesBasicos);
		AtaqueEspecial novoAtaqueEspecial = (AtaqueEspecial) checharNivelAtaque(ListaAtaques.ataquesEspecial);

		if (novoAtaqueBasico != null) {
			if (getNumeroAtaques() < 4) {
				ataquesBasicos.add(novoAtaqueBasico);
			} else {
				System.out.println("Você ganhou o ataque " + novoAtaqueBasico.getNome());
				System.out.println("Você deseja troca-lo? (s ou n)");
				char opcao = sc.next().charAt(0);
				if (opcao == 's' || opcao == 'S') {
					imprimirAtaques(ataquesBasicos);
					System.out.println("Qual ataque você deseja abandonar?");
					int numero = sc.nextInt();
					ataquesBasicos.remove(numero - 1);
					ataquesBasicos.add(novoAtaqueBasico);
				}
			}

		}

		if (novoAtaqueEspecial != null) {
			if (getNumeroAtaques() < 4) {
				ataqueEspecial.add(novoAtaqueEspecial);
			} else {
				System.out.println("Você ganhou o ataque " + novoAtaqueEspecial.getNome());
				System.out.println("Você deseja troca-lo? (s ou n)");
				char opcao = sc.next().charAt(0);
				if (opcao == 's' || opcao == 'S') {
					imprimirAtaques(ataqueEspecial);
					System.out.println("Qual ataque você deseja abandonar?");
					int numero = sc.nextInt();
					ataqueEspecial.remove(numero - 1);
					ataqueEspecial.add(novoAtaqueEspecial);
				}
			}

		}

	}

	private Ataque checharNivelAtaque(ArrayList<? extends Ataque> ataques) {
		/**
		 * Esta é uma função privada auxiliar que verifica se algum ataque da lista de
		 * ataques possui o nivel minimo equivalente ao nivel do personagem, e se algum
		 * ataque da lista corresponder à condição o mesmo será retornado
		 * 
		 * @param ataques A lista de ataques que será percorrida
		 * 
		 * @return O ataque que corresponde ao nivel do personagem ou nada.
		 */
		for (Ataque ataque : ataques) {
			if (ataque.verificarPertencePersonagem(getNome(), getLevel()))
				return ataque;
		}
		return null;
	}

	@Override
	public String toString() {
		return "mp=" + mp + ", efeito=" + getEfeito() + ", xp=" + xp + ", xpBar=" + xpBar + ", level=" + level
				+ ", equipamento=" + equipamento;
	}

	// GETTERS E SETTERS
	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public void reduzirMp(int mp) {
		setMp(getMp() - mp);
	}

	private void setXp(double xp) {
		this.xp = xp;
	}

	public double getXp() {
		return xp;
	}

	public int getXpBar() {
		return xpBar;
	}

	public void setXpBar(int xpBar) {
		this.xpBar = xpBar;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	private int getNumeroAtaques() {
		return ataquesBasicos.size() + ataqueEspecial.size();
	}

	public int getMpBase() {
		return mpBase;
	}

	public void setMpBase(int mpBase) {
		this.mpBase = mpBase;
	}

}
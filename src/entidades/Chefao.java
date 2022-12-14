package entidades;

import java.util.ArrayList;
import java.util.stream.Collectors;

import ataques.Ataque;
import ataques.ListaAtaques;
import ataques.TipoEfeito;

public class Chefao extends Criatura {

	private double xpDrop;

	private ArrayList<Ataque> ataques = new ArrayList<>();

	public Chefao(double hpBase, String nome, int danoBase, double xpDrop) {
		super(hpBase, nome, danoBase);
		this.xpDrop = xpDrop;
		carregarAtaques();
	}

	@Override
	public int tomarDano(int dano) {
		aplicarImunidade();
		setHp(getHp() - dano);
		return dano;
	}

	private void aplicarImunidade() {
		// getEfeito().getTipoEfeito() == TipoEfeito.STATUS &&
		// getNome().equalsIgnoreCase("...")
		if (getEfeito().getTipoEfeito() == TipoEfeito.STATUS) {
			System.out.println("O efeito " + getEfeito().getNome() + " foi removido devido a imunidade do boss");
			setEfeito(ListaAtaques.efeitos.get(0));
		}
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
		System.out.println("O " + getNome() + " usou o ataque " + ataque.getNome());
		int dano = ataque.calcularDanoAtaque();
		dano += verificarEfeitoBuffDebuff();
		inimigo.passarEfeito(ataque);
		return dano;
	}

	private Ataque escolherAtaque() {
		/**
		 * Função que escolhe um ataque aleatório para o chefão e o retorna
		 * 
		 * @return O ataque escolhido aleatóriamente.
		 */
		int n = (int) Math.floor(Math.random() * 4);
		return ataques.get(n);
	}

	public void imprimirBoss() {
		/**
		 * Função que imprime os atributos do boss
		 */
		System.out.println("Nome: " + getNome());
		System.out.println("Vida: " + getHp());
		ataques.forEach(System.out::println);
	}

	private void carregarAtaques() {
		/**
		 * Função privada que carrega os ataques correspondetes a este boss especifico
		 */
		this.ataques = ListaAtaques.ataquesBoss.stream().filter(ataque -> ataque.verificarPertenceChefao(getNome()))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public boolean roubarEquipamento(int n) {
		/**
		 * Função que rouba um equipamento do personagem
		 * 
		 * @param n O numero aleatório que corresponde a chance de roubar o equipamento
		 * 
		 * @return true se conseguir roubar e false se não conseguir
		 */
		// 5% de chance de roubar o equipamento
		return n < 5 && getNome().equalsIgnoreCase("Rei troll");
	}

	public ArrayList<Ataque> getAtaques() {
		return ataques;
	}

	public void setAtaques(ArrayList<Ataque> ataques) {
		this.ataques = ataques;
	}

	public double getXpDrop() {
		return xpDrop;
	}

	public void setXpDrop(double dropXp) {
		this.xpDrop = dropXp;
	}
}
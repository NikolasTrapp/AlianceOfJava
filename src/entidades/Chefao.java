package entidades;

import java.util.ArrayList;
import java.util.stream.Collectors;

import ataques.Ataque;
import ataques.ListaAtaques;

public class Chefao extends Criatura{

    private double xpDrop;

    private ArrayList<Ataque> ataques = new ArrayList<>();


    public Chefao(double hpBase, String nome, int danoBase, double xpDrop) {
        super(hpBase, nome, danoBase);
        this.xpDrop = xpDrop;
        carregarAtaques();
    }

    @Override
    public int tomarDano(int dano) {
        setHp(getHp()-dano);
        return dano;
    }

    @Override
    public int atacar(Criatura inimigo) {
        /**
         * Esta função se responsabiliza pela função de atacar algum inimigo/boss,
         * ela faz as verificações se o personagem possui efeitos de BUFF, DEBUFF
         * ou status, ou algum equipamento que aumente seu dano e retorna o dano
         * que ele irá causar. Também aplica um efeito ao inimigo caso o ataque
         * selecionado tenha algum.
         *
         * @param inimigo O inimigo a ser atacado e aplicado um possivel efeito.
         *
         * @return O dano total do ataque desferido.
         */
        Ataque ataque = escolherAtaque();
        if (ataque == null) return 0;
        System.out.println("O " + getNome() + " usou o ataque " + ataque.getNome());
        int dano = ataque.calcularDanoAtaque();
        dano += verificarEfeitoBuffDebuff();
        inimigo.passarEfeito(ataque);
        return dano;
    }

    public Ataque escolherAtaque(){
        int n = (int)Math.floor(Math.random()*4);
        return ataques.get(n);
    }

    public void imprimirBoss(){
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getHp());
        ataques.forEach(System.out::println);
    }

    private void carregarAtaques(){
        this.ataques = ListaAtaques.ataquesBoss.stream().filter(ataque -> ataque.temNaLista(getNome())).collect(Collectors.toCollection(ArrayList::new));
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
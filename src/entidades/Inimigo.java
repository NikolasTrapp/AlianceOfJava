package entidades;

import ataques.Efeito;
import ataques.ListaAtaques;
import ataques.TipoEfeito;

public class Inimigo extends Criatura{

    private double xpDrop;

    public Inimigo(String nome, double hpBase, int danoBase, double xpDrop) {
        super(hpBase, nome, danoBase);
        this.xpDrop = xpDrop;
    }

    @Override
    public int tomarDano(int dano) {
        System.out.println(getEfeito());
        if (!getEfeito().equals(ListaAtaques.pegarEfeito("Nenhum")) && getEfeito().getTipoEfeito() != TipoEfeito.STATUS){
            int danoEfeito = validarDanoEfeito();
            System.out.println("O inimigo " + getNome() + " sofreu " + danoEfeito + " pontos de dano do efeito " + getEfeito().getNome());
            dano += danoEfeito;
            getEfeito().addTurno();
        }
        setHp(getHp()-dano);
        return dano;
    }

    @Override
    public int atacar(Criatura personagem) {
        if (verificarEfeitoStatus()) return 0;
        return getDanoBase();
    }

    public void imprimirInimigo(int n){
        System.out.println("Inimigo numero " + n + ":");
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getHp());
        System.out.println("Dano: " + getDano());
        System.out.println();

    }




    //GETTERS E SETTERS
    public double getXpDrop() {
        return xpDrop;
    }

    public void setXpDrop(double xpDrop) {
        this.xpDrop = xpDrop;
    }

    @Override
    public String toString() {
        super.toString();
        return "Inimigo{" +
                "xpDrop=" + xpDrop +
                '}';
    }
}

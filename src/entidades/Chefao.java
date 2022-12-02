package entidades;

public class Chefao extends Criatura{

    public Chefao(double hpBase, String nome, int danoBase) {
        super(hpBase, nome, danoBase);
    }

    @Override
    public int tomarDano(int dano) {
        return 0;
    }

    @Override
    public int atacar(Criatura inimigo) {
        return 0;
    }
}

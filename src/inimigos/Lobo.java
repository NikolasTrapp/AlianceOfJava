package inimigos;

public class Lobo extends Inimigo{

    public Lobo(String nome, int hp, int dano, int hpBase, int danoBase) {
        super(nome, hp, dano, hpBase, danoBase);
    }

    @Override
    public void tomarDano(int dano) {
        setHp(getHp()-dano);
    }

    @Override
    public int desferirDano() {
        return getDano();
    }
}

package inimigos;

public class Urso extends Inimigo{

    public Urso(String nome, int hp, int dano, int hpBase, int danoBase) {
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

package personagens;

// Ladino, Mago, Paladino, Barbaro, Monge

// Zumbi, Esqueleto, Urso, Globin, Troll, Ork, Lobo

// Dragão, Golem, Rei Troll


public class Guerreiro extends Personagem{



    public Guerreiro() {
        setNome("Guerreiro");
        setHpBase(125);
        setHp(getHpBase());
        setDanoBase(15);
        setMp(12);
    }


    @Override
    public void mostrarAtaques() {

    }

    @Override
    public void mostrarAtributos() {

    }

    @Override
    public void tomarDano(int dano) {
        setHp(getHp()-dano);
    }

    @Override
    public String imprimirAtributos() {
        return String.format("%nNome: %s%nHP: %d%nDano base: %d%nMP: %d%n", getNome(), getHpBase(), getDanoBase(), getMp());
    }

}

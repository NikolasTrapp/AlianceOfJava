package personagens;

public class Ladino extends Personagem{



    public Ladino() {
        setNome("Ladino");
        setHpBase(110);
        setHp(getHpBase());
        setDanoBase(14);
        setMp(10);
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



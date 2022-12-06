package entidades;

public class Inimigo extends Criatura{

    private double xpDrop;

    public Inimigo(String nome, double hpBase, int danoBase, double xpDrop) {
        super(hpBase, nome, danoBase);
        this.xpDrop = xpDrop;
    }

    @Override
    public int tomarDano(int dano) {
        setHp(getHp()-dano);
        return dano;
    }


    @Override
    public int atacar(Criatura personagem) {
        if (verificarEfeitoStatus()) return 0;
        int dano = getDano();
        dano += verificarEfeitoBuffDebuff();
        return dano;
    }

    public void imprimirInimigo(int n){
        System.out.println("Inimigo numero " + n + ":");
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getHp());
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
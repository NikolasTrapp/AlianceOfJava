package inimigos;

import personagens.Personagem;

public abstract class Inimigo {

    private String nome;
    private int hp;
    private int dano;
    private int danoBase;
    private int hpBase;

    public Inimigo(String nome, int hp, int dano, int hpBase, int danoBase) {
        this.nome = nome;
        this.hp = hp + hpBase;
        this.dano = dano + danoBase;
        this.danoBase = danoBase;
        this.hpBase = hpBase;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano+danoBase;
    }

    public abstract void tomarDano(int dano);
    public abstract int desferirDano();

    @Override
    public String toString() {
        return "Inimigo{" +
                "nome='" + nome + '\'' +
                ", hp=" + hp +
                ", dano=" + dano +
                ", danoBase=" + danoBase +
                ", hpBase=" + hpBase +
                '}';
    }
}

package entidades;

import ataques.Efeito;

public abstract class Criatura {

    private double hp;
    private double hpBase;
    private String nome;
    private int danoBase;
    private int dano;
    private Efeito efeito = Efeito.NENHUM;

    public Criatura(double hpBase, String nome, int danoBase) {
        this.hp = getHpBase();
        this.hpBase = hpBase;
        this.nome = nome;
        this.danoBase = danoBase;
        this.dano = getDanoBase();
    }

    public abstract int tomarDano(int dano);
    public abstract int desferirDano();

    @Override
    public String toString() {
        return "Criatura{" +
                "hpBase=" + hpBase +
                ", nome='" + nome + '\'' +
                ", danoBase=" + danoBase +
                '}';
    }


    // GETTERS AND SETTERS

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getHpBase() {
        return hpBase;
    }

    public void setHpBase(double hpBase) {
        this.hpBase = hpBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public void setEfeito(Efeito efeito) {
        this.efeito = efeito;
    }
}

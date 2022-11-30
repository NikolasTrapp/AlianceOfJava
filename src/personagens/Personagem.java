package personagens;

import acoes.Efeito;

public abstract class Personagem {

    private int hp;
    private String nome;
    private int mp;
    private int xp;
    private int xpBar;
    private int level;
    private Efeito efeito;
    private int danoBase;

    public Personagem(int hp, String nome, int mp, int xp, int xpBar, int level, int danoBase, Efeito efeito) {
        this.hp = hp;
        this.nome = nome;
        this.mp = mp;
        this.xp = xp;
        this.xpBar = xpBar;
        this.level = level;
        this.danoBase = danoBase;
        this.efeito = efeito;
    }

    public Personagem() {
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXpBar() {
        return xpBar;
    }

    public void setXpBar(int xpBar) {
        this.xpBar = xpBar;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public void setEfeito(Efeito efeito) {
        this.efeito = efeito;
    }

    public abstract void mostrarAtaques();

    public abstract void mostrarAtributos();
}

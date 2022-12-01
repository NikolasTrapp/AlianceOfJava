package personagens;

import ataques.Efeito;
import equipamentos.Equipamento;

public abstract class Personagem {

    private int hp;
    private int hpBase;
    private String nome;
    private int mp;
    private int xp = 0;
    private int xpBar = 10;
    private int level = 1;
    private Efeito efeito = Efeito.NENHUM;
    private int danoBase;
    private Equipamento equipamento;

    public Personagem() {}


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

    public void addXp(int xp) {
        if (getXp() + xp >= getXpBar()){
            setXp(getXp() + xp % xpBar);
            level++;
            setXpBar(10);
        }
        this.xp += xp;
    }

    private void setXp(int xp){
        this.xp = xp;
    }

    public int getXpBar() {
        return xpBar;
    }

    private void setXpBar(int xpBar) {
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

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public int getHpBase() {
        return hpBase;
    }

    public void setHpBase(int hpBase) {
        this.hpBase = hpBase;
    }

    public abstract void mostrarAtaques();

    public abstract void mostrarAtributos();

    //public abstract int atacar();

    public abstract void tomarDano(int dano);

    public abstract String imprimirAtributos();

}

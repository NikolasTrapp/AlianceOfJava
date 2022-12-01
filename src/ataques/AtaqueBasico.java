package ataques;

public abstract class AtaqueBasico implements Ataque{

    private String nome;
    private int dano;
    private int chanceCritico;
    private int chanceErro;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getChanceCritico() {
        return chanceCritico;
    }

    public void setChanceCritico(int chanceCritico) {
        this.chanceCritico = chanceCritico;
    }

    public int getChanceErro() {
        return chanceErro;
    }

    public void setChanceErro(int chanceErro) {
        this.chanceErro = chanceErro;
    }
}

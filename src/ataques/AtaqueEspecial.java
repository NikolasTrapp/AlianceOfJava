package ataques;

public abstract class AtaqueEspecial implements Ataque{

    private String nome;
    private int dano;
    private int chanceCritico;
    private int chanceErro;
    private Efeito efeito;
    private int custoMP;


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

    public Efeito getEfeito() {
        return efeito;
    }

    public void setEfeito(Efeito efeito) {
        this.efeito = efeito;
    }

    public int getCustoMP() {
        return custoMP;
    }

    public void setCustoMP(int custoMP) {
        this.custoMP = custoMP;
    }
}

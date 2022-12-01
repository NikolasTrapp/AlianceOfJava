package ataques;

public class AtaqueEspecial extends Ataque{

    private Efeito efeito;
    private int custoMP;
    private int chanceEfeito;

    public AtaqueEspecial(String nome, int dano, int chanceCritico, int chanceErro, Efeito efeito, int custoMP, String classe, int nivelMinimo) {
        super(nome, dano, chanceCritico, chanceErro, classe, nivelMinimo);
        this.efeito = efeito;
        this.custoMP = custoMP;
        this.chanceEfeito = efeito.getChance();
    }
    @Override
    public int calcularDano() {
        return getDano();
    }

    @Override
    public void mostrarAtributos() {
        System.out.println("Nome: " + getNome());
        System.out.println("Dano: " + getDano());
        System.out.println("Chance Critico: " + getChanceCritico());
        System.out.println("Chance Erro: " + getChanceErro());
        System.out.println("Custo mp: " + getCustoMP());
        System.out.println("Efeito: " + getEfeito());
        System.out.println();
    }





    //GETTERS E SETTERS

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


    public int getChanceEfeito() {
        return chanceEfeito;
    }

    public void setChanceEfeito(int chanceEfeito) {
        this.chanceEfeito = chanceEfeito;
    }
}

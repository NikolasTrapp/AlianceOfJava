package ataques;

public abstract class Ataque {

    private String nome;
    private int dano;
    private int chanceCritico;
    private int chanceErro;
    private String classe;
    private int nivelMinimo;


    public Ataque(String nome, int dano, int chanceCritico, int chanceErro, String classe, int nivelMinimo) {
        this.nome = nome;
        this.dano = dano;
        this.chanceCritico = chanceCritico;
        this.chanceErro = chanceErro;
        this.classe = classe;
        this.nivelMinimo = nivelMinimo;
    }


    public abstract int calcularDano();
    public abstract void mostrarAtributos();



    //GETTERS E SETTERS

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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(int nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }



}

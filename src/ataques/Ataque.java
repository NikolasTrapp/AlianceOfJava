package ataques;

public abstract class Ataque {

    private String nome;
    private int dano;
    private int chanceCritico;
    private int chanceErro;
    private int chanceEfeito;
    private String[] classes;
    private int nivelMinimo;
    private Efeito efeito;

    public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";

    public Ataque(String nome, int dano, int chanceCritico, int chanceErro, int chanceEfeito, String[] classes, int nivelMinimo, Efeito efeito) {
        this.nome = nome;
        this.dano = dano;
        this.chanceCritico = chanceCritico;
        this.chanceErro = chanceErro;
        this.chanceEfeito = chanceEfeito;
        this.classes = classes;
        this.nivelMinimo = nivelMinimo;
        this.efeito = efeito;
    }

    public void uparSkill(){
    	this.dano += 5;
    }
    
    public abstract int calcularDanoAtaque();
    public abstract void mostrarAtributos();

    public int getRandom(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public boolean temNaLista(String nome){
        for (String str : classes){
            if (str.equalsIgnoreCase(nome)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return ANSI_GREEN+"Ataque\n" +
                "nome='" + nome + '\'' +
                ", dano=" + dano +
                ", chanceCritico=" + chanceCritico +
                ", chanceErro=" + chanceErro +
                ", chanceEfeito=" + chanceEfeito +
                ", efeito=" + getEfeito().getNome()+ANSI_RESET;
    }

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

    public String[] getClasse() {
        return classes;
    }

    public void setClasse(String[] classe) {
        this.classes = classe;
    }

    public int getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(int nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public void setEfeito(Efeito efeito) {
        this.efeito = efeito;
    }

    public int getChanceEfeito() {
        return chanceEfeito;
    }

    public void setChanceEfeito(int chanceEfeito) {
        this.chanceEfeito = chanceEfeito;
    }
}
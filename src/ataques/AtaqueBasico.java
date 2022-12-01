package ataques;

public class AtaqueBasico extends Ataque{


    public AtaqueBasico(String nome, int dano, int chanceCritico, int chanceErro, String classe, int nivelMinimo) {
        super(nome, dano, chanceCritico, chanceErro, classe, nivelMinimo);
    }

    @Override
    public int calcularDano() {
        return 0;
    }

    @Override
    public void mostrarAtributos() {
        System.out.println("Nome: " + getNome());
        System.out.println("Dano: " + getDano());
        System.out.println("Chance Critico: " + getChanceCritico());
        System.out.println("Chance Erro: " + getChanceErro());
        System.out.println();
    }
}

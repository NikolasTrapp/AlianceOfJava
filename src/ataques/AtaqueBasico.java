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
        System.out.println("ChanceCritico: " + getChanceCritico());
        System.out.println("ChanceErro: " + getChanceErro());
        System.out.println("Classe: " + getClasse());
        System.out.println("Nivel minimo: " + getNivelMinimo());
    }
}

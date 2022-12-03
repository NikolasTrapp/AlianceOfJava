package ataques;

public class AtaqueBasico extends Ataque{


    public AtaqueBasico(String nome, int dano, int chanceCritico, int chanceErro, int chanceEfeito, String classe, int nivelMinimo, Efeito efeito) {
        super(nome, dano, chanceCritico, chanceErro, chanceEfeito, classe, nivelMinimo, efeito);
    }

    @Override
    public int calcularDanoAtaque() {
        int randomCe = getRandom(1, 100); // Chance de erro
        int randomCc = getRandom(1, 100); // Chance de crítico
        int danoTotal = getDano();

        if (randomCc <= getChanceCritico()){
            System.out.println("Você critou!!!");
            danoTotal *= 1.5;
        }

        if (randomCe <= getChanceErro()) {
            System.out.println("Você errou o ataque!");
            danoTotal = 0;
        }
        return danoTotal;
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

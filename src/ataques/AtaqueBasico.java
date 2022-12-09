package ataques;

public class AtaqueBasico extends Ataque{
	 	public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";

    public AtaqueBasico(String nome, int dano, int chanceCritico, int chanceErro, int chanceEfeito, String[] classes, int nivelMinimo, Efeito efeito) {
        super(nome, dano, chanceCritico, chanceErro, chanceEfeito, classes, nivelMinimo, efeito);
    }

    @Override
    public int calcularDanoAtaque() {
        /**
         * Esta função calcula o dano do ataque, verificando se o ataque critou
         * ou se errou o ataque
         *
         * @return O dano total causado pelo ataque.
         */
        int randomCe = getRandom(1, 100); // Chance de erro
        int randomCc = getRandom(1, 100); // Chance de crítico
        int danoTotal = getDano();

        if (randomCc <= getChanceCritico()){
            System.out.println(ANSI_GREEN+"Você critou!!!"+ANSI_RESET);
            danoTotal *= 1.5;
        }

        if (randomCe <= getChanceErro()) {
            System.out.println(ANSI_RED+"Você errou o ataque!"+ANSI_RESET);
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
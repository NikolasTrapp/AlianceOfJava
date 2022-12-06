package ataques;

public class AtaqueEspecial extends Ataque{


    private int custoMP;

    public AtaqueEspecial(String nome, int dano, int chanceCritico, int chanceErro, int chanceEfeito, Efeito efeito, int custoMP, String[] classes, int nivelMinimo) {
        super(nome, dano, chanceCritico, chanceErro, chanceEfeito, classes, nivelMinimo, efeito);
        this.custoMP = custoMP;
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
            System.out.println("Você critou!!!");
            danoTotal += getDano() * 1.5;
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
        System.out.println("Custo mp: " + getCustoMP());
        System.out.println("Efeito: " + getEfeito().getNome());
        System.out.println();
    }



    //GETTERS E SETTERS

    public int getCustoMP() {
        return custoMP;
    }

    public void setCustoMP(int custoMP) {
        this.custoMP = custoMP;
    }
}
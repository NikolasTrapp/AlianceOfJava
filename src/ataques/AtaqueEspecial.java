package ataques;

public class AtaqueEspecial extends Ataque{

    private Efeito efeito;
    private int custoMP;
    private int chanceEfeito;

    public AtaqueEspecial(String nome, int dano, int chanceCritico, int chanceErro, int chanceEfeito, Efeito efeito, int custoMP, String classe, int nivelMinimo) {
        super(nome, dano, chanceCritico, chanceErro, classe, nivelMinimo);
        this.efeito = efeito;
        this.custoMP = custoMP;
        this.chanceEfeito = chanceEfeito;
    }
    @Override
    public int calcularDano() {
        int randomCe = getRandom(1, 100); // Chance de erro
        int randomCc = getRandom(1, 100); // Chance de crítico
        int randomEf = getRandom(1, 100); // Chance de aplicar efeito
        int danoTotal = getDano();

        if (randomCc <= getChanceCritico()){
            System.out.println("Você critou!!!");
            danoTotal += getDano() * 1.5;
        }

        if (randomCe <= getChanceErro()) {
            System.out.println("Você errou o ataque!");
            danoTotal = 0;
        }

        if (randomEf <= getChanceEfeito()) {
            int danoEfeito = verificarEfeito();
            System.out.println("o efeito " + efeito + " do seu ataque resultou em um adicional de " + danoEfeito + " pontos de dano");
            danoTotal += danoEfeito;
        }
        return danoTotal;
    }

    private int verificarEfeito() {
        if (efeito == null || efeito == Efeito.NENHUM) return 0;
        else if (efeito == Efeito.CHAMAS){
            efeito.aplicarEfeito();
            return efeito.getDano();
        }
        else if (efeito == Efeito.SANGRAMENTO) {
            efeito.aplicarEfeito();
            return efeito.getDanoMultiplicado();
        }
        else return 0;
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

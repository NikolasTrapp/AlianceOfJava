package ataques;

public class Flechada extends AtaqueBasico{


    public Flechada() {
        setNome("Flechada");
        setDano(18);
        setChanceCritico(18);
        setChanceErro(10);
    }

    @Override
    public int calcularDano() {
        int cc = (int)Math.floor(Math.random()*(100)); //Chance de critico
        int ce = (int)Math.floor(Math.random()*(100)); //Chance de erro
        int dano = getDano();
        if (cc <= getChanceCritico()){
            dano += getDano()*1.20;
            System.out.println("Uau, você conseguiu dar dano critico, aumentando seu ataque em: " + getDano()*1.20);
        }
        if (ce <= getChanceErro()){
            dano = 0;
            System.out.println("Você errou o ataque :(");
        }

        return dano;
    }

    @Override
    public void mostrarAtributos() {
        System.out.println("Ataque: " + getNome());
        System.out.println("Dano: " + getDano());
        System.out.println("Chance de crítico: " + getChanceCritico());
        System.out.println("Chance de erro: " + getChanceErro());
    }
}

package ataques;

public enum Efeito {

    NENHUM(100),
    CHAMAS(20),
    PARALIZIA(70),
    SANGRAMENTO(10),
    FRAQUEZA(30);

    final int chance;
    Efeito(int chance){
        this.chance = chance;
    }

    public int getChance(){
        return chance;
    }
}

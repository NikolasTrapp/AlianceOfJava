package ataques;

public enum Efeito {

    NENHUM(0),
    CHAMAS(2),
    PARALIZIA(0),
    DORMENCIA(0),
    VENENO(2),
    CONGELAMENTO(0),
    SANGRAMENTO(1),
    FRAQUEZA(0),
    DECOMPOSICAO(4);

    final int dano;
    private int turno = 1;

    Efeito(int dano){
        this.dano = dano;
    }

    public int getDano(){
        if (turno <= 3) return dano;
        return 0;
    }

    public int getDanoMultiplicado(){
        if (turno <= 3) return dano*turno;
        return 0;
    }

    public void aplicarEfeito(){
        if (turno <= 3) this.turno++;
        this.turno = 1;
    }

    public int getTurno(){
        return turno;
    }
}

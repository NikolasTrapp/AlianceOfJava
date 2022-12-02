package ataques;

import java.util.Objects;

public class Efeito {

    private String nome;
    private int dano;
    private int turno = 1;
    private int numeroMaxTurnos;
    private TipoEfeito tipoEfeito;

    public Efeito(String nome, int dano, int numeroMaxTurnos, TipoEfeito tipoEfeito) {
        this.nome = nome;
        this.dano = dano;
        this.numeroMaxTurnos = numeroMaxTurnos;
        this.tipoEfeito = tipoEfeito;
    }



    public int getDano() {
        System.out.println(dano + " " + turno + " " + (dano*turno));
        if (getNome().equalsIgnoreCase("Sangramento")) return dano * turno;
        return dano;
    }


    @Override
    public String toString() {
        return "Efeito{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Efeito efeito = (Efeito) o;
        return Objects.equals(nome, efeito.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getTurno() {
        return turno;
    }

    public void addTurno() {
        this.turno += 1;
    }

    public void resetTurnos(){
        this.turno = 1;
    }

    public int getNumeroMaxTurnos() {
        return numeroMaxTurnos;
    }

    public void setNumeroMaxTurnos(int numeroMaxTurnos) {
        this.numeroMaxTurnos = numeroMaxTurnos;
    }

    public TipoEfeito getTipoEfeito() {
        return tipoEfeito;
    }

    public void setTipoEfeito(TipoEfeito tipoEfeito) {
        this.tipoEfeito = tipoEfeito;
    }
}

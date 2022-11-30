package equipamentos;

import acoes.Acoes;

public abstract class Equipamento {

    protected Tipo tipo;
    protected String nome;
    protected int usos;
    protected int forca;

    public Equipamento(Tipo tipo, String nome, int usos, int forca) {
        this.tipo = tipo;
        this.nome = nome;
        this.usos = usos;
        this.forca = forca;
    }

    public abstract int usar(int tipoPersonagem);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }
}

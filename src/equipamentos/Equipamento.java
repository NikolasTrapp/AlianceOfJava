package equipamentos;

public abstract class Equipamento {

    protected int atributo;
    protected String nome;
    protected int usos;

    public Equipamento(int atributo, String nome, int usos) {
        this.atributo = atributo;
        this.nome = nome;
        this.usos = usos;
    }

    public abstract int usar(int atributoPersonagem);
}

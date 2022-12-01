package equipamentos;

public class Equipamento {

    private Tipo tipo;
    private String nome;
    private int usos;
    private int forca;

    public Equipamento(Tipo tipo, String nome, int usos, int forca) {
        this.tipo = tipo;
        this.nome = nome;
        this.usos = usos;
        this.forca = forca;
    }

    public int usar(int tipoPersonagem) {
        return 0;
    }


    //GETTERS E SETTERS
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

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

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }
}

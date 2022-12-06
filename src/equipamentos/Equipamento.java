package equipamentos;

import java.util.Scanner;

public class Equipamento {

	
            		
    private int chanceMin;
    private int chanceMax;
    private Tipo tipo;
    private String nome;
    private int usos;
    private int forca;

    private Scanner sc = new Scanner(System.in);

    public Equipamento(Tipo tipo, String nome, int usos, int forca, int chanceMin, int chanceMax) {
        this.tipo = tipo;
        this.nome = nome;
        this.usos = usos;
        this.forca = forca;
        this.chanceMin = chanceMin;
        this.chanceMax = chanceMax;
    }

    public int usar() {
        /**
         * Esta função verifica se o personagem quer usar o equipamento.
         *
         * @return O dano causado/protegido pelo equipamento.
         */
        System.out.println("Você deseja usar seu item " + getNome() +
                "? Ainda lhe restam " + getUsos() + " usos! (s para SIM, senão digite qualquer coisa)");
        char c = sc.next().charAt(0);
        if (c == 's' || c == 'S'){
            this.usos--;
            if (usos <= 0) System.out.println("O seu equiapento " + nome + " quebrou!!!");
            return getForca();
        }
        return 0;
    }

    public void imprimirAtributos(){
        System.out.println("Nome: " + getNome());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Força: " + getForca());
        System.out.println("Usos: " + getUsos());
    }

    public boolean validarChance(int n) {
    	
    	return n >= chanceMin && n <= chanceMax;
    }
    
    @Override
	public String toString() {
		return "Equipamento [chanceMin=" + chanceMin + ", chanceMax=" + chanceMax + ", tipo=" + tipo + ", nome=" + nome
				+ ", usos=" + usos + ", forca=" + forca + ", sc=" + sc + "]";
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
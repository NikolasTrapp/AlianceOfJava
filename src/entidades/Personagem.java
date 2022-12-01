package entidades;

import ataques.*;
import equipamentos.Equipamento;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Personagem extends Criatura{

    private int mp;
    private double xp = 0;
    private int xpBar = 10;
    private int level = 1;

    private Equipamento equipamento;
    private ArrayList<AtaqueBasico> ataquesBasicos = new ArrayList<>();
    private ArrayList<AtaqueEspecial> ataqueEspecial = new ArrayList<>();


    public Personagem(double hpBase, String nome, int danoBase, int mp) {
        super(hpBase, nome, danoBase);
        this.mp = mp;
    }


    public void mostrarAtaques() {
        System.out.println("Ataques Básicos:");
        imprimirAtaques(ataquesBasicos);
        System.out.println("Ataques Especiais:");
        imprimirAtaques(ataqueEspecial);
    }

    private void imprimirAtaques(ArrayList<? extends Ataque> ataques){
        ataques.forEach(atk -> {
            System.out.println("Ataque " + atk.getClasse() + " " + atk.getNome() + " numero: " + (ataquesBasicos.indexOf(atk) + 1) + ":");
            atk.mostrarAtributos();
        });
    }

    public void mostrarAtributos() {
        System.out.println("Nome: " + getNome());
        System.out.println("HP: " + getHpBase());
        System.out.println("Dano: " + getDanoBase());
        System.out.println("MP: " + getMp());
        mostrarAtaques();
    }

    public void addXp(double xp) {
        if (getXp() + xp >= getXpBar()){
            setXp((getXp() + xp) % xpBar);
            this.level++;
            setXpBar(getXpBar()+10);
            carregarAtaques();
        }
        this.xp += xp;
    }

    @Override
    public int tomarDano(int dano) {
        setHp(getHp()-dano);
        return dano;
    }

    @Override
    public int desferirDano() {
        return getDanoBase();
    }

    public void carregarAtaques(){
        this.ataquesBasicos = ListaAtaques.ataquesBasicos.stream().filter(ataque -> ataque.getClasse().equals(getNome()) && getLevel() <= ataque.getNivelMinimo()).collect(Collectors.toCollection(ArrayList::new));
        this.ataqueEspecial = ListaAtaques.ataqueEspecial.stream().filter(ataque -> ataque.getClasse().equals(getNome()) && getLevel() <= ataque.getNivelMinimo()).collect(Collectors.toCollection(ArrayList::new));
    }

    //public void escolherAtaque(){}



    @Override
    public String toString() {
        return "Personagem{" +
                "mp=" + mp +
                '}';
    }

    //GETTERS E SETTERS
    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    private void setXp(double xp) {
        this.xp = xp;
    }

    public double getXp() {
        return xp;
    }

    public int getXpBar() {
        return xpBar;
    }

    public void setXpBar(int xpBar) {
        this.xpBar = xpBar;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}

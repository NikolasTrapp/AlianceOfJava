package entidades;

import ataques.*;
import equipamentos.Equipamento;
import equipamentos.Tipo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Personagem extends Criatura{

    private int mp;
    private double xp = 0;
    private int xpBar = 10;
    private int level = 1;

    private Equipamento equipamento = new Equipamento(Tipo.DEFESA, "Armadura", 2, 2);
    private ArrayList<AtaqueBasico> ataquesBasicos = new ArrayList<>();
    private ArrayList<AtaqueEspecial> ataqueEspecial = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);


    public Personagem(double hpBase, String nome, int danoBase, int mp) {
        super(hpBase, nome, danoBase);
        this.mp = mp;
        carregarAtaques();
    }


    public void mostrarAtaques() {
        System.out.println();
        System.out.println("Ataques Básicos:");
        imprimirAtaques(ataquesBasicos);
        System.out.println();
        System.out.println("Ataques Especiais:");
        imprimirAtaques(ataqueEspecial);
    }

    private void imprimirAtaques(ArrayList<? extends Ataque> ataques){
        ataques.forEach(atk -> {
            System.out.println("Ataque " + "\"" + atk.getNome() + "\"" + ", numero: " + (ataques.indexOf(atk) + 1) + ":");
            atk.mostrarAtributos();
        });
    }

    public void mostrarAtributos() {
        System.out.println("----------ATRIBUTOS----------");
        System.out.println("Nome: " + getNome());
        System.out.println("HP: " + getHpBase());
        System.out.println("Dano: " + getDanoBase());
        System.out.println("MP: " + getMp());
        System.out.println("-----------ATAQUES-----------");
        mostrarAtaques();
    }

    public void addXp(double xp) {
        System.out.println("Você ganhou " + xp + " de XP!!!");

        if (getXp() + xp >= getXpBar()){
            setXp((getXp() + xp) % getXpBar());
            this.level++;
            setXpBar(getXpBar()+10);
            carregarAtaques();
        } else {
            this.xp += xp;
        }
        System.out.println("Ainda te restam " + (getXpBar() - getXp()) + " para subir ao nível " + (getLevel() + 1));
    }

    @Override
    public int tomarDano(int dano) {
        dano -= (equipamento.getTipo() == Tipo.DEFESA) ? verificarEquipamento() : 0;
        setHp(getHp()-dano);
        return dano;
    }

    @Override
    public int atacar() {
        int dano = 90;
        System.out.println("Seus ataques:");
        mostrarAtaques();

        boolean flag = true;
        while (flag){
            try {
                System.out.println("Você deseja usar um ataque especial? (s para SIM, senão digite qualquer coisa)");
                char c = sc.next().charAt(0);
                System.out.println("Qual ataque você deseja usar:");
                int opc = sc.nextInt();
                dano += (c == 's' || c == 'S') ? ataqueEspecial.get(opc-1).calcularDano() : ataquesBasicos.get(opc-1).calcularDano();
                if (equipamento.getTipo() == Tipo.ATAQUE) dano += verificarEquipamento();
                flag = false;
            } catch (IndexOutOfBoundsException err){
                System.out.println("Verifique a opção selecionada!");
            } catch (InputMismatchException err){
                System.out.println("Digita um numero aí meu!");
            }
        }

        return dano;
    }

    private int verificarEquipamento(){
        if (equipamento == null) return 0;
        if (equipamento.getUsos() <= 0) {
            setEquipamento(null);
            return 0;
        }

        System.out.println("Você deseja usar seu item " + equipamento.getNome() +
                "? Ainda lhe restam " + equipamento.getUsos() + " usos! (s para SIM, senão digite qualquer coisa)");
        char c = sc.next().charAt(0);
        return (c == 's' || c == 'S') ? equipamento.usar() : 0;
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

package entidades;

import ataques.Ataque;
import ataques.Efeito;
import ataques.ListaAtaques;
import ataques.TipoEfeito;

public abstract class Criatura {

    private double hp;
    private double hpBase;
    private String nome;
    private int danoBase;
    private int dano;
    private Efeito efeito = ListaAtaques.efeitos.get(0); //Definindo efeito padrão = Nenhum

    public Criatura(double hpBase, String nome, int danoBase) {
        this.hpBase = hpBase;
        this.hp = getHpBase();
        this.nome = nome;
        this.danoBase = danoBase;
        this.dano = getDanoBase();
    }

    public abstract int tomarDano(int dano);

    public abstract int atacar(Criatura inimigo);

    public void passarEfeito(Ataque ataque){
        int random = (int)Math.floor(Math.random()*(100)+1);
        if (getEfeito().getTurno() >= getEfeito().getNumeroMaxTurnos()){
            limparEfeito();
            ataque.getEfeito().resetTurnos();
        }
        if (ataque.getEfeito().getNome().equalsIgnoreCase("Nenhum")) {
            System.out.println("O ataque não possui nenhum efeito, logo não há efeitos a serem aplicados ao inimigo");
            return;
        } else if (ataque.getEfeito().equals(getEfeito())){
            System.out.println("O inimigo já possui este efeito, logo não compensa adicioná-lo de novo");
            return;
        } else if (random > ataque.getChanceEfeito()){
            System.out.println("Você não conseguiu aplicar o efeito ao inimigo");
            return;
        } else {
            setEfeito(ataque.getEfeito());
        }
    }

    protected int validarDanoEfeito(){
        if (getEfeito().getNome().equalsIgnoreCase("Nenhum")) return 0;
        else if (getEfeito().getTipoEfeito() == TipoEfeito.ATAQUE) return getEfeito().getDano();
        else if (getEfeito().getTipoEfeito() == TipoEfeito.BUFF) return -getEfeito().getDano();
        else return 0;
    }


    @Override
    public String toString() {
        return "Criatura{" +
                "hpBase=" + hpBase +
                ", nome='" + nome + '\'' +
                ", danoBase=" + danoBase +
                '}';
    }


    // GETTERS AND SETTERS

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getHpBase() {
        return hpBase;
    }

    public void setHpBase(double hpBase) {
        this.hpBase = hpBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public void setEfeito(Efeito efeito) {
        this.efeito = efeito;
    }

    protected void limparEfeito(){
        setEfeito(ListaAtaques.pegarEfeito("Nenhum"));
        System.out.println(getEfeito());
    }

}

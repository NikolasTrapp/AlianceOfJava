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
        if (getEfeito().getTurno() > getEfeito().getNumeroMaxTurnos()){
            limparEfeito();
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
            setEfeito(ataque.getEfeito().clone());
        }
    }

    public int validarDanoEfeito(){
        int danoEfeito = 0;
        if (getEfeito().getTurno() > getEfeito().getNumeroMaxTurnos()) limparEfeito();
        if (getEfeito().getNome().equalsIgnoreCase("Nenhum")) return 0;
        else if (getEfeito().getTipoEfeito() == TipoEfeito.ATAQUE) {
            danoEfeito = getEfeito().getDano();
            getEfeito().addTurno();
            System.out.println(getNome() + " sofreu " + danoEfeito + " pontos de dano do efeito " + getEfeito().getNome());
        }
//        else if (getEfeito().getTipoEfeito() == TipoEfeito.DEBUFF) {
//            danoEfeito = -getEfeito().getDano();
//            getEfeito().addTurno();
//        }
        return danoEfeito;
    }

    protected boolean verificarEfeitoStatus(){
        if (getEfeito().getTipoEfeito() == TipoEfeito.STATUS && getEfeito().getTurno() <= getEfeito().getNumeroMaxTurnos()){
            getEfeito().addTurno();
            return true;
        }
        return false;
    }

    protected int verificarEfeitoBuffDebuff(){
        System.out.println(getEfeito().getNome());
        if (getEfeito().getTurno() > getEfeito().getNumeroMaxTurnos()) limparEfeito();
        else if (getEfeito().getNome().equalsIgnoreCase("Nenhum")) return 0;
        else if (getEfeito().getTipoEfeito() == TipoEfeito.BUFF){
            int dano = getEfeito().getDano();
            getEfeito().addTurno();
            System.out.println(getNome() + " deu +" + dano + " pontos de dano pois estava com " + getEfeito().getNome());
            return dano;
        } else if (getEfeito().getTipoEfeito() == TipoEfeito.DEBUFF){
            int dano = -getEfeito().getDano();
            getEfeito().addTurno();
            System.out.println(getNome() + " deu " + dano + " pontos de dano pois estava com " + getEfeito().getNome());
            return dano;
        }
        return 0;
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
        System.out.println("Limpou");
        setEfeito(ListaAtaques.pegarEfeito("Nenhum").clone());
    }

}

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

    private Equipamento equipamento;
    private ArrayList<AtaqueBasico> ataquesBasicos = new ArrayList<>();
    private ArrayList<AtaqueEspecial> ataqueEspecial = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Personagem(double hpBase, String nome, int danoBase, int mp) {
        super(hpBase, nome, danoBase);
        this.mp = mp;
        carregarAtaques();
    }


    public void mostrarAtaques() {
        /**
         * Esta função mostra os ataques que o personagem possui.
         */
        System.out.println();
        System.out.println("Ataques Básicos:");
        imprimirAtaques(ataquesBasicos);
        System.out.println();
        System.out.println("Ataques Especiais:");
        imprimirAtaques(ataqueEspecial);
    }

    private void imprimirAtaques(ArrayList<? extends Ataque> ataques){
        /**
         * Esta função imprime os ataques básicos ou avançados que o personagem possui.
         *
         * @param ataques Lista de ataques do personagem.
         */
        ataques.forEach(atk -> {
            System.out.println("Ataque " + "\"" + atk.getNome() + "\"" + ", numero: " + (ataques.indexOf(atk) + 1) + ":");
            atk.mostrarAtributos();
        });
    }

    public void mostrarAtributos() {
        /**
         * Esta função mostra os atributos do personagem
         */
        System.out.println(ANSI_BLUE+"----------ATRIBUTOS----------");
        System.out.println("Nome: " + getNome());
        System.out.println("HP: " + getHpBase());
        System.out.println("Dano: " + getDanoBase());
        System.out.println("MP: " + getMp());
        System.out.println("-----------ATAQUES-----------"+ANSI_RESET);
        mostrarAtaques();
    }

    public void addXp(double xp) {
        /**
         * Esta função faz a lógica de adicionar xp ao personagem,
         * aumentando o seu nivel caso atinja a quantidade necessária
         * da xp bar e em seguida carrega novos ataques caso haja algum.
         *
         * @param xp A quantidade de xp para ser adicionada.
         */
        System.out.println("☆☆☆ Você ganhou " + xp + " de XP!!! ☆☆☆");

        if (getXp() + xp >= getXpBar()){
            setXp((getXp() + xp) % getXpBar());
            this.level++;
            System.out.println("☆☆☆☆☆ Parabéns, Você subiu de nivel!!! ☆☆☆☆☆");
            setXpBar(getXpBar()+10);
//            carregarAtaques();
        } else {
            this.xp += xp;
        }
        System.out.println("Ainda te restam " + (getXpBar() - getXp()) + " para subir ao nível " + (getLevel() + 1));
    }

    @Override
    public int tomarDano(int dano) {
        /**
         * Esta função faz a parte da lógica do personagem tomar dano, ela
         * verifica se o personagem não possui nenhum efeito de ATAQUE ou
         * se ele tem algum equipamento que o proteja de danos, em seguida
         * retorna o dano a causado.
         *
         * @param dano O dano a ser causado ao personagem.
         *
         * @return O dano causado ao personagem.
         */
        if (!getEfeito().equals(ListaAtaques.pegarEfeito("Nenhum")) && getEfeito().getTipoEfeito() != TipoEfeito.STATUS){
            int danoEfeito = validarDanoEfeito();
            System.out.println(getNome() + " sofreu " + danoEfeito + " pontos de dano do efeito " + getEfeito().getNome());
            dano += danoEfeito;
            getEfeito().addTurno();
        }
        dano -=  verificarEquipamento(Tipo.DEFESA);
        setHp(getHp()-dano + verificarEquipamento(Tipo.CURA));
        return dano;
    }

    @Override
    public int atacar(Criatura inimigo) {
        /**
         * Esta função se responsabiliza pela função de atacar algum inimigo/boss,
         * ela faz as verificações se o personagem possui efeitos de BUFF, DEBUFF
         * ou status, ou algum equipamento que aumente seu dano e retorna o dano
         * que ele irá causar. Também aplica um efeito ao inimigo caso o ataque
         * selecionado tenha algum.
         *
         * @param inimigo O inimigo a ser atacado e aplicado um possivel efeito.
         *
         * @return O dano total do ataque desferido.
         */
        Ataque ataque = escolherAtaque();
        if (ataque == null) return 0;
        int dano = getDanoBase();
        dano += ataque.calcularDanoAtaque();
        dano += verificarEfeitoBuffDebuff();
        dano += verificarEquipamento(Tipo.ATAQUE);
        inimigo.passarEfeito(ataque);
        return dano;
    }

    private int verificarEquipamento(Tipo tipo){
        /**
         * Esta função verifica se o usuário possui algum equipamento com base
         * no efeito que ele deseja obter, caso tenha ele verifica se o equipamento
         * possui usos sobressalentes e retorna o numero da proteção ou dano extra.
         *
         * @param tipo O tipo do equipamento que se deseja verificar.
         *
         * @return O numero de dano ou proteção aplicada.
         */
        if (equipamento == null) return 0;
        if (equipamento.getUsos() <= 0) {
            setEquipamento(null);
            return 0;
        }
        if (equipamento.getTipo() == tipo){
            return equipamento.usar();
        }
        return 0;
    }


    public void carregarAtaques(){
        /**
         * Esta função carrega os ataques que são pertencentes a este personagem.
         */
        this.ataquesBasicos = ListaAtaques.ataquesBasicos.stream().filter(ataque -> ataque.temNaLista(getNome()) && getLevel() <= ataque.getNivelMinimo()).collect(Collectors.toCollection(ArrayList::new));
        this.ataqueEspecial = ListaAtaques.ataquesEspecial.stream().filter(ataque -> ataque.temNaLista(getNome()) && getLevel() <= ataque.getNivelMinimo()).collect(Collectors.toCollection(ArrayList::new));
    }

    public Ataque escolherAtaque(){
        /**
         * Esta função permite ao personagem escolher qual ataque ele irá desferir
         * fazendo os de tipo de aatque e custo de mp.
         *
         * @return O ataque escolhido
         */
        boolean flag = true;
        if (verificarEfeitoStatus()) return null;
        System.out.println("Seus ataques:");
        mostrarAtaques();
        while (flag){
            try{
                System.out.println("Qual tipo de ataque você gostaria de usar? Basico (b) ou Especial (e):");
                char opc = sc.next().charAt(0);
                System.out.println("Qual o numero do ataque que gostarias de usar:");
                int ataque = sc.nextInt()-1;

                if (opc == 'b' || opc == 'B'){
                    flag = false;
                    return ataquesBasicos.get(ataque);
                } else if (opc == 'e' || opc == 'E'){
                    AtaqueEspecial ataqueEs = ataqueEspecial.get(ataque);
                    if (ataqueEs.getCustoMP() <= getMp()) {
                        reduzirMp(ataqueEs.getCustoMP());
                        flag = false;
                        return ataqueEs;
                    } else {
                        System.out.println("Você não possui pontos de MP suficientes para utilizar este ataque! seus pontos: " + getMp());
                    }
                } else {
                    System.out.println("Verifique a opção informada!");
                }
            } catch (IndexOutOfBoundsException err){
                System.out.println("Verifique a opção selecionada!");
            } catch (InputMismatchException err){
                System.out.println("Digita um numero aí meu!");
            }
        }
        return null;
    }


    @Override
    public String toString() {
        super.toString();
        return "mp=" + mp +
                ", xp=" + xp +
                ", xpBar=" + xpBar +
                ", level=" + level +
                ", equipamento=" + equipamento;
    }

    //GETTERS E SETTERS
    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void reduzirMp(int mp){
        setMp(getMp()-mp);
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

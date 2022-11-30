package equipamentos;

public class PocaoCura extends Equipamento{

    public PocaoCura() {
        super(8, "Poção de cura", 1);
    }

    @Override
    public int usar(int atributoPersonagem) {
        if (usos > 0) {
            usos--;
            System.out.println("Usou " + nome);
            return atributoPersonagem + atributo;
        } else {
            System.out.println("Vix! Você não possui mais usos de " + nome);
            return 0;
        }
    }

}

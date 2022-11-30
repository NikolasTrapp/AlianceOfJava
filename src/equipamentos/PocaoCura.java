package equipamentos;

public class PocaoCura extends Equipamento{

    public PocaoCura() {
        super(Tipo.BUFF, "Poção de cura", 1, 8);
    }

    @Override
    public int usar(int atributoPersonagem) {
        if (usos > 0) {
            usos--;
            System.out.println("Usou " + nome);
            return atributoPersonagem + forca;
        } else {
            System.out.println("Vix! Você não possui mais usos de " + nome);
            return 0;
        }
    }

}

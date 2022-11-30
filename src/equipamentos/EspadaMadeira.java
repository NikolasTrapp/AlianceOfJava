package equipamentos;

public class EspadaMadeira extends Equipamento{

    public EspadaMadeira() {
        super(3, "Espada de madeira", 3);
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

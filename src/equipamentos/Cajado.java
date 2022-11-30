package equipamentos;

public class Cajado extends Equipamento{

    public Cajado() {
        super(4, "Cajado", 4);
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

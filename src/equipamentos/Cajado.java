package equipamentos;

public class Cajado extends Equipamento{

    public Cajado() {
        super(Tipo.ATAQUE, "Cajado", 4, 5);
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

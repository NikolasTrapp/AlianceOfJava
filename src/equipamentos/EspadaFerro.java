package equipamentos;

public class EspadaFerro extends Equipamento{

    public EspadaFerro() {
        super(Tipo.ATAQUE, "Espada de ferro", 3, 5);
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

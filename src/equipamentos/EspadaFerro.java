package equipamentos;

public class EspadaFerro extends Equipamento{

    public EspadaFerro() {
        super(5, "Espada de ferro", 3);
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

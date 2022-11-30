package equipamentos;

public class PocaoForca extends Equipamento{

    public PocaoForca() {
        super(Tipo.BUFF, "Poção de força", 1, 10);
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

import entidades.Personagem;

import java.util.ArrayList;

public class Gerenciador {

    public static int getRandom(int min, int max){
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }


}

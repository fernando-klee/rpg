package personagens;

import tiposPersonagens.Guerreiro;
import comportamento.Anao;

public class Gimli extends Guerreiro implements Anao {
    private int contaBebida;
    public Gimli() {
        super(9,2,4,60);
        this.isSociedadeDoAnel = true;
        this.contaBebida = 0;
    }

    @Override
    public void beber() {
        this.contaBebida += 1;
    }

    @Override
    public String falar() {
        if (this.contaBebida < 3) {
            return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
        } else return "What did I say? He can't hold his liquor!";
    }

    @Override
    public String toString() {
        return "I";
    }
}

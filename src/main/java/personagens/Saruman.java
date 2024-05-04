package personagens;

import tiposPersonagens.Mago;
import comportamento.Maia;

public class Saruman extends Mago implements Maia {
    public Saruman() {
        super(2,2,9,70);
        this.isSociedadeDoAnel = false;
    }

    @Override
    public Maia ressuscitar() {
        return null;
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }

    @Override
    public String toString() {
        return "S";
    }
}

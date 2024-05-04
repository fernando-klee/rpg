package personagens;

import tiposPersonagens.Arqueiro;
import comportamento.Monstro;

public class Goblim extends Arqueiro implements Monstro {
    public Goblim() {
        super(3,6,1,20);
        this.isSociedadeDoAnel = false;
    }

    @Override
    public String grunir() {
        return "Iiisshhhh";
    }

    @Override
    public String toString() {
        return "M";
    }
}

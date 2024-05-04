package personagens;

import tiposPersonagens.Guerreiro;
import comportamento.Monstro;

public class Orc extends Guerreiro implements Monstro {
    public Orc() {
        super(7,4,1,30);
        this.isSociedadeDoAnel = false;
    }

    @Override
    public String grunir() {
        return "Arrrggghhh";
    }

    @Override
    public String toString() {
        return "O";
    }
}

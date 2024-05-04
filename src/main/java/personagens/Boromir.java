package personagens;

import tiposPersonagens.Guerreiro;
import comportamento.Humano;

public class Boromir extends Guerreiro implements Humano {
    public Boromir() {
        super(7,6,3,40);
        this.isSociedadeDoAnel = true;
    }

    @Override
    public int envelhecer() {
        return this.constituicaoInicial -= 2;
    }

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }

    @Override
    public String toString() {
        return "B";
    }
}

package personagens;

import tiposPersonagens.Guerreiro;
import comportamento.Humano;

public class Aragorn extends Guerreiro implements Humano {
    public Aragorn() {
        super(10, 7, 6, 60);
        this.isSociedadeDoAnel = true;
    }

    @Override
    public int envelhecer() {
        return this.constituicaoInicial -= 1;
    }

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }

    @Override
    public String toString() {
        return "A";
    }
}


package personagens;

import tiposPersonagens.Guerreiro;
import comportamento.Humano;
import comportamento.Monstro;

public class Urukhai extends Guerreiro implements Monstro, Humano {
    public Urukhai() {
        super(8,6,3,45);
    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }

    @Override
    public int envelhecer() {
        return this.constituicaoInicial -= 2;
    }

    @Override
    public String falar() {
        return "Looks like meat's back on the menu boys!";
    }

    @Override
    public String toString() {
        return "U";
    }
}


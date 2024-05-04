package personagens;

import tiposPersonagens.Mago;
import comportamento.Maia;

public class Gandalf extends Mago implements Maia {
    public Gandalf() {
        super(2,3,10,80);
        this.isSociedadeDoAnel = true;
    }

    @Override
    public Maia ressuscitar() {
        if(this.constituicaoInicial <= 0) {
            return new Gandalf();
        } else return this;
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

    @Override
    public String toString() {
        return "G";
    }
}


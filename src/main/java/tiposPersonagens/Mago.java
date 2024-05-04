package tiposPersonagens;

public class Mago extends Personagem {
    public Mago(int forca, int agilidade, int inteligencia, int constituicaoInicial) {
        super(forca, agilidade, inteligencia, constituicaoInicial);
    }

    public void ataqueMago(Personagem oponente) {
        oponente.setConstituicaoInicial(oponente.getConstituicaoInicial() - this.inteligencia);
    }
}

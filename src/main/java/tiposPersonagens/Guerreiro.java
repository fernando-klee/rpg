package tiposPersonagens;

public class Guerreiro extends Personagem {
    public Guerreiro(int forca, int agilidade, int inteligencia, int constituicaoInicial) {
        super(forca, agilidade, inteligencia, constituicaoInicial);
    }

    public void ataqueGuerreiro(Personagem oponente) {
        oponente.setConstituicaoInicial(oponente.getConstituicaoInicial() - (2 * this.forca));
    }
}

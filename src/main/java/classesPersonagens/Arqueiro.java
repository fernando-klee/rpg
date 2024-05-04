package classesPersonagens;

public class Arqueiro extends Personagem {
    public Arqueiro(int forca, int agilidade, int inteligencia, int constituicaoInicial) {
        super(forca, agilidade, inteligencia, constituicaoInicial);
    }

    public void ataqueArqueiro(Personagem oponente, int posicao) {
        oponente.setConstituicaoInicial(oponente.getConstituicaoInicial() - (this.agilidade * posicao));
    }
}
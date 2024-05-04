package tiposPersonagens;

public  class Personagem {
    protected int forca;
    protected int agilidade;
    protected int inteligencia;
    protected int constituicaoInicial;
    protected boolean isSociedadeDoAnel;

    public Personagem(int forca, int agilidade, int inteligencia, int constituicaoInicial) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicaoInicial = constituicaoInicial;
        this.isSociedadeDoAnel = false;
    }

    public int getConstituicaoInicial() {
        return constituicaoInicial;
    }

    public void setConstituicaoInicial(int constituicaoInicial) {
        this.constituicaoInicial = constituicaoInicial;
    }

    public boolean isSociedadeDoAnel() {
        return isSociedadeDoAnel;
    }
}

package mapa;

import tiposPersonagens.Arqueiro;
import tiposPersonagens.Guerreiro;
import tiposPersonagens.Mago;
import tiposPersonagens.Personagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PosicaoOcupadaException;
import exceptions.SauronDominaOMundoException;

public class Simulador {
    private final Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular() throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException, SauronDominaOMundoException {
        boolean isGameOver = false;

        while (!isGameOver) {
            for (int i = 0; i < 10; i++) {
                Personagem p = mapa.buscarCasa(i);
                if (p != null) {
                    if (p instanceof Guerreiro) {
                        i = lanceGuerreiro(i, p);
                    }
                    if (p instanceof Mago) {
                        i = lanceMago(i, p);
                    }
                    if (p instanceof Arqueiro) {
                        i = lanceArqueiro(i, p);
                    }
                }
            }
            if ((mapa.buscarCasa(9) != null && mapa.buscarCasa(9).isSociedadeDoAnel())) {
                isGameOver = true;
            }
            if (isSociedadeMorta()) {
                throw new SauronDominaOMundoException();
            }
        }

    }

    private boolean isSociedadeMorta() {
        boolean temSociedadeViva = false;
        for (int i = 0; i < 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).isSociedadeDoAnel()) temSociedadeViva = true;
        }
        return !temSociedadeViva;
    }

    private int lanceArqueiro(int i, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (personagem.isSociedadeDoAnel()) {
            if (i + 3 < 10 && (mapa.buscarCasa(i + 3) != null) && (!mapa.buscarCasa(i + 3).isSociedadeDoAnel())) {
                int distancia = 3;
                ((Arqueiro) personagem).ataqueArqueiro(mapa.buscarCasa(i + 3), distancia);
                if (mapa.buscarCasa(i + 3).getConstituicaoInicial() <= 0) {
                    mapa.apagaPersonagem(i + 3);
                }
            } else if (i + 2 < 10 && (mapa.buscarCasa(i + 2) != null) && (!mapa.buscarCasa(i + 2).isSociedadeDoAnel())) {
                int distancia = 2;
                ((Arqueiro) personagem).ataqueArqueiro(mapa.buscarCasa(i + 2), distancia);
                if (mapa.buscarCasa(i + 2).getConstituicaoInicial() <= 0) {
                    mapa.apagaPersonagem(i + 2);
                }
            } else if (i + 1 < 10 && (mapa.buscarCasa(i + 1) != null) && (!mapa.buscarCasa(i + 1).isSociedadeDoAnel())) {
                int distancia = 1;
                ((Arqueiro) personagem).ataqueArqueiro(mapa.buscarCasa(i + 1), distancia);
                if (mapa.buscarCasa(i + 1).getConstituicaoInicial() <= 0) {
                    mapa.apagaPersonagem(i + 1);
                }
            }

            if ((i + 2 < 10) && (mapa.buscarCasa(i + 1) == null) && (mapa.buscarCasa(i + 2) == null)) {
                mapa.apagaPersonagem(i);
                mapa.inserir(i + 2, personagem);
                i = i + 2;

            } else if ((i + 1 < 10) && (mapa.buscarCasa(i + 1) == null)) {
                mapa.apagaPersonagem(i);
                mapa.inserir(i + 1, personagem);
                i++;

            }
        }
        if (!personagem.isSociedadeDoAnel()) {
            if ((i - 3 >= 0) && (mapa.buscarCasa(i - 3) != null) && (mapa.buscarCasa(i - 3).isSociedadeDoAnel())) {
                int distancia = 3;
                ((Arqueiro) personagem).ataqueArqueiro(mapa.buscarCasa(i - 3), distancia);
                if (mapa.buscarCasa(i - 3).getConstituicaoInicial() <= 0) {
                    mapa.apagaPersonagem(i - 3);
                }
            } else if ((i - 2 >= 0) && (mapa.buscarCasa(i - 2) != null) && (mapa.buscarCasa(i - 2).isSociedadeDoAnel())) {
                int distancia = 2;
                ((Arqueiro) personagem).ataqueArqueiro(mapa.buscarCasa(i - 2), distancia);
                if (mapa.buscarCasa(i - 2).getConstituicaoInicial() <= 0) {
                    mapa.apagaPersonagem(i - 2);
                }
            } else if ((i - 1 >= 0) && (mapa.buscarCasa(i - 1) != null) && (mapa.buscarCasa(i - 1).isSociedadeDoAnel())) {
                int distancia = 1;
                ((Arqueiro) personagem).ataqueArqueiro(mapa.buscarCasa(i - 1), distancia);
                if (mapa.buscarCasa(i - 1).getConstituicaoInicial() <= 0) {
                    mapa.apagaPersonagem(i - 1);
                }

            }
            if ((mapa.buscarCasa(i - 1) == null) && (mapa.buscarCasa(i - 2) == null)) {

                mapa.apagaPersonagem(i);
                mapa.inserir(i - 2, personagem);
            } else if (mapa.buscarCasa(i - 1) == null) {
                mapa.apagaPersonagem(i);
                mapa.inserir(i - 1, personagem);

            }
        }
        return i;
    }

    private int lanceMago(int i, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (personagem.isSociedadeDoAnel()) {
            for (int c = i; c < 10; c++) {
                Personagem personagemAtacado = mapa.buscarCasa(c);
                if ((personagemAtacado != null) && (!personagemAtacado.isSociedadeDoAnel())) {
                    ((Mago) personagem).ataqueMago(personagemAtacado);
                    if (personagemAtacado.getConstituicaoInicial() <= 0) {
                        mapa.apagaPersonagem(c);
                    }
                }
            }
            if (isUnicoPersonagem(personagem)) {
                mapa.apagaPersonagem(i);
                mapa.inserir(9, personagem);
            }
        }
        if (!personagem.isSociedadeDoAnel()) {
            for (int c = i; c >= 0; c--) {
                Personagem personagemAtacado = mapa.buscarCasa(c);
                if ((personagemAtacado != null) && (personagemAtacado.isSociedadeDoAnel())) {
                    ((Mago) personagem).ataqueMago(personagemAtacado);
                    if (personagemAtacado.getConstituicaoInicial() <= 0) {
                        mapa.apagaPersonagem(c);
                    }
                }
            }
        }
        return i;
    }

    private boolean isUnicoPersonagem(Personagem p) {
        boolean isUnico = true;
        for (int i = 0; i < 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i) != p) isUnico = false;
        }
        return isUnico;
    }

    private int lanceGuerreiro(int i, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (personagem.isSociedadeDoAnel()) {
            if (i + 1 < 10) {
                Personagem inimigoAtacado = mapa.buscarCasa(i + 1);
                if (inimigoAtacado != null && !inimigoAtacado.isSociedadeDoAnel()) {
                    ((Guerreiro) personagem).ataqueGuerreiro(inimigoAtacado);
                    if (inimigoAtacado.getConstituicaoInicial() <= 0) {
                        mapa.apagaPersonagem(i + 1);
                    }
                }
                if (inimigoAtacado == null) {
                    mapa.apagaPersonagem(i);
                    mapa.inserir(i + 1, personagem);
                    i = i + 1;
                }
            }
            return i;
        }
        if (!personagem.isSociedadeDoAnel()) {
            if (i - 1 >= 0) {
                Personagem inimigoAtacado = mapa.buscarCasa(i - 1);
                if (inimigoAtacado != null && inimigoAtacado.isSociedadeDoAnel()) {
                    ((Guerreiro) personagem).ataqueGuerreiro(inimigoAtacado);
                    if (inimigoAtacado.getConstituicaoInicial() <= 0) {
                        mapa.apagaPersonagem(i - 1);
                    }
                }
                if (inimigoAtacado == null) {
                    mapa.apagaPersonagem(i);
                    mapa.inserir(i - 1, personagem);

                }
            }
        }
        return i;
    }
}

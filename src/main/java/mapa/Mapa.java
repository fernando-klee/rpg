package mapa;

import tiposPersonagens.Personagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;

public class Mapa {
    Personagem[] arrayPersonagem = new Personagem[10];

    public String exibir(){
        String mapaExibido = "|";
        for (int i = 0; i < 10; i++) {
            mapaExibido = mapaExibido.concat(this.arrayPersonagem[i] == null? " |":this.arrayPersonagem[i].toString() + "|");
        }
        return mapaExibido;

    }
    public void inserir(int posicao, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (arrayPersonagem[posicao] != null){
            throw new PosicaoOcupadaException();
        }
        for (int i = 0; i < 10; i++){
            if (arrayPersonagem[i] == personagem){
                throw new PersonagemJaEstaNoMapaException();
            }
        }
        this.arrayPersonagem[posicao] = personagem;
    }
    public void apagaPersonagem(int posicao){
        this.arrayPersonagem[posicao] = null;

    }
    public int buscarPosicao(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException {
        Integer indexPersonagem = null;
        for (int i = 0; i < 10; i++){
            if (arrayPersonagem[i] == personagem){
                indexPersonagem = i;
            }
        }
        if (indexPersonagem == null){
            throw new PersonagemNaoEncontradoNoMapaException();
        }
        return indexPersonagem;
    }
    public Personagem buscarCasa(int posicao){
        return arrayPersonagem[posicao];
    }
}


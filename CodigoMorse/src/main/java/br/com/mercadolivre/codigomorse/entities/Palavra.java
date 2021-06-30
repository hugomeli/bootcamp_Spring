package br.com.mercadolivre.codigomorse.entities;

import br.com.mercadolivre.codigomorse.DecodificaMorse;

import java.util.Arrays;

public class Palavra {
    String letras;
    String palavraAlpha;
    String palavraMorse;

    public Palavra(String palavra){
        this.letras = Arrays.toString(palavra.split(" "));
        this.palavraMorse = palavra;
        this.palavraAlpha = DecodificaMorse.morseToEnglish(palavraMorse);
    }

    public String getPalavraAlpha() {
        return this.palavraAlpha;
    }

    public void setPalavraAlpha(String palavraAlpha) {
        this.palavraAlpha = palavraAlpha;
    }
}

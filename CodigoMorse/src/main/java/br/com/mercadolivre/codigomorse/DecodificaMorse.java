package br.com.mercadolivre.codigomorse;

import br.com.mercadolivre.codigomorse.entities.Palavra;

import java.util.ArrayList;

public class DecodificaMorse {

    static char[] letter = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0'};

    static String[] code
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "|"};


    public static String morseToEnglish(String morseCode)
    {
        String[] array = morseCode.split(" ");
        String palavraAlpha = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (array[i].compareTo(code[j]) == 0) {
                    palavraAlpha += ((char)(j + 'a'));
                    break;
                }
            }
        }
        return palavraAlpha;
    }

    public static ArrayList<Palavra> splitaPalavrasMorse(String morseCode){
        String[] array = morseCode.split("   ");
        ArrayList<Palavra> palavras = new ArrayList<>();
        for (String palavra:
             array) {
            palavras.add(new Palavra(palavra));
        }
        return palavras;
    }


    public static String central(String morseCode){
        String frase = "";
        ArrayList<Palavra> palavras = splitaPalavrasMorse(morseCode);
        for (Palavra p:
                palavras) {
            frase += p.getPalavraAlpha() + " ";
        }
        return frase;
    }
}

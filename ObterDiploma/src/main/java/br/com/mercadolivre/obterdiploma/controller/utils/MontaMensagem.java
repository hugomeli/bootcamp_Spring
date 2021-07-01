package br.com.mercadolivre.obterdiploma.controller.utils;

public class MontaMensagem {

    public static String montaMensagemMerito(double media, String nomeAluno){
        return "DIPLOMA DE APROVAÇÃO\n" +
                "Média: " + media + "\n" +
                "Aluno: " + nomeAluno +
                "\nPARABENSSSS!";
    }

    public static String montaMensagemSemMerito(double media, String nomeAluno){
        return "DIPLOMA DE APROVACAO\n" +
                "Média: " + media + "\n" +
                "Aluno: " + nomeAluno;

    }
}

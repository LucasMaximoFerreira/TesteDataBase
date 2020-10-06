package model;

abstract public class dadosEntreTela {

    static  String nomeTela;
    static String senhaTela;

    public static String getNomeTela() {
        return nomeTela;
    }

    public static void setNomeTela(String nomeTela) {
        dadosEntreTela.nomeTela = nomeTela;
    }

    public static String getSenhaTela() {
        return senhaTela;
    }

    public static void setSenhaTela(String senhaTela) {
        dadosEntreTela.senhaTela = senhaTela;
    }
}

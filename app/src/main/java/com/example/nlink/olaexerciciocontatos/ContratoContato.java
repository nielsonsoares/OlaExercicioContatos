package com.example.nlink.olaexerciciocontatos;

public final class ContratoContato {

    private ContratoContato () {}

    public static class ContatoEntry{
        public static final String TABLE_NAME = "contatos";
        public static final String ID = "id";
        public static final String NOME = "nome";
        public static final String EMAIL = "email";
        public static final String ENDERECO = "endereco";
        public static final String SEXO = "sexo";
        public static final String TEL_CEL = "tel_cel";
        public static final String TEL_RES = "tel_res";
        public static final String TEL_COM = "tel_com";
    }
}

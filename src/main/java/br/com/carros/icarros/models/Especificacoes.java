package br.com.carros.icarros.models;

public record Especificacoes(
        String codigo,
        String nome
) {

    @Override
    public String toString() {
        return "Cód: " + codigo + " Descrição: " + nome;
    }
}

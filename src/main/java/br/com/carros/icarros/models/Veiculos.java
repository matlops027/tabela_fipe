package br.com.carros.icarros.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public record Veiculos(String valor, String marca, String modelo, int anoModelo, String combustivel) {
    @Override
    public String toString() {
        return
                "[valor= " + valor +
                ", marca= " + marca +
                ", modelo= " + modelo +
                ", ano= " + anoModelo +
                ", combustivel= " + combustivel +
                ']';
    }
}

package br.com.carros.icarros.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface Conversor {
    <T> T desserializarObjeto(String json, Class<T> classe) throws JsonProcessingException;

    <T> List<T> desserializarLista(String json, Class<T> classe) throws JsonProcessingException;

    <T> List<T> desserializarLista(String json, Class<T> classe, String property) throws JsonProcessingException;
}

package br.com.carros.icarros.services;

import br.com.carros.icarros.interfaces.Conversor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class Serializer implements Conversor {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T desserializarObjeto(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json, classe);
    }

    @Override
    public <T> List<T> desserializarLista(String json, Class<T> classe) throws JsonProcessingException {
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);
        return mapper.readValue(json, lista);
    }

    @Override
    public <T> List<T> desserializarLista(String json, Class<T> classe, String property) throws JsonProcessingException {
        final String node = mapper.readTree(json).get(property).toString();
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);
        return mapper.readValue(node, lista);
    }
}

package br.com.oracle.screenmatch.service;

import br.com.oracle.screenmatch.model.SeriesData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertingData implements IConvertingData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> tclass) {
        try {
            return mapper.readValue(json, tclass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

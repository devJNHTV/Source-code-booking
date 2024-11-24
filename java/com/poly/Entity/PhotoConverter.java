package com.poly.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@jakarta.persistence.Converter
public class PhotoConverter implements AttributeConverter<List<String>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> photos) {
        try {
            // Chuyển đổi List<String> thành chuỗi JSON
            return objectMapper.writeValueAsString(photos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String photoJson) {
        try {
            // Chuyển đổi JSON thành List<String>
            return Arrays.asList(objectMapper.readValue(photoJson, String[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

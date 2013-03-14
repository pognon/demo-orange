package fr.company.demo.service.mobile.parser;

import java.io.IOException;
import java.io.StringReader;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import fr.company.demo.service.mobile.request.dto.QueryDto;

public class QueryParser {

    public static <T extends QueryDto> T getQueryData(String content, Class<T> queryClass) {

        T query = null;

        if (content == null || content.trim().equals("")) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            query = (T) mapper.readValue(new StringReader(content), queryClass);

        } catch (JsonMappingException e) {
            new RuntimeException("Error parsing json content");
        } catch (JsonParseException e) {
            new RuntimeException("Error parsing json content");
        } catch (IOException e) {
            new RuntimeException("Error parsing json content");
        }

        return query;

    }
}

package br.edu.infnet.dr3tp3.service;

import br.edu.infnet.dr3tp3.dto.EntitiesResponseDto;
import br.edu.infnet.dr3tp3.dto.EntityDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EntityService {

    @Autowired
    private HttpClientService httpClientService;

    @Value("${external.api.entities.url}")
    private String entitiesApiUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<EntityDto> getAllEntities() throws IOException {
        String response = httpClientService.sendGetRequest(entitiesApiUrl);
        EntitiesResponseDto entitiesResponse = objectMapper.readValue(response, EntitiesResponseDto.class);
        return entitiesResponse.entities();
    }

    public EntityDto getEntityById(Long id) throws IOException {
        String url = entitiesApiUrl + "/" + id;
        String response = httpClientService.sendGetRequest(url);
        return objectMapper.readValue(response, EntityDto.class);
    }
}

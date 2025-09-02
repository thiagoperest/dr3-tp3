package br.edu.infnet.dr3tp3.service;

import br.edu.infnet.dr3tp3.dto.ItemDto;
import br.edu.infnet.dr3tp3.dto.ItemsResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private HttpClientService httpClientService;

    @Value("${external.api.simpleapi.url}")
    private String itemsApiUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<ItemDto> getAllItems() throws IOException {
        String response = httpClientService.sendGetRequest(itemsApiUrl);
        ItemsResponseDto itemsResponse = objectMapper.readValue(response, ItemsResponseDto.class);
        return itemsResponse.items();
    }

    public ItemDto getItemById(Long id) throws IOException {
        String url = itemsApiUrl + "/" + id;
        String response = httpClientService.sendGetRequest(url);
        return objectMapper.readValue(response, ItemDto.class);
    }

    public ItemDto createItem(ItemDto item) throws IOException {
        String jsonData = objectMapper.writeValueAsString(item);
        String response = httpClientService.sendPostRequest(itemsApiUrl, jsonData);
        return objectMapper.readValue(response, ItemDto.class);
    }

    public ItemDto updateItem(Long id, ItemDto item) throws IOException {
        String url = itemsApiUrl + "/" + id;
        String jsonData = objectMapper.writeValueAsString(item);
        String response = httpClientService.sendPutRequest(url, jsonData);
        return objectMapper.readValue(response, ItemDto.class);
    }

    public void deleteItem(Long id) throws IOException {
        String url = itemsApiUrl + "/" + id;
        httpClientService.sendDeleteRequest(url);
    }

    public String getOptions() throws IOException {
        return httpClientService.sendOptionsRequest(itemsApiUrl);
    }
}

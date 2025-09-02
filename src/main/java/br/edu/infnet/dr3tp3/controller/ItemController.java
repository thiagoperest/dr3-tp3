package br.edu.infnet.dr3tp3.controller;

import br.edu.infnet.dr3tp3.dto.ApiResponse;
import br.edu.infnet.dr3tp3.dto.ItemDto;
import br.edu.infnet.dr3tp3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ItemDto>>> getAllItems() {
        try {
            List<ItemDto> items = itemService.getAllItems();
            ApiResponse<List<ItemDto>> response = new ApiResponse<>(
                    200,
                    "Items retrieved successfully",
                    items
            );
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            ApiResponse<List<ItemDto>> response = new ApiResponse<>(
                    500,
                    "Error retrieving items: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ItemDto>> getItemById(@PathVariable Long id) {
        try {
            ItemDto item = itemService.getItemById(id);
            ApiResponse<ItemDto> response = new ApiResponse<>(
                    200,
                    "Item retrieved successfully",
                    item
            );
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            ApiResponse<ItemDto> response = new ApiResponse<>(
                    500,
                    "Error retrieving item: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ItemDto>> createItem(@RequestBody ItemDto item) {
        try {
            ItemDto createdItem = itemService.createItem(item);
            ApiResponse<ItemDto> response = new ApiResponse<>(
                    201,
                    "Item created successfully",
                    createdItem
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IOException e) {
            ApiResponse<ItemDto> response = new ApiResponse<>(
                    500,
                    "Error creating item: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ItemDto>> updateItem(@PathVariable Long id, @RequestBody ItemDto item) {
        try {
            ItemDto updatedItem = itemService.updateItem(id, item);
            ApiResponse<ItemDto> response = new ApiResponse<>(
                    200,
                    "Item updated successfully",
                    updatedItem
            );
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            ApiResponse<ItemDto> response = new ApiResponse<>(
                    500,
                    "Error updating item: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteItem(@PathVariable Long id) {
        try {
            itemService.deleteItem(id);
            ApiResponse<Void> response = new ApiResponse<>(
                    204,
                    "Item deleted successfully",
                    null
            );
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            ApiResponse<Void> response = new ApiResponse<>(
                    500,
                    "Error deleting item: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<ApiResponse<String>> getOptions() {
        try {
            String options = itemService.getOptions();
            ApiResponse<String> response = new ApiResponse<>(
                    200,
                    "Options retrieved successfully",
                    options
            );
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            ApiResponse<String> response = new ApiResponse<>(
                    500,
                    "Error retrieving options: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

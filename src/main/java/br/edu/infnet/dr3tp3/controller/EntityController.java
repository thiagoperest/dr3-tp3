package br.edu.infnet.dr3tp3.controller;
import br.edu.infnet.dr3tp3.dto.ApiResponse;
import br.edu.infnet.dr3tp3.dto.EntityDto;
import br.edu.infnet.dr3tp3.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EntityDto>>> getAllEntities() {
        try {
            List<EntityDto> entities = entityService.getAllEntities();
            ApiResponse<List<EntityDto>> response = new ApiResponse<>(
                    200,
                    "Entities retrieved successfully",
                    entities
            );
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            ApiResponse<List<EntityDto>> response = new ApiResponse<>(
                    500,
                    "Error retrieving entities: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EntityDto>> getEntityById(@PathVariable Long id) {
        try {
            EntityDto entity = entityService.getEntityById(id);
            ApiResponse<EntityDto> response = new ApiResponse<>(
                    200,
                    "Entity retrieved successfully",
                    entity
            );
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            ApiResponse<EntityDto> response = new ApiResponse<>(
                    500,
                    "Error retrieving entity: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

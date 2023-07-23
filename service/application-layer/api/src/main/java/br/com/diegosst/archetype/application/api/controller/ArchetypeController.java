package br.com.diegosst.archetype.application.api.controller;

import br.com.diegosst.archetype.adapter.input.ArchetypeService;
import br.com.diegosst.archetype.domain.entity.BaseEntity;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ArchetypeController {

    private final ArchetypeService archetypeService;

    @GetMapping
    public ResponseEntity<List<BaseEntity>> getAllBaseEntity() {
        return new ResponseEntity<>(archetypeService.getAllBaseEntity(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseEntity> getBaseEntityByName(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(archetypeService.getBaseEntityById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity publishBaseEntity(@RequestBody final BaseEntity entity) throws JsonProcessingException {
        archetypeService.publishBaseEntity(new BaseEntityEvent(entity.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

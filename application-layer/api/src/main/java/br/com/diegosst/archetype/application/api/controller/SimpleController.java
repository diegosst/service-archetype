package br.com.diegosst.archetype.application.api.controller;

import br.com.diegosst.archetype.adapter.input.SimpleService;
import br.com.diegosst.archetype.domain.entity.BaseEntity;
import br.com.diegosst.archetype.event.BaseEntityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simple-api")
@RequiredArgsConstructor
public class SimpleController {

    private final SimpleService simpleService;

    @GetMapping
    public ResponseEntity<List<BaseEntity>> getAllBaseEntity() {
        return new ResponseEntity<>(simpleService.getAllBaseEntity(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseEntity> getBaseEntityByName(@PathVariable(value = "id") final String id) {
        return new ResponseEntity<>(simpleService.getBaseEntityById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity publishBaseEntity(@RequestBody final BaseEntity entity) throws JsonProcessingException {
        simpleService.publishBaseEntity(new BaseEntityEvent(entity.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

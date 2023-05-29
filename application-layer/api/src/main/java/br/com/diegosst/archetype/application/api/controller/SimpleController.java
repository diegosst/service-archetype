package br.com.diegosst.archetype.application.api.controller;

import br.com.diegosst.archetype.adapter.input.SimpleService;
import br.com.diegosst.archetype.domain.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simple-api")
@RequiredArgsConstructor
public class SimpleController {

    private final SimpleService simpleService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseEntity> getBaseEntityById(@PathVariable(value = "id") final String id) {
        return new ResponseEntity(simpleService.getBaseEntityById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity publishBaseEntity(@RequestBody final BaseEntity entity) {
        return new ResponseEntity(HttpStatus.OK);
    }


}

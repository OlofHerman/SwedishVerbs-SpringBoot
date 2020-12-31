package com.kastrup.swedishverbs.controller;

import com.kastrup.swedishverbs.dto.VerbDTO;
import com.kastrup.swedishverbs.exception.NotFoundException;
import com.kastrup.swedishverbs.model.Verb;
import com.kastrup.swedishverbs.service.VerbService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verb")
@AllArgsConstructor
public class VerbController {

    private final VerbService verbService;

    @ApiOperation(value = "Get all verbs")
    @GetMapping(path = "/all")
    public ResponseEntity<List<Verb>> getAllVerbs() {
        return new ResponseEntity<>(verbService.getAllVerbs(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get verbs by class")
    @GetMapping
    public ResponseEntity<List<Verb>> findByClass(final @ApiParam(allowableValues = "I, II, III, IV, V, VI, VIj", defaultValue = "I")
                                      @RequestParam(value = "class") String verbClass) {
        return new ResponseEntity<>(verbService.findByClass(verbClass), HttpStatus.OK);
    }

    @ApiOperation(value = "Get verb by ID")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Verb> findById(final @PathVariable long id) {
        return verbService.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @ApiOperation(value = "Delete a verb")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Verb> deleteVerb(final @PathVariable long id) {
        return verbService.deleteVerb(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @ApiOperation(value = "Post a verb")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Verb> registerVerb(final @RequestBody VerbDTO newVerbDTO) {
        return new ResponseEntity<>(verbService.registerVerb(newVerbDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a verb")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Verb> updateVerb(final @PathVariable long id, final @RequestBody VerbDTO newVerbDTO) {
        return verbService.updateVerb(id, newVerbDTO).map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException(id));
    }
}

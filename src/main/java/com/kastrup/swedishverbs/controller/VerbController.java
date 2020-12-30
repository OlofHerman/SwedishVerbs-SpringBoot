package com.kastrup.swedishverbs.controller;

import com.kastrup.swedishverbs.dto.VerbDTO;
import com.kastrup.swedishverbs.exception.NotFoundException;
import com.kastrup.swedishverbs.model.Verb;
import com.kastrup.swedishverbs.service.VerbService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verb")
public class VerbController {

    private final VerbService verbService;

    public VerbController(final VerbService verbService) {
        this.verbService = verbService;
    }

    @ApiOperation(value = "Get all verbs")
    @GetMapping(path = "/all")
    public List<Verb> getAllVerbs() {
        return verbService.getAllVerbs();
    }

    @ApiOperation(value = "Get verbs by class")
    @GetMapping
    public List<Verb> findByClass(final @ApiParam(allowableValues = "I, II, III, IV, V, VI, VIj", defaultValue = "I")
                                      @RequestParam(value = "class") String verbClass) {
        return verbService.findByClass(verbClass);
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
}

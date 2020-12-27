package com.kastrup.swedishverbs.controller;

import com.kastrup.swedishverbs.model.Verb;
import com.kastrup.swedishverbs.service.VerbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class VerbController {

    private final VerbService verbService;

    public VerbController(VerbService verbService) {
        this.verbService = verbService;
    }

    @GetMapping
    public List<Verb> getAllVerbs() {
        return verbService.getAllVerbs();
    }
}

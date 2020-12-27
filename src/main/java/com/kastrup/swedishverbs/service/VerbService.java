package com.kastrup.swedishverbs.service;

import com.kastrup.swedishverbs.model.Verb;
import com.kastrup.swedishverbs.repository.VerbRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerbService {

    private final VerbRepository verbRepository;

    public VerbService(VerbRepository verbRepository) {
        this.verbRepository = verbRepository;
    }

    public List<Verb> getAllVerbs() {
        return verbRepository.findAll();
    }
}

package com.kastrup.swedishverbs.service;

import com.kastrup.swedishverbs.dto.VerbDTO;
import com.kastrup.swedishverbs.model.Verb;
import com.kastrup.swedishverbs.repository.VerbRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class VerbService {

    private final VerbRepository verbRepository;

    public VerbService(VerbRepository verbRepository) {
        this.verbRepository = verbRepository;
    }

    public List<Verb> getAllVerbs() {
        return verbRepository.findAll();
    }

    public List<Verb> findByClass(final String verbClass) {
        return verbRepository.findByVerbClass(verbClass);
    }

    public Verb registerVerb(final VerbDTO newVerbDTO) {
        Verb newVerb = Verb.builder()
                .infinitive(newVerbDTO.getInfinitive())
                .present(newVerbDTO.getPresent())
                .preterite(newVerbDTO.getPreterite())
                .supine(newVerbDTO.getSupine())
                .oldInfinitive(newVerbDTO.getOldInfinitive())
                .oldPresent(newVerbDTO.getOldPresent())
                .oldPreterite(newVerbDTO.getOldPreterite())
                .oldPreteritePlural(newVerbDTO.getOldPreteritePlural())
                .oldPerfectParticiple(newVerbDTO.getOldPerfectParticiple())
                .verbClass(newVerbDTO.getVerbClass())
                .build();
        return verbRepository.save(newVerb);
    }

    public Optional<Verb> findById(final long id) {
        return verbRepository.findById(id);
    }

    public Optional<Verb> deleteVerb(final long id) {
        Optional<Verb> maybeVerb = verbRepository.findById(id);
        maybeVerb.ifPresent(verbRepository::delete);
        return maybeVerb;
    }
}

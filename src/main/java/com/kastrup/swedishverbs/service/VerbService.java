package com.kastrup.swedishverbs.service;

import com.kastrup.swedishverbs.dto.VerbDTO;
import com.kastrup.swedishverbs.model.Verb;
import com.kastrup.swedishverbs.repository.VerbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerbService {

    private final VerbRepository verbRepository;

    public List<Verb> getAllVerbs() {
        return verbRepository.findAll();
    }

    public List<Verb> findByClass(final String verbClass) {
        return verbRepository.findByVerbClass(verbClass);
    }

    public Verb registerVerb(final VerbDTO newVerbDTO) {
        return verbRepository.save(Verb.builder()
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
                .build());
    }

    public Optional<Verb> findById(final long id) {
        return verbRepository.findById(id);
    }

    public Optional<Verb> deleteVerb(final long id) {
        final Optional<Verb> maybeVerb = verbRepository.findById(id);
        maybeVerb.ifPresent(verbRepository::delete);
        return maybeVerb;
    }

    public Optional<Verb> updateVerb(final long id, final VerbDTO newVerbDTO) {
        Optional<Verb> maybeVerb = verbRepository.findById(id);
        maybeVerb.ifPresent(verb -> verbRepository.save(Verb.builder()
                .id(verb.getId())
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
                .build()));
        return maybeVerb;
    }
}

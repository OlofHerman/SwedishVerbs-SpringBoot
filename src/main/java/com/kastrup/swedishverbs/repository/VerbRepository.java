package com.kastrup.swedishverbs.repository;

import com.kastrup.swedishverbs.model.Verb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerbRepository extends JpaRepository<Verb, Long> {

    List<Verb> findByVerbClass(final String verbClass);
}

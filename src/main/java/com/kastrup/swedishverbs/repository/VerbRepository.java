package com.kastrup.swedishverbs.repository;

import com.kastrup.swedishverbs.model.Verb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerbRepository extends JpaRepository<Verb, Long> {

}

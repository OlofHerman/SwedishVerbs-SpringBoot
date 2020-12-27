package com.kastrup.swedishverbs.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@With
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Verb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    @Column
    private final String infinitive;

    @Column
    private final String present;

    @Column
    private final String preterite;

    @Column
    private final String supine;

    @Column
    private final String oldInfinitive;

    @Column
    private final String oldPresent;

    @Column
    private final String oldPreterite;

    @Column
    private final String oldPreteritePlural;

    @Column
    private final String oldPerfectParticiple;

    @Column
    private final String verbClass;
}

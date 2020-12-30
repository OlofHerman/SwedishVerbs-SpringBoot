package com.kastrup.swedishverbs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@With
@EqualsAndHashCode
@ToString
@ApiModel(description = "For posting a new verb")
public class VerbDTO {

    @ApiModelProperty(value = "Infinitive form of modern swedish verb")
    private final String infinitive;

    @ApiModelProperty(value = "Present form of modern swedish verb")
    private final String present;

    @ApiModelProperty(value = "Preterite form of modern swedish verb")
    private final String preterite;

    @ApiModelProperty(value = "Supine form of modern swedish verb")
    private final String supine;

    @ApiModelProperty(value = "Infinitive form of old swedish verb")
    private final String oldInfinitive;

    @ApiModelProperty(value = "Present form of old swedish verb")
    private final String oldPresent;

    @ApiModelProperty(value = "Preterite singular form of old swedish verb")
    private final String oldPreterite;

    @ApiModelProperty(value = "Preterite plural form of old swedish verb")
    private final String oldPreteritePlural;

    @ApiModelProperty(value = "Perfect participle form of old swedish verb")
    private final String oldPerfectParticiple;

    @ApiModelProperty(value = "The class the verb belongs to")
    private final String verbClass;
}

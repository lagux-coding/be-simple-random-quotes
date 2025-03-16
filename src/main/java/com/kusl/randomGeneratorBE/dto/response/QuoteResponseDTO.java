package com.kusl.randomGeneratorBE.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuoteResponseDTO {

    String content;
    String author;
    Set<String> tags;

}

package com.kusl.randomGeneratorBE.dto.convert;

import com.kusl.randomGeneratorBE.dto.response.QuoteResponseDTO;
import com.kusl.randomGeneratorBE.model.Quote;
import com.kusl.randomGeneratorBE.model.Tags;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuoteEntityToDtoConverter {

    private final ModelMapper modelMapper;

    public QuoteResponseDTO convertQuote(Quote quote) {
        QuoteResponseDTO quoteResponseDTO = modelMapper.map(quote, QuoteResponseDTO.class);
        Set<String> tags = quote.getTags().stream().map(Tags::getName).collect(Collectors.toSet());
        quoteResponseDTO.setTags(tags);
        return quoteResponseDTO;
    }
}

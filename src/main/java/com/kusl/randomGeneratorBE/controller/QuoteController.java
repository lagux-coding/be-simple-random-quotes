package com.kusl.randomGeneratorBE.controller;

import com.kusl.randomGeneratorBE.dto.ResponseCode;
import com.kusl.randomGeneratorBE.dto.ResponseData;
import com.kusl.randomGeneratorBE.dto.convert.QuoteEntityToDtoConverter;
import com.kusl.randomGeneratorBE.dto.response.QuoteResponseDTO;
import com.kusl.randomGeneratorBE.model.Quote;
import com.kusl.randomGeneratorBE.service.quoteService.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;
    private final QuoteEntityToDtoConverter quoteConvert;

    @GetMapping("/quotes")
    public ResponseData getQuotes(Pageable pageable) {

        Page<Quote> quotesPage = quoteService.getAllQuotes(pageable);

        if (quotesPage.isEmpty()) {
            return new ResponseData<>(ResponseCode.NOT_FOUND, null);
        }

        Page<QuoteResponseDTO> responsePage = quotesPage.map(quoteConvert::convertQuote);

        return new ResponseData<>(ResponseCode.SUCCESS, responsePage);
    }

    @GetMapping("/quote/random")
    public ResponseData getRandomQuote() {

        Quote quote = quoteService.getRandomQuote();
        QuoteResponseDTO response = quoteConvert.convertQuote(quote);

        return new ResponseData<>(ResponseCode.SUCCESS, response);
    }
}

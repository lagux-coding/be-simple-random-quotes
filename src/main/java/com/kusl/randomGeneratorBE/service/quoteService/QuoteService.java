package com.kusl.randomGeneratorBE.service.quoteService;

import com.kusl.randomGeneratorBE.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuoteService {

    Page<Quote> getAllQuotes(Pageable pageable);

    Quote getRandomQuote();
}

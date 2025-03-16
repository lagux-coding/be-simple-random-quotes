package com.kusl.randomGeneratorBE.service.quoteService;

import com.kusl.randomGeneratorBE.model.Quote;
import com.kusl.randomGeneratorBE.repository.QuoteRepository;
import com.kusl.randomGeneratorBE.service.quoteService.general.RedisService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final RedisService redisService;

    @Override
    public Page<Quote> getAllQuotes(Pageable pageable) {
        return quoteRepository.findAll(pageable);
    }

    @Override
    public Quote getRandomQuote() {
        return quoteRepository.findRandomQuote().orElseThrow(() -> new RuntimeException("No quotes found!"));
    }

//    public Quote getSmartRandomQuote() {
//        Quote randomQuote;
//
//        do {
//            randomQuote = getTimeBasedRandomQuote();
//        } while (redisService.isQuoteInCache(randomQuote.getId()));
//
//        redisService.addQuoteToCache(randomQuote.getId(), 10);
//
//        return randomQuote;
//    }

//    private Quote getTimeBasedRandomQuote() {
//        int hour = LocalTime.now().getHour();
//        System.out.println("DEBUG: Hour = " + hour);
//
//        if (hour >= 6 && hour < 12) {
//            return quoteRepository.getRandomQuoteByTag("motivation").orElseGet(this::getFallbackQuote);
//        } else if (hour >= 12 && hour < 18) {
//            return quoteRepository.getRandomQuoteByTag("love").orElseGet(this::getFallbackQuote);
//        } else {
//            return quoteRepository.getRandomQuoteByTag("philosophy").orElseGet(this::getFallbackQuote);
//        }
//    }

//    private Quote getTimeBasedRandomQuote() {
//        List<String> allTags = Arrays.asList("motivation", "love", "philosophy", "humor", "life", "success", "creativity", "nature", "friendship", "strength");
//        Random random = new Random();
//        String randomTag = allTags.get(random.nextInt(allTags.size()));
//
//        return quoteRepository.getRandomQuoteByTag(randomTag).orElseGet(this::getFallbackQuote);
//    }
//
//    private Quote getFallbackQuote() {
//        return quoteRepository.findRandomQuote().orElseThrow(() -> new RuntimeException("No quotes found!"));
//    }

}

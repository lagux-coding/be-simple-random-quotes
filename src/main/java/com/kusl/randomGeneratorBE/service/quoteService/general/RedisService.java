package com.kusl.randomGeneratorBE.service.quoteService.general;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RedisService {

    private final RedisTemplate<String, UUID> redisTemplate;

    private String getCacheKeyForToday() {
        return "quotes:seen:" + java.time.LocalDate.now();
    }

    public void addQuoteToCache(UUID quoteId, int maxSize) {
        String cacheKey = getCacheKeyForToday();
        redisTemplate.opsForSet().add(cacheKey, quoteId);
        redisTemplate.expire(cacheKey, 1, TimeUnit.DAYS);

        Set<UUID> cachedQuotes = redisTemplate.opsForSet().members(cacheKey);
        if (cachedQuotes != null && cachedQuotes.size() > maxSize) {
            UUID oldest = cachedQuotes.iterator().next();
            redisTemplate.opsForSet().remove(cacheKey, oldest);
        }
    }

    public boolean isQuoteInCache(UUID quoteId) {
        return Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(getCacheKeyForToday(), quoteId));
    }
}

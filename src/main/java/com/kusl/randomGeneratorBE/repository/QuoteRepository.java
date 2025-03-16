package com.kusl.randomGeneratorBE.repository;

import com.kusl.randomGeneratorBE.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, UUID> {
    Optional<Quote> findById(UUID id);

    Page<Quote> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Quote> findRandomQuote();
//
//    @Query(value = """
//                SELECT q.* FROM quotes q
//                JOIN quote_tags qt ON q.quote_id = qt.quote_id
//                JOIN tags t ON qt.tag_id = t.id
//                WHERE t.name = :tag
//                ORDER BY RANDOM()
//                LIMIT 1
//            """, nativeQuery = true)
//    Optional<Quote> getRandomQuoteByTag(@Param("tag") String tag);
}

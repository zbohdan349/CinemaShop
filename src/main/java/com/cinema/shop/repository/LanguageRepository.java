package com.cinema.shop.repository;

import com.cinema.shop.model.Language;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends PagingAndSortingRepository<Language,Integer> {
}

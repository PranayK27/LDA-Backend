package com.example.ldabackend.repository;

import com.example.ldabackend.model.TechnologyList;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<TechnologyList, Long> {

}

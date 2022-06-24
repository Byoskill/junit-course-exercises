package com.byoskill.training.junit.realapp.junitrealapp.infra.h2support;

import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface GenreJpaRepository extends CrudRepository< Genre, String> {
    Optional<Genre> findByLabel(String label);
}

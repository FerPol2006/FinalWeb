package com.upiiz.ajax.repositories;

import com.upiiz.ajax.models.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {
    Optional<Aspirante> findByEmail(String email);
    boolean existsByEmail(String email);
}

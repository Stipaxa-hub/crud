package com.invertor.crud.repository;

import com.invertor.crud.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findById(Long id);
    Optional<Brand> findByName(String name);
}

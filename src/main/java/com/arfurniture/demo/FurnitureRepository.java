package com.arfurniture.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    List<Furniture> findByHomeId(String homeId);
}
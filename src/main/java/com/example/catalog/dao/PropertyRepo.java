package com.example.catalog.dao;

import com.example.catalog.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Properties, Long> {
}

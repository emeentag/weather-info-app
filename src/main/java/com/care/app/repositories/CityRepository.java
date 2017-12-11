package com.care.app.repositories;

import com.care.app.entities.dao.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CityRepository
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
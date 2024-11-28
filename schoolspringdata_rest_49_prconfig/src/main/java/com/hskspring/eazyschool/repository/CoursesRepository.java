package com.hskspring.eazyschool.repository;

import com.hskspring.eazyschool.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@RepositoryRestResource(exported = false) this will stop REST API from exporting
@RepositoryRestResource(path = "courses")// to prevent HAL explorer from converting courses path to courseses
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

    /*Spring Data Jpa allows us to apply sorting by adding the OrderBy keyword
    to the method name along with the property name sort direction (Asc or Desc).**/
    List<Courses> findByOrderByNameDesc();

    /*The Asc keyword is optional as OrderBy, by default,
    sorts the results in the ascendin  N g order.**/
    List<Courses> findByOrderByName();
}

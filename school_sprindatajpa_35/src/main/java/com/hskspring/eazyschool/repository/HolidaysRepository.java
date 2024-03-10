package com.hskspring.eazyschool.repository;

import com.hskspring.eazyschool.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {
// we change class to interface and extend with CrudRepository from Spring-data-jpa

}

package com.koksalmis.springjpademo.repository;

import com.koksalmis.springjpademo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
package com.koksalmis.springjpademo.repository;

import com.koksalmis.springjpademo.models.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
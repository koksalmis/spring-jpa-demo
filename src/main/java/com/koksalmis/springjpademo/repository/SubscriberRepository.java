package com.koksalmis.springjpademo.repository;

import com.koksalmis.springjpademo.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

}
package com.koksalmis.springjpademo.repository;

import com.koksalmis.springjpademo.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
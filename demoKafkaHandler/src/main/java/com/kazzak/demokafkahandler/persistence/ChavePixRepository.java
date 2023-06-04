package com.kazzak.demokafkahandler.persistence;

import com.kazzak.demokafkahandler.persistence.entity.ChavePixEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChavePixRepository extends JpaRepository<ChavePixEntity, Long> {
}

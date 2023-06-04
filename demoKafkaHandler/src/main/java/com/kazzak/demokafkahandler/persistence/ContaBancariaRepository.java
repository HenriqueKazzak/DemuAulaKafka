package com.kazzak.demokafkahandler.persistence;

import com.kazzak.demokafkahandler.persistence.entity.ContaBancariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancariaEntity, Long> {
}

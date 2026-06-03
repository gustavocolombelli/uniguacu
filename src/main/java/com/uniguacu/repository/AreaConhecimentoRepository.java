package com.uniguacu.repository;

import com.uniguacu.model.AreaConhecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Long> {
}
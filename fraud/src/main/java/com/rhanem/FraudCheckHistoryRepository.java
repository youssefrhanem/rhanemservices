package com.rhanem;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}

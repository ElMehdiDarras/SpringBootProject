package com.project.jee.darrasjee.repository;

import com.project.jee.darrasjee.domain.PlacedOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PlacedOrder, Long> {}

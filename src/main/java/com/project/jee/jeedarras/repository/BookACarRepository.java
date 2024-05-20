package com.project.jee.jeedarras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jee.jeedarras.entity.BookACar;

import java.util.List;

@Repository

public interface BookACarRepository extends JpaRepository<BookACar,Long> {
    List<BookACar> findAllByUserId(Long userId);
}

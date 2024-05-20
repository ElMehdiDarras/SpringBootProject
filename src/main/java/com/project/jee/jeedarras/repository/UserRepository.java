package com.project.jee.jeedarras.repository;


import com.project.jee.jeedarras.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jee.jeedarras.entity.User;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findFirstByEmail(String email);

    User findByUserRole(UserRole userRole);
}
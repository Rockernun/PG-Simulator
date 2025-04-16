package com.pg.simulation.pg_simulation.repository;

import com.pg.simulation.pg_simulation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

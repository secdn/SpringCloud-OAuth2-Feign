package com.ulegal.authservice.repository;

import com.ulegal.authservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author secdn
 * @create 2018-08-22
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>  {
}

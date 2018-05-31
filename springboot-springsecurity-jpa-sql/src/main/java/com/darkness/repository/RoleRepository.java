package com.darkness.repository;

import com.darkness.entity.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author tranguyenvan
 * @version 1.0.0
 * @since 1.0.0
 * @description
 * */
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}

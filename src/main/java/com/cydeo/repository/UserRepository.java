package com.cydeo.repository;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}

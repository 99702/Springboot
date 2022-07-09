package com.auth.auth.repository;

import com.auth.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u from User u where u.username = :username")
    User fetchByUserName(String username);

}

package com.example.qu.repository;

import com.example.qu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;



@Repository
 public interface UserRepository extends JpaRepository<User, Long> {
    // jpa query
     List<User> findByNameContainingIgnoreCase(String name); //find by name
     List<User> findByEmailIgnoreCase(String email); //find by email

     List<User> findByEnabled(Boolean enabled); // find if user is enabled or not

     List<User> findByRole(String role);


// JPQL queries
    @Query(value="SELECT u FROM User u where u.name = :name")
     List<User> fetchByNameExact(String name);

    @Query(value="SELECT u FROM User u where u.email = :email")
     User fetchByEmailExact(String email);

    @Query(value="SELECT u FROM User u where u.mobile = :mobile")
    User fetchByMobileExact(String mobile);

    @Query(value="SELECT u from User u where u.enabled = :enabled")
    List<User> fetchByEnabled(Boolean enabled);

    @Query(value="SELECT u FROM User u where u.dob= :dob")
    List<User> fetchBydobExact(Date dob);

    @Query(value="SELECT u from User u where u.role = :role")
    List<User> fetchByRoleExact(String role);

//    @Query("SELECT COUNT(u) from User u UNION SELECT count(u) FROM User u where u.role=ADMIN UNION SELECT count(u) from User where u.enabled = true")
//    Map<String, String> fetchStatistics();

     @Query("SELECT COUNT(u.id) from User u")
     Long fetchTotalUser();

     @Query("SELECT COUNT(u) from User u where u.enabled=True")
     Long fetchTotalEnabledUser();

    @Query("SELECT COUNT(u) from User u where u.enabled=False")
     Long fetchTotalNotEnabledUser();

    @Query("SELECT COUNT(u) from User u where u.role='ADMIN'")
    Long fetchTotalADMIN();

    @Query("SELECT COUNT(u) from User u where u.role='USER'")
    Long fetchTotalUSER();


}

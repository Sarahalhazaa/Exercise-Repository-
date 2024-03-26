package com.example.exerciserepository.Repository;

import com.example.exerciserepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByEmail(String email);
    List<User> findUsersByRole(String role);
    @Query("select a from User a where a.age>=?1")
    List<User> findUsersByAge(Integer age);

    @Query("select a from User a where a.userName=?1 and a.password=?2 ")
    User checkuser(String userName , String password);
}

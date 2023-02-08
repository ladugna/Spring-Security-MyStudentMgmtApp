package edu.miu.cs.cs425.studentmgmt.repository;

import edu.miu.cs.cs425.studentmgmt.model.Role;
import edu.miu.cs.cs425.studentmgmt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
   Optional<User> findByUsername(String username);
//
//    @Query(value = "select distinct r from Role r join r.users u where u.userId=:userId")
    List<Role> findRolesByUserId(Integer userId);


}

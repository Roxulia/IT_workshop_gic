package com.gicws.day25.Repository;

import com.gicws.day25.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    List<User> findByEmailOrderByRegistrationDateDesc(String email);
    //List<User> selectAllByOrderByRegistrationDateDesc();

    @Query("SELECT u FROM User u WHERE u.email LIKE %?1%")
    List<User> findByEmailContainingA(String email);

//    @CustomQuery("SELECT u FROM User u WHERE u.email LIKE %?1%")
//    List<User> findByEmailContainingB(String email);
//    @JPQL("SELECT u FROM User u WHERE u.email LIKE %?1%")
//    List<User> findByEmailContainingC(String email);
//    @Repository("SELECT u FROM User u WHERE u.email LIKE %?1%")
//    List<User> findByEmailContainingD(String email);

}

package com.tf.Repository;

import com.tf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by t on 2016/10/23.
 */
public interface UserRepo extends JpaRepository<User,Long>,JpaSpecificationExecutor<User>{
//    @Modifying
//    @Transactional
//    @Query("update User u set u.password=?1 where u.name=?2")
//    int setPwd(String pwd,String name);
//    @Query("select u from User u")
//    List<User> findAll();


    User findByName(String name);
}

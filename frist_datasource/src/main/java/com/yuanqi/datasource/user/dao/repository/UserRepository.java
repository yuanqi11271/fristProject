package com.yuanqi.datasource.user.dao.repository;

import com.yuanqi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: yq
 * @Date：2019/5/10 15:48
 * @Describe:
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

package com.yuanqi.datasource.commdity.repository;

import com.yuanqi.domain.commdity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: yq
 * @Date：2019/4/18 15:53
 */
@Repository
public interface CommodityRepository extends JpaRepository<Commodity,Long> {
}

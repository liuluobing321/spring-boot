package com.llb.repository;

import com.llb.entity.StoreES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: liuluobing
 * @Description:
 * @Date: 2019/9/28 15:49
 */
public interface StoreESRepository extends ElasticsearchRepository<StoreES, String> {
}

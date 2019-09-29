package com.llb.repository;

import com.llb.entity.AttendanceRecord;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: liuluobing
 * @Description:
 * @Date: 2019/9/28 17:05
 */
public interface AttendanceRecordRepository extends ElasticsearchRepository<AttendanceRecord, String> {
}

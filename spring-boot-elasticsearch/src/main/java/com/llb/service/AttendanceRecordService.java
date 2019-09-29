package com.llb.service;

import com.llb.entity.AttendanceRecord;

import java.util.List;

/**
 * @Author: liuluobing
 * @Description:
 * @Date: 2019/9/28 17:16
 */
public interface AttendanceRecordService {
	List<AttendanceRecord> findUserByDate();
	AttendanceRecord findUser();
}

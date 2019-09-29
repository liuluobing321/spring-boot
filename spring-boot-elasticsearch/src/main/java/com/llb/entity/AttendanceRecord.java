package com.llb.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author: liuluobing
 * @Description:
 * @Date: 2019/9/28 16:57
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "att_common_bussiness_attendance", type = "attendance_record")
public class AttendanceRecord {
	@Id
	private String id;
	private String date;
	private Integer userId;
	private String dayType;
	private TimeResult timeResult;
	private LocationResult locationResult;
}

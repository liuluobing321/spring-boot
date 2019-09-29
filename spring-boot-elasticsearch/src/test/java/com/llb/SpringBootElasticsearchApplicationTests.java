package com.llb;

import com.llb.service.AttendanceRecordService;
import com.llb.service.StoreESService;








import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticsearchApplicationTests {

	@Autowired
	StoreESService storeESService;
	@Autowired
	AttendanceRecordService attendanceRecordService;

	@Test
	public void contextLoads() {
		System.out.println(storeESService.findStore());
	}

	@Test
	public void findUserByDate() {
		System.out.println(attendanceRecordService.findUserByDate());
	}


}

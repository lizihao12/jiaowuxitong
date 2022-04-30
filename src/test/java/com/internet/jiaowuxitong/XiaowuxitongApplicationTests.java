package com.internet.jiaowuxitong;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class JiaowuxitongApplicationTests {

	@Test
	void contextLoads() {
		String s = "50000400000018237X";
		String substring = s.substring(12);
		System.err.println(substring);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		System.out.println(simpleDateFormat.format(date));
	}

}

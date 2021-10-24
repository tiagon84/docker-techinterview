package com.acme.techinterview;

import com.acme.techinterview.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = WebConfig.class)
class TechinterviewApplicationTests {

	@Test
	void contextLoads() {
	}

}

package com.helendemo.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.logging.log4j.*;

@SpringBootTest
class HelendemoApplicationTests {

	Logger logger = LogManager.getLogger("HelloWorld1");
	@Test
	void contextLoads() {
		logger.info("Hello1, World1!");
	}

}

package io.github.steliospaps.ighackathon.realitimecomponent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.sivalabs.localstack.EnableLocalStack;

@EnableLocalStack
@SpringBootTest(properties = "spring.profiles.active=dev")
class RealitimecomponentApplicationTests {

	@Test
	void contextLoads() {
	}

}

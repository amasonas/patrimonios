package com.navita.exam;

import com.navita.exam.anagramnumber.AnagramNumberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ExamApplicationTests {
	@Autowired
	private AnagramNumberService anagramNumberService;

	@Test
	public void mustReturnMax() {
		Assertions.assertThat(anagramNumberService.findMaxPossible(1596))
				.isEqualTo(9651);
	}

	@Test
	public void mustReturnNegative() {
		Assertions.assertThat(anagramNumberService.findMaxPossible(1000001))
				.isEqualTo(-1);
	}

}

package com.care.app.integration;

import com.care.app.entities.dto.ApiDTO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppApplicationTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void testOWN() {
		ResponseEntity<ApiDTO> response = template.getForEntity(
				"http://api.openweathermap.org/data/2.5/weather?q=Istanbul&units=metric&appid=c171c400bd485abf40143f6a1e4cc726",
				ApiDTO.class);

		Assert.assertEquals("Istanbul", response.getBody().getCityName());
	}

}

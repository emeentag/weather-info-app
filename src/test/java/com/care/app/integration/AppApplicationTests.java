package com.care.app.integration;

import com.care.app.entities.dto.ApiDTO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class AppApplicationTests {

	@Value(value = "${owm.api.key}")
	private String API_KEY;

	@Value(value = "${owm.api.url}")
	private String API_URL;

	@Value(value = "${owm.api.units}")
	private String API_UNITS;

	@Test
	public void testOWM() {
		String weatherInfo = UriComponentsBuilder.fromUriString(API_URL).queryParam("appid", API_KEY)
				.queryParam("units", API_UNITS).queryParam("q", "Istanbul").build().toString();
		TestRestTemplate template = new TestRestTemplate();

		ResponseEntity<ApiDTO> response = template.getForEntity(weatherInfo, ApiDTO.class);

		Assert.assertEquals("Istanbul", response.getBody().getCityName());
	}

}

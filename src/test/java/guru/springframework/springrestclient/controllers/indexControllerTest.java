package guru.springframework.springrestclient.controllers;

import guru.springframework.springrestclient.services.ApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
class indexControllerTest {

	@Autowired
	WebApplicationContext webApplicationContext;

	WebTestClient webTestClient;

	@Autowired
	ApiService apiService;


	@BeforeEach
	void setUp() {
		webTestClient = MockMvcWebTestClient.bindToApplicationContext(webApplicationContext).build();
	}

	@Test
	public void getIndex() {

		webTestClient.get().uri("/")
				.exchange()
				.expectStatus().isOk();
	}

	@Test
	public void getPeople() throws Exception {

		EntityExchangeResult<String> result = webTestClient.get().uri("/people")
				                                      .exchange()
				                                      .expectStatus().isOk()
				                                      .expectBody(String.class)
				                                      .returnResult();

		MockMvcWebTestClient
				.resultActionsFor(result)
				.andExpect(model().attributeExists("persons"));

	}
}
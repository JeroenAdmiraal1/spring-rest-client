package guru.springframework.springrestclient.services;

import guru.springframework.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiServiceImplTest {

	@Autowired
	ApiService apiService;

	@BeforeEach
	void setUp() {
	}

	@Test
	void getPersons() {

		List<Person> people = apiService.getPersons();
		Person person = people.get(2);

		assertEquals("Samantha", person.getUsername());
		assertEquals(people.size(), 10);
	}

	@Test
	void getFluxOfPersons() {

		Flux<Person> people = apiService.getFluxOfPersons();
		List<Person> personList = people.collectList().block();

		Person person = personList.get(2);

		assertEquals("Samantha", person.getUsername());
	}
}
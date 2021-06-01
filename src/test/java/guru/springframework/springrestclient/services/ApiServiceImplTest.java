package guru.springframework.springrestclient.services;

import guru.springframework.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

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

		ArrayList<Person> people = apiService.getPersons();

		assertEquals(people.size(), 10);
	}
}
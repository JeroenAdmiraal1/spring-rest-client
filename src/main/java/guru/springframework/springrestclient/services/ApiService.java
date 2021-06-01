package guru.springframework.springrestclient.services;

import guru.springframework.domain.Person;

import java.util.ArrayList;

public interface ApiService {

	ArrayList<Person> getPersons();
}

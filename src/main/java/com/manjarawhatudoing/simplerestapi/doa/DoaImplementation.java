package com.manjarawhatudoing.simplerestapi.doa;

import com.manjarawhatudoing.simplerestapi.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("initial")

public class DoaImplementation implements PersonDoa{
    public static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public Person fetchPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void updatePerson(Person person) {
        Person px = DB.stream().filter(p -> p.getId().equals(person.getId())).findFirst().orElse(null);
        if (px != null) px.setName(person.getName());
    }
}

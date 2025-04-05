package com.manjarawhatudoing.simplerestapi.doa;

import com.manjarawhatudoing.simplerestapi.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDoa {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    public List<Person> getAllPeople();

}

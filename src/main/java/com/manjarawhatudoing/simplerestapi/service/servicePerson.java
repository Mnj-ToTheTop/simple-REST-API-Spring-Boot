package com.manjarawhatudoing.simplerestapi.service;

import com.manjarawhatudoing.simplerestapi.doa.PersonDoa;
import com.manjarawhatudoing.simplerestapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class servicePerson{

    private final PersonDoa personDoa;

    @Autowired
    public servicePerson(@Qualifier("initial") PersonDoa personDoa) {
        this.personDoa = personDoa;
    }

    public int addPerson(Person person){
        personDoa.insertPerson(person);
        return 0;
    }

    public List<Person> fetchAll(){
        return personDoa.getAllPeople();
    }

    public Person getPerson(UUID id){
        return personDoa.fetchPersonById(id);
    }

    public void updatePersonDetails(Person person){
        personDoa.updatePerson(person);
    }
}

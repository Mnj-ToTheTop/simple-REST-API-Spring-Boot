package com.manjarawhatudoing.simplerestapi.api;

import com.manjarawhatudoing.simplerestapi.model.Person;
import com.manjarawhatudoing.simplerestapi.service.servicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/requ/")
@RestController
public class personController {

    private final servicePerson servicePerson;

    @Autowired
    public personController(servicePerson servicePerson) {
        this.servicePerson = servicePerson;
    }

    @PostMapping
    public void insertPeople(@RequestBody Person person){
        servicePerson.addPerson(person);
    }

    @GetMapping
    public List<Person> getPeople(){
        return servicePerson.fetchAll();
    }
}

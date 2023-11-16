package com.Jurson.Dunkos.CONTROLLERS;


import com.Jurson.Dunkos.ENTITY.Person;
import com.Jurson.Dunkos.SERVICES.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("api/v1/leute")

public class PersonController {

    private PersonService personService;
    @Autowired

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    //View ALL

    @GetMapping
    public List<Person>geAllPerson(){

        return personService.getAllPerson();
    }
   // Create new person
   @PostMapping("create")
 public void createNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);

    }

    // getting a person by id
@GetMapping("get/id/{id}")

    public void  lookPersonbyid(@PathVariable Integer id) {
        personService.getPersonbyid(id);
    }


    //updating an exsisting Person
    @PutMapping("update/id/{id}")
    public  void changePersonCredentials(@PathVariable Integer id ,@RequestBody Person personDetails){

        personService.updatePerson(id, personDetails);

    }
    // delete An exsisting Person
    @DeleteMapping("delete/id/{id}")
    public void removePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }



    }


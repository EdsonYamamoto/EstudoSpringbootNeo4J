package com.example.demo.controller;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;
import io.swagger.annotations.Api;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@Api(value = "person", description = "Cotroladora de teste")
@RequestMapping("/Person")
@EnableNeo4jRepositories
public class PersonController {

    private PersonRepository personRepository;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(
            value = "/RetornaPerson",
            method = RequestMethod.GET
    )
    public PersonModel RetornaPerson(@RequestBody PersonModel teste)
    {
        return teste;
    }

    @RequestMapping(
            value = "/SavePerson",
            method = RequestMethod.POST
    )
    public String SavePerson(/*@RequestBody*/ PersonModel teste)
    {
        System.out.println(teste);
        personRepository.save(teste);
        /*
        try {

        }catch (Exception e){

            return "Deu ruim";
        }finally{

            return "Era esperado ter salvo no banco";
        }*/
        return "Era esperado ter salvo no banco";

    }

    @RequestMapping(
            value = "/GetPerson/{ID}",
            method = RequestMethod.GET
    )
    public PersonModel GetPerson(
            @PathParam("ID")  Long id
    ) {
        return personRepository.findById(id).get();
    }

}

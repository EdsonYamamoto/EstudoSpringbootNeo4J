package com.example.demo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@Api(value = "usuario", description = "Cotroladora de teste")
public class TesteController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(value = "/passandoUmaString", method = RequestMethod.GET)
    public String passandoString(String teste) {
        return teste;
    }

    @RequestMapping(value = "/passandoUmInt/{teste}", method = RequestMethod.GET)
    public String passandoInt(
        @PathParam("teste") int teste
    ) {
        return teste+" ";
    }

    @RequestMapping(value = "/passandoMongoDB/{ID}", method = RequestMethod.GET)
    public String passandoMongoDB(
            @RequestParam("ID") String id
    ) {
        System.out.println(id);

        String retorno="";

        return retorno;
    }
}

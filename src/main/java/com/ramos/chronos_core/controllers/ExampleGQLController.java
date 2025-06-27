package com.ramos.chronos_core.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ExampleGQLController {

    @QueryMapping
    public String greeting() {
        return "Hello.";
    }

    @MutationMapping
    public String greet(@Argument String name) {
        return "Hello " + name + ".";
    }
}

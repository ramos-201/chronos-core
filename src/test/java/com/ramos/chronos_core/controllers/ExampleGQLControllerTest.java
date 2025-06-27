package com.ramos.chronos_core.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GraphQlTest(controllers = ExampleGQLController.class)
class ExampleGQLControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void testGreetingQuery() {
        String result = graphQlTester.document("query { greeting }")
                .execute()
                .path("greeting")
                .entity(String.class)
                .get();

        assertEquals("Hello.", result);
    }

    @Test
    void testGreetMutation() {
        String result = graphQlTester.document("mutation { greet(name: \"John\") }")
                .execute()
                .path("greet")
                .entity(String.class)
                .get();

        assertEquals("Hello John.", result);
    }
}

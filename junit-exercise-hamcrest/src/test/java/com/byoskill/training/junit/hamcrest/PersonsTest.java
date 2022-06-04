package com.byoskill.training.junit.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PersonsTest {
    
    @Test
    @DisplayName("Find two people with the same age")
    public void testFind2PeopleWithSameAge() {
        final Map<Integer, Person> personsPerAge = Arrays.stream(Persons.persons)
                                                   .collect(Collectors.toMap(Person::getAge, Function.identity()));
        
    }



    @Test
    @DisplayName("Check that the person is named John")
    public void testPeopleWithNameJohn() {
        Person person = Persons.persons[0];
        

    }


    @Test
    @DisplayName("Find people that have male gender and age > 30")
    public void findPeopleMaleAbove30() {
        Person person = Persons.persons[0];


    }

}
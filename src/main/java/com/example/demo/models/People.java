package com.example.demo.models;

import java.util.Arrays;
import java.util.List;

public abstract class People<PersonType extends Person> implements Iterable<PersonType>  {

    private List<PersonType> personList;

    People(List<PersonType> personList){
        this.personList = personList;
    }

    People(PersonType...persons) {
        personList = Arrays.asList(persons);
    }

    public void add(PersonType person){
        personList.add(person);
    }

    public void remove(PersonType person){
        personList.remove(person);
    }

    public Integer getSize(){
        return personList.size();
    }

    public void clear(){
        personList.clear();
    }

    public void addAll(Iterable<? extends PersonType> people){
        people.forEach(personList::add);
    }

    public PersonType findById(Long id){
        for (PersonType personType : personList) {
            if (personType.getId().equals(id))
                return personType;
        }
        return null;
    }

    public List<PersonType> findAll(){
        return personList;
    }
}


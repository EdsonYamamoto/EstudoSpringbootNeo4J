package com.example.demo.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;


import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@NoArgsConstructor
public class PersonModel {

    @Id @GeneratedValue private Long id;
    private String name;

    public PersonModel(String name) {
        this.name = name;
    };



    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
    public Set<PersonModel> teammates;

    public void worksWith(PersonModel person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    public String toString() {

        return this.name + "'s teammates => "
                + Optional.ofNullable(this.teammates).orElse(
                Collections.emptySet()).stream()
                .map(PersonModel::getName)
                .collect(Collectors.toList());
    }



    @ApiModelProperty(position = 1, required = true, value = "primeiro nome")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    private String firstName;
    private String lastName;
    @ApiModelProperty(position = 2, required = true, value = "primeiro nome")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @ApiModelProperty(position = 3, required = true, value = "ultimo nome")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    */
}

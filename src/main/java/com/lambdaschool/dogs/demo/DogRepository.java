package com.lambdaschool.dogs.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public interface DogRepository extends JpaRepository<Dog, Long>{

    @Component
    class EmployeeResourceAssembler implements ResourceAssembler<Dog, Resource<Dog>>
    {
        @Override
        public Resource<Dog> toResource(Dog dog)
        {
            return new Resource<Dog>(dog,
                    linkTo(methodOn(DogController.class).findOne(dog.getId())).withSelfRel(),
                    linkTo(methodOn(DogController.class).allW()).withRel("dogs"));

        }


    }
}
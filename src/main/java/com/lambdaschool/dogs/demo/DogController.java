package com.lambdaschool.dogs.demo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController

public class DogController {
    private final DogRepository dogrepos;
    private final DogResourceAssembler assembler;

    public DogController(DogRepository dogrepos, DogResourceAssembler assembler){
        this.dogrepos = dogrepos;
        this.assembler = assembler;
    }
    @GetMapping("/employees")
    public Resources<Resource<Dog>> all()
    {
        List<Resource<Dog>> dogs = dogrepos.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(dogs, linkTo(methodOn(DogController.class).all()).withSelfRel());
    }

    @GetMapping("/dogs/{id}") // /dogs/4
    public Resource<Dog> findOne(@PathVariable Long id)
    {
        Dog foundEmp = dogrepos.findById(id)
                .orElseThrow(() -> new DogNotFoundException(id));

        return assembler.toResource(foundEmp);
    }



    @DeleteMapping("/dogs/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id)
    {
        dogrepos.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

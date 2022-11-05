package org.kevin.demo0212.controller;

import org.kevin.demo0212.model.mongo.Customer;
import org.kevin.demo0212.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin.Z
 * @version 2020-04-04
 */
@RestController
public class MongoController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/mongodb/tester")
    public String mongo(){
        repository.deleteAll();

        repository.save(new Customer("xiao", "zng"));
        repository.save(new Customer("edward", "zng"));
        repository.save(new Customer("kevin", "zng"));

        System.out.println("Find first xiao:");
        System.out.println(repository.findByFirstName("xiao"));


        System.out.println("find last name zng");
        for(Customer c:repository.findByLastName("zng")){
            System.out.println(c);
        }


        return "hello mongoDB";
    }

    @GetMapping("/mongodb/findAll")
    public String findAll(){
        for(Customer c:repository.findAll()){
            System.out.println(c);
        }

        return "find all from mongodb";
    }
}

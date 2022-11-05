package org.kevin.demo0212.model.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Kevin.Z
 * @version 2020-04-04
 */
@Data
public class Customer {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer(){}

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}

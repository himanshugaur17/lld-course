package oop.inheritancevscomp;

import java.util.ArrayList;

public class CustomerGroupInheritance extends ArrayList<Customer> {

}

class Customer {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

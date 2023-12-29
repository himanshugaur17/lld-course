package oop.inheritancevscomp;

public class InheritanceSim {
    public static void main(String[] args) {
        CustomerGroupInheritance cgI = new CustomerGroupInheritance();
        /*
         * Why inheritance is bad in the above case:
         * 1. We are implementing ArrayList, an implementation but CustomerGroup is not
         * an implementation
         * 2. cgI.add() actually exposes the implementation details
         * 3. The implementation details should be invisible at the domain level.
         */
        cgI.add(new Customer(0, "Himanshu"));
    }
}

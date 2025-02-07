package com.ap.pre.designpatterns.factory;

public class EmployeeFactoryMain {

    public static void main(String[] args) {
        
        Employee emp = EmployeeFactory.getEmployeeObject(EmployeeEnum.HR);

        Employee emp2 = EmployeeEnum.DEVELOPER.getEmployee();
        System.out.println(emp.getSalary());

        System.out.println(emp2.getSalary());
    }

}

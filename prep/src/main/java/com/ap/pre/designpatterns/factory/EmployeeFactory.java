package com.ap.pre.designpatterns.factory;

public class EmployeeFactory {

    private String name ;
    private String surname;
    private String name1 ;
    private String surname1;

    public static Employee getEmployeeObject(EmployeeEnum empType ){

        if (null != empType) switch (empType) {
            case HR:
                return new HumanResourceEmp();
            case QA:
                return new QualityAssuranceEmp();
            case DEVELOPER:
                return new Developer();
            default:
                break;
        }

        return null;

    }
    
}

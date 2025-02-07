package com.ap.pre.designpatterns.factory;

public enum EmployeeEnum {

    HR {
        @Override
        Employee getEmployee() {
          return new HumanResourceEmp();
        }

        @Override
        int salary() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'salary'");
        }
    },
    QA {
        @Override
        Employee getEmployee() {
          return new QualityAssuranceEmp();
        }

        @Override
        int salary() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'salary'");
        }
    },
    DEVELOPER {
        @Override
        Employee getEmployee() {
           return new Developer();
        }

        @Override
        int salary() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'salary'");
        }
    };

    abstract int salary();

    abstract Employee getEmployee();
    
}

package service;

import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final int SIZE = 5;
    private final Employee[] employees;

    public EmployeeService() {
        this.employees = new Employee[SIZE];

    }

    public Employee addEmployee(String name,
                                String secondName) {
        Employee employee = new Employee(name, secondName);
        int indexForAdd = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null & indexForAdd == -1) {
                indexForAdd = i;
            }
            if (employee.equals(employees[i])) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        if (indexForAdd == -1) {
            throw new EmployeeStorageIsFullException();
        }
        return employees[indexForAdd] = employee;
    }

    public Employee removeEmployee(String name,
                                   String secondName) {
        Employee employee = new Employee(name, secondName);
        for (int i = 0; i < employees.length; i++) {
            if (employee.equals(employees[i])) {
                employees[i] = null;
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String name,
                                 String secondName) {
        Employee employee = new Employee(name, secondName);
        for (int i = 0; i < employees.length; i++) {
            if (employee.equals(employees[i])) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

}

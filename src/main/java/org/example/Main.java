package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static Map<Integer, Employee> employeeMap;

    public static List<Employee> duplicatedEmployees;


    public static List<Employee> findDuplicates(List<Employee> employees){
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            }
            else {employeeMap.put(employee.getId(),employee);}
        }
        return duplicatedEmployees;

    };

    public static Map<Integer,Employee> findUniques(List<Employee> employees){      Iterator<Employee> iterator = employees.iterator();
        employeeMap = new HashMap<>();

        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(), employee);
            }

        }
        return employeeMap;
    };

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> justUniques = new LinkedList<>(uniques.values());
        justUniques.removeAll(duplicates);
        return justUniques;
    };

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(123456,"ahmet", "mümtaz"));
        employees.add(new Employee(123456,"ahmet", "mümtaz"));
        employees.add(new Employee(123457,"erinç", "erdemli"));
        employees.add(new Employee(123458,"ali", "veli"));
        employees.add(new Employee(123459,"mahmure", "devran"));

        System.out.println(employees);
        System.out.println(WordCounter.calculatedWord());

    }
}
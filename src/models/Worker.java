package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Worker {
    private String name;
    private String surname;
    private String functionOfWorker[];//0 - монтажник,1 - каменоломщик,2 - разработчик
    private int salary;


    public Worker(String name, String surname, String[] functionOfWorker, int salary) {
        this.name = name;
        this.surname = surname;
        this.functionOfWorker = functionOfWorker;
        this.salary = salary;
        functionOfWorker = new String[3];
        functionOfWorker[0] = new String("монтажник");
        functionOfWorker[1] = new String("каменоломщик");
        functionOfWorker[2] = new String("разработчик");
        System.out.println(functionOfWorker);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String[] getFunctionOfWorker() {
        return functionOfWorker;
    }

    public void setFunctionOfWorker(String[] functionOfWorker) {
        this.functionOfWorker = functionOfWorker;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return salary == worker.salary && name.equals(worker.name) && surname.equals(worker.surname) && Arrays.equals(functionOfWorker, worker.functionOfWorker);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, salary);
        result = 31 * result + Arrays.hashCode(functionOfWorker);
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", functionOfWorker=" + Arrays.toString(functionOfWorker) +
                ", salary=" + salary +
                '}';
    }





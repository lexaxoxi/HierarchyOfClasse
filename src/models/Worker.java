package models;

import java.util.Objects;

public class Worker {
    private String Name;
    private String Surname;
    private String FunctionOfWorker;
    private int Salary;


    public Worker(String name, String surname, String functionOfWorker, int salary) {
        Name = name;
        Surname = surname;
        FunctionOfWorker = functionOfWorker;
        Salary = salary;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    //замена цифр должностей из файла на название должностей в выводе на экран
    public String getFunctionOfWorker()  {
        String newFunction0 = "монтажник";
        String newFunction1 = "каменоломщик";
        String newFunction2 = "разработчик";
        boolean tempString;
        if (tempString = FunctionOfWorker.equals("0")) {
            FunctionOfWorker = newFunction0;
        }

        if (tempString = FunctionOfWorker.equals("1")) {
            FunctionOfWorker = newFunction1;
        }

        if (tempString = FunctionOfWorker.equals("2")) {
            FunctionOfWorker = newFunction2;
        }

        return FunctionOfWorker;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;


    }

   public void setFunctionOfWorker(String functionOfWorker) {
       FunctionOfWorker = functionOfWorker;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Salary == worker.Salary && Name.equals(worker.Name) && Surname.equals(worker.Surname) && FunctionOfWorker.equals(worker.FunctionOfWorker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Surname, FunctionOfWorker, Salary);
    }

    @Override
    public String toString() {
        return "" +
                "Имя: " + Name + '\'' +
                ", Фамилия: " + Surname + '\'' +
               ", Должность:'" + getFunctionOfWorker() + '\'' +
                ", Заработная плата: " + Salary +
                "'\n'";
    }
}
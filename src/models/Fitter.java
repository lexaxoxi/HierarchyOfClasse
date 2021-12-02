package models;

public class Fitter extends Worker {
    private String department[];

    public Fitter(String name, String surname, String[] functionOfWorker, int salary, String[] department) {
        super(name, surname, functionOfWorker, salary);
        this.department = department;
        department = new String[2];
        department[0] = "цех";
        department[1] = "склад";
        System.out.println(department);
    }

}
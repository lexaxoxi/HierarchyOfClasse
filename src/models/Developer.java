package models;

public class Developer extends Worker {
    private String language;
    private String institute;

    public Developer(String name, String surname, String functionOfWorker, int salary, String language, String institute) {
        super(name, surname, functionOfWorker, salary);
        this.language = language;
        this.institute = institute;
    }
}

package models;

public class Quarry extends Worker {

   private String laws[];

    public Quarry(String name, String surname, String[] functionOfWorker, int salary, String[] laws) {
        super(name, surname, functionOfWorker, salary);
        this.laws = laws;
        laws = new String[3];
        laws[0] = new String("First Newton's law");
        laws[1] = new String ("Second Newton's law");
        laws[2] = new String ("Third Newton's law");
        System.out.println(laws);
    }


}



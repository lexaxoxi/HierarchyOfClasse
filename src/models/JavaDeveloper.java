package models;

public class JavaDeveloper extends Developer{
   int experienceOfJava;
   String ide;

   public JavaDeveloper(String name, String surname, String functionOfWorker, int salary, String language, String institute) {
      super(name, surname, functionOfWorker, salary, language, institute);
   }
}

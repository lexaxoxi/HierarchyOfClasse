package app;

import methods.WorkerRepository;
import methods.WorkerRepositoryImpl;

//Сотрудники организации находятся в файле "DB of workers.txt"
public class Main {
    public static void main(String[] args) {
       WorkerRepository workerRepository = new WorkerRepositoryImpl();

       System.out.println("\n"+"Информация о всех сотрудниках:");
       System.out.println(workerRepository.findAll());

       System.out.println("\n"+"Следующий метод- поиск по имени:");
       System.out.println(workerRepository.findByName("Alex"));

        System.out.println("\n"+"Сумма зарплат организации:");
        System.out.println(workerRepository.getSumOfSalary());

        System.out.println("\n"+"Информация о зарплате сотрудников:");
        System.out.println(workerRepository.getSalary());


    }
}

package app;

import methods.WorkerRepository;
import methods.WorkerRepositoryImpl;

public class Main {
    public static void main(String[] args) {
       WorkerRepository workerRepository = new WorkerRepositoryImpl();

       System.out.println("\n"+"Информация о всех сотрудниках:");
       System.out.println(workerRepository.findAll());

       System.out.println("\n"+"Следующий метод- поиск по имени:");
       System.out.println(workerRepository.findByName("Alex"));

        System.out.println("\n"+"Следующий метод- сумма зарплат организации:");
        System.out.println(workerRepository.getSumOfSalary());

       //todo сделать вывод фио и зп по возрастанию
        System.out.println("\n"+"Информация о зарплате сотрудников:");
        System.out.println("ФИО: " + workerRepository.getSalary());


    }
}

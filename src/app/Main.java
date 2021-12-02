package app;

import methods.WorkerRepository;
import methods.WorkerRepositoryImpl;
import models.Worker;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WorkerRepository workersRepository = new WorkerRepositoryImpl();
        List<Worker> workers = workersRepository.findAll();
        System.out.println("Информация о всех сотрудниках:");

        for (Worker worker : workers) {
            System.out.println(worker.getName() + " " + worker.getSurname() + " " + worker.getFunctionOfWorker() + " " + worker.getSalary());
        }

        //todo сдеалть вывод фио и зп по возрастанию


    }
}

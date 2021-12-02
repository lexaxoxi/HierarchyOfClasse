package methods;

import models.Worker;

import java.util.List;

public interface WorkerRepository {
    //выдает информацию обо всех сотрудниках
    List <Worker> findAll();

    //выдает информацию об одном сотруднике
    List<Worker> findByName(String name);

    //выдает размер общей зарплаты сотрудников
    Long getSumOfSalary();

    //выдает сотрудников по возрастанию зарплаты
    List<Worker> getSalary();

}

package methods;

import models.Worker;

import java.util.List;

public interface WorkerRepository {
    //выдает информацию обо всех сотрудниках
    List <Worker> findAll();

    //выдает сумму зарплаты сотруднику
    Double getSalary();

}

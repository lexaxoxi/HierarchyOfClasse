package methods;

import models.Worker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WorkerRepositoryImpl implements WorkerRepository{
    private static final String PATH_TO_AUTO = "DB of workers.txt";

    private final Function<String, Worker> workerMapper = line -> {
        if (line == null || line.isEmpty()) {
            return null;
        } else {
            line = line.substring(1, line.length() - 1);
            String[] parsedLine = line.split("]\\[");
            return new Worker (parsedLine[0],
                    parsedLine[1],
                    parsedLine[2],
                    Integer.parseInt (parsedLine[3]));

        }
    };
    private <T> T common(String fileName, Function<BufferedReader, T> function) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return function.apply(reader);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    //вывод всей информации о ВСЕХ сотрудниках
    public List<Worker> findAll() {
        return common(PATH_TO_AUTO, reader ->
                reader.lines()
                        .map(workerMapper)
                        .sorted(Comparator.comparing(Worker::getName))
                        .collect(Collectors.toList()));
    }

    //вывод всей информации об одном сотруднике, имя вводится в Main
    @Override
    public List<Worker> findByName(String name) {
        return common(PATH_TO_AUTO, reader ->
                reader.lines()
                        .map(workerMapper)
                        .filter(worker -> worker.getName().equals(name))
                        .sorted(Comparator.comparing(Worker::getName))
                        .collect(Collectors.toList()));
            }

    //вывод суммы зарплаты организации
    @Override
    public Long getSumOfSalary () {
        return common(PATH_TO_AUTO, reader ->
                reader.lines()
                        .map(workerMapper)
                        .mapToLong(Worker::getSalary)
                        .sum());
    }


    @Override
    public List<Worker> getSalary() {
        return common(PATH_TO_AUTO, reader -> {
            return reader.lines()

                    .map(workerMapper)
                    .sorted(Comparator.comparing(Worker::getSalary))
                    //.mapToInt(Worker::getName)
                    //.map(Worker::getSurname)
                    //  .map(Worker::getSalary)
                    //    .distinct()
                    .collect(Collectors.toList());
        });


    }

}
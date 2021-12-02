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
                    //todo сделать массив чтоб корректно работал или не массив сделать в Worker
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

    public List<Worker> findAll() {
        return common(PATH_TO_AUTO, reader ->
                reader.lines()
                        .map(workerMapper)
                        .sorted(Comparator.comparing(Worker::getName))
                        .collect(Collectors.toList()));
    }

    @Override
    public Double getSalary() {
        return common(PATH_TO_AUTO, reader ->
                reader.lines()
                        .map(workerMapper)
                        .map(Worker :: getSalary)
                        .map(Worker::getName)//что-то ругается не может перевести int в String
                        .map(Worker::getSurname)
                        .distinct()
                        .count());
    }

}

package ru.isshepelev.simplecicdapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLouder implements CommandLineRunner {
    private final CountRepository countRepository;

    public DataLouder(CountRepository countRepository) {
        this.countRepository = countRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Count count = new Count();
        count.setCount(0);
        countRepository.save(count);
    }
}

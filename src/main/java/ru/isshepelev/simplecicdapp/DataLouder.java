package ru.isshepelev.simplecicdapp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLouder implements CommandLineRunner {
    private final CountRepository countRepository;

    @Override
    public void run(String... args) throws Exception {
        Count count = new Count();
        count.setCount(0);
        countRepository.save(count);
    }
}

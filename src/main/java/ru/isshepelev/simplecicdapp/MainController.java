package ru.isshepelev.simplecicdapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MainController {

    private final CountRepository countRepository;

    public MainController(CountRepository countRepository) {
        this.countRepository = countRepository;
    }

    @GetMapping("/first")
    public String first(){
        return "controller 1";
    }

    @GetMapping("/count")
    public int count(){
        Optional<Count> count = countRepository.findById(1l);
        count.get().setCount(count.get().getCount() + 1);
        countRepository.save(count.get());
        return count.get().getCount();
    }

}

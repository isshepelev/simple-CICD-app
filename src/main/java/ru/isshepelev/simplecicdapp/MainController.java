package ru.isshepelev.simplecicdapp;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final CountRepository countRepository;

    @GetMapping("/first")
    public String first(){
        return "controller 1";
    }

    @GetMapping("/second")
    public String second(){
        return "controller 2";
    }

    @GetMapping("/third")
    public String third(){
        return "controller 3";
    }

    @GetMapping("/count")
    public int count(){
        Optional<Count> count = countRepository.findById(1l);
        count.get().setCount(count.get().getCount() + 1);
        countRepository.save(count.get());
        return count.get().getCount();
    }

}

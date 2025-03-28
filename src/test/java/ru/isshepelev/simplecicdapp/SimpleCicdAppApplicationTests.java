package ru.isshepelev.simplecicdapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCicdAppApplicationTests {

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(1,1);
    }

}

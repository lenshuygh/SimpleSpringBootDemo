package com.boot.demo.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    HealthIndicator healthIndicator(){
        return () -> Health.status("I <3 Thorreke!").build();
    }

    @Bean
    CommandLineRunner runner(ReservationRepository reservationRepository) {
        return args -> {
            Arrays.asList("Les,Josh,Phil,Sasha,Peter".split(","))
            .forEach(name -> reservationRepository.save(new Reservation(name)));

            reservationRepository.findAll().forEach(System.out::println);

            reservationRepository.findByReservationName("Les").forEach(System.out::println);
        };
    }
}



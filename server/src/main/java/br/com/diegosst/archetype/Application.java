package br.com.diegosst.archetype;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfiguration
@SpringBootApplication
@EnableRabbit
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

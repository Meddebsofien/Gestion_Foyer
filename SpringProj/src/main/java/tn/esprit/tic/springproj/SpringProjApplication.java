package tn.esprit.tic.springproj;


import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@AllArgsConstructor
@EnableScheduling
public class SpringProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjApplication.class, args);
        System.out.println("hello");


    }




}

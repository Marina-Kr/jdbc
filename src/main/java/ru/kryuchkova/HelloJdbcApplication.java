package ru.kryuchkova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kryuchkova.controller.Controller;
import ru.kryuchkova.dao.DAO;
import ru.kryuchkova.model.Author;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HelloJdbcApplication {

    // private static DAO<Author> dao;
    private static Controller controller;

    public HelloJdbcApplication(Controller controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloJdbcApplication.class, args);
        Controller.show();

    }

}

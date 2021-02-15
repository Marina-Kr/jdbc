package ru.kryuchkova.controller;

import org.springframework.stereotype.Component;
import ru.kryuchkova.dao.DAO;
import ru.kryuchkova.model.Author;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Controller {

    private static DAO<Author> dao;

    public Controller(DAO<Author> dao) {
        this.dao = dao;
    }

    public static void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Create new author");
        System.out.println("2. Search author by id");
        System.out.println("3. Update author by id");
        System.out.println("4. Delete author by id");
        System.out.println("5. Show all table");
        System.out.println("0. Exit");

        int c = scanner.nextInt();
        switch (c) {
            case 1: {
                System.out.println("Enter first name");
                String firstName = scanner.next();
                System.out.println("Enter last name");
                String lastName = scanner.next();
                System.out.println("Enter country");
                String country = scanner.next();
                Author author = new Author(firstName, lastName, country);
                dao.create(author);
                show();
            }
            case 2: {
                System.out.println("Enter id");
                int id = scanner.nextInt();
                Optional<Author> author = dao.get(1);
                System.out.println(author.get());
                show();
            }
            case 3: {
                System.out.println("Enter id");
                int id = scanner.nextInt();
                System.out.println("Enter new first name");
                String firstName = scanner.next();
                System.out.println("Enter new last name");
                String lastName = scanner.next();
                System.out.println("Enter new country");
                String country = scanner.next();
                Author author = new Author(firstName, lastName, country);
                dao.update(author, id);
                show();
            }

            case 4: {
                System.out.println("Enter id");
                int id = scanner.nextInt();
                dao.delete(id);
                show();
            }

            case 5: {
                List<Author> authors = dao.list();
                authors.forEach(System.out::println);
                show();
            }
            case 0:

        }
    }
}

package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.annotation.Target;

public class ProductRepositoryTest {
    Product book1 = new Book(1, "Над пропостью во ржи", 500, "Джером Селенжер");
    Product book2 = new Book(20, "Отцы и дети", 485, "Иван Тургеенев");
    Product book3 = new Book(31, "Преступление и наказание", 689, "Федор Достоевский");
    Product book4 = new Book(1000, "Война и мир", 1500, "Лев Толстой");
    Product smartphone1 = new Smartphone(6, "Galaxy S21", 68_000, "Samsung");
    Product smartphone2 = new Smartphone(2, " Galaxy S22", 82_500, "Samsung");
    Product smartphone3 = new Smartphone(32, "Apple iPhone 14", 79_999, "Apple");
    Product smartphone4 = new Smartphone(4, "Xiaomi Redmi 9C", 7_900, "XIAOMI");
    Product smartphone5 = new Smartphone(5, "Honor X8", 19_800, "Honor");

    @Test
    public void shouldRemove() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(0);

        });

    }

    @Test
    public void shouldRemoveExisting () {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        repo.removeById(20);

        Product[] expected = {book1, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

}

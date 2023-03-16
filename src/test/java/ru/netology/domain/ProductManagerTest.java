package ru.netology.domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import ru.netology.domain.ProductManager;
import ru.netology.domain.ProductRepository;


public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product book1 = new Book(1, "Над пропостью во ржи", 500, "Джером Селенжер");
    Product book2 = new Book(20, "Отцы и дети", 485, "Иван Тургеенев");
    Product book3 = new Book(31, "Преступление и наказание", 689, "Федор Достоевский");
    Product book4 = new Book(1000, "Война и мир", 1500, "Лев Толстой");
    Product smartphone1 = new Smartphone(6, "Galaxy S21", 68_000, "Samsung");
    Product smartphone2 = new Smartphone(2, " Galaxy S22", 82_500, "Samsung");
    Product smartphone3 = new Smartphone(32, "Apple iPhone 14", 79_999, "Apple");
    Product smartphone4 = new Smartphone(4, "Xiaomi Redmi 9C", 7_900, "XIAOMI");
    Product smartphone5 = new Smartphone(5, "Honor X8", 19_800, "Honor");




    /*  @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
    }*/


    @Test
    public void shouldSearchOneBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Над пропостью во ржи");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEmptyRequest() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = manager.searchBy("");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNumber() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("2");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneCyrillicLetter() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        Product[] expected = {book1, book2, book3, book4};
        Product[] actual = manager.searchBy("и");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneLatinLetter() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        Product[] expected = {smartphone3, smartphone4};
        Product[] actual = manager.searchBy("i");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchWhitespace() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = manager.searchBy(" ");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneCyrillicWorld() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        Product[] expected = {book4};
        Product[] actual = manager.searchBy("мир");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneLatinWorld() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        Product[] expected = {smartphone5};
        Product[] actual = manager.searchBy("Honor");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchMissingWorld() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Земля");

        Assertions.assertArrayEquals(expected, actual);
    }

}
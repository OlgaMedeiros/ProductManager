package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class ProductManagerTest {

    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book("1984", "A", 10, 100);
    Product book2 = new Book("Сила подсознания", "B", 11, 300);
    Product book3 = new Book("Девушка из Германии", "C", 12, 500);
    Product smartphone1 = new Smartphone("Самсунг", 13, 1000, "Китай");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
    }

    @Test
    public void shouldSearch() {   // найти по имени
        String name = "1984";

    Product[] expected = {book1};
    Product[] actual = manager.searchBy("1984");

         Assertions.assertArrayEquals(expected,actual);
}

    @Test
    public void shouldSearchNotExistProduct() {
        String notName = "Нет такой книги";
        Product[] expected = {};
        Product[] actual = manager.searchBy("Нет такой книги");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProducts() {
        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("Сила подсозания");
        );

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldMatchesTrue() {
        boolean expected = true;
        boolean actual = manager.matches(book1, "1984");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchesFalse() {
        boolean expected = false;
        boolean actual = manager.matches(book1, "C");

        Assertions.assertEquals(expected, actual);
    }

}
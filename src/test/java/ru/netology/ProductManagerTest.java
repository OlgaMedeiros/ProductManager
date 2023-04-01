package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class ProductManagerTest {

    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book("1984", "Орвелл", 10, 100);
    Product book2 = new Book("Сила подсознания", " Диспенза", 11, 300);
    Product book3 = new Book("Девушка из Германии", "Корреа", 12, 500);
    Product smartphone1 = new Smartphone("Самсунг", 13, 1000, "Китай");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
    }

    @Test
    public void shouldSearchByName() {   // найти книгу по имени
        String name = "1984";

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("1984");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByAuthor() {   // найти книгу по имени автора
        String author = "Орвелл";

        Product[] expected = new Book[]{};
        Product[] actual = manager.searchBy("Орвелл");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFabricator() {   // найти книгу по производителю
        String fabricator = "Китай";

        Product[] expected = new Book[]{};
        Product[] actual = manager.searchBy("Китай");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNotExistProduct() {    //найти несуществующую книгу
        String notName = "Нет такой книги";
        Product[] expected = {};
        Product[] actual = manager.searchBy("Нет такой книги");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProduct() {   // найти продукт в поиске
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Сила подсознания");


        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldMatchesTrue() {  // соответствие продукта согласно запроса
        boolean expected = true;
        boolean actual = manager.matches(book1, "1984");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchesFalse() {   //соответствие или нет продукта согласно запроса
        boolean expected = false;
        boolean actual = manager.matches(book1, "C");

        Assertions.assertEquals(expected, actual);
    }

}
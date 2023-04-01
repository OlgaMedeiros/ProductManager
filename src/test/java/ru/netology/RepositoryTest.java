package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Product book1 = new Book("1984", "Орвелл", 10, 100);
    Product book2 = new Book("Сила подсознания", "Диспенза", 11, 300);
    Product book3 = new Book("Девушка из Германии", "Корреа", 12, 500);
    Product smartphone1 = new Smartphone("Samsung", 13, 1000, "Китай");


    @Test
    public void testFindAll() {   //найти все товары
        Repository repository = new Repository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.findAll();

        Product[] expected = {book1, book2, book3, smartphone1};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFind2Books() {   //найти две книги
        Repository repository = new Repository();
        repository.save(book1);
        repository.save(book2);


        Product[] expected = {book1, book2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindByID() {   //поиск по id
        Repository repository = new Repository();

        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);

        Product[] expected = {book3};
        Product[] actual = repository.findById(12);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemove1() {    // удаление товара
        Repository repository = new Repository();
        repository.save(book1);

        Product[] expected = {book1};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemove2() {    // удаление 2 товаров
        Repository repository = new Repository();
        repository.save(book1);
        repository.save(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

}








package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void shouldFindAllMovies() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Джентльмены");

        String[] expected = {"Бладшот", "Вперед", "Джентльмены"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентльмены", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfDefaultLimit() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентльмены", "Отель Белград", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfMoreThanDefaultLimit() {
        MovieManager manager = new MovieManager();

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Номер один");

        String[] expected = {"Номер один", "Человек-невидимка", "Джентльмены", "Отель Белград", "Вперед"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfNoMovies() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLimitIsMoreThanDefault() {
        MovieManager manager = new MovieManager(6);

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Номер один");
        manager.addNewMovie("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Номер один", "Человек-невидимка", "Джентльмены", "Отель Белград", "Вперед"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLimitIsLowerThanDefault() {
        MovieManager manager = new MovieManager(4);

        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек-невидимка");
        manager.addNewMovie("Номер один");
        manager.addNewMovie("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Номер один", "Человек-невидимка", "Джентльмены"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}

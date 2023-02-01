package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmsManagerTest {

    @Test
    public void shouldFindFilmsIFItSeveral() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Film I");
        manager.addFilm("Film II");
        manager.addFilm("Film III");

        String[] expected = { "Film I", "Film II", "Film III" };
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneFilm() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Film I");

        String[] expected = { "Film I" };
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFilmsIFTheyAreNotHave() {
        FilmsManager manager = new FilmsManager();

        String[] expected = { };
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFilmsIfItNull() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm(null);

        String[] expected = { null };
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastTenFilmsIfItTen() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Film I");
        manager.addFilm("Film II");
        manager.addFilm("Film III");
        manager.addFilm("Film IV");
        manager.addFilm("Film V");
        manager.addFilm("Film VI");
        manager.addFilm("Film VII");
        manager.addFilm("Film VIII");
        manager.addFilm("Film IX");
        manager.addFilm("Film X");

        String[] expected = { "Film X", "Film IX", "Film VIII", "Film VII", "Film VI", "Film V", "Film IV", "Film III", "Film II", "Film I" };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastFilmsIfItAboveLimit() {
        FilmsManager manager = new FilmsManager();

        manager.addFilm("Film I");
        manager.addFilm("Film II");
        manager.addFilm("Film III");
        manager.addFilm("Film IV");
        manager.addFilm("Film V");
        manager.addFilm("Film VI");
        manager.addFilm("Film VII");
        manager.addFilm("Film VIII");
        manager.addFilm("Film IX");
        manager.addFilm("Film X");
        manager.addFilm("Film XI");

        String[] expected = { "Film XI", "Film X", "Film IX", "Film VIII", "Film VII", "Film VI", "Film V", "Film IV", "Film III", "Film II" };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastFilmsIfItBelowLimit() {
        FilmsManager manager = new FilmsManager(9);

        manager.addFilm("Film I");
        manager.addFilm("Film II");
        manager.addFilm("Film III");
        manager.addFilm("Film IV");
        manager.addFilm("Film V");
        manager.addFilm("Film VI");
        manager.addFilm("Film VII");
        manager.addFilm("Film VIII");
        manager.addFilm("Film IX");

        String[] expected = { "Film IX", "Film VIII", "Film VII", "Film VI", "Film V", "Film IV", "Film III", "Film II", "Film I" };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastFilmsIfItNulAndLimitNull() {
        FilmsManager manager = new FilmsManager(0);

        String[] expected = { };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastFilmsIfItNulAndWithNotNullLimit() {
        FilmsManager manager = new FilmsManager(5);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}

package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Roman on 14.04.2020
 */
public class TrackerSQLTest {
    private TrackerSQL sql = new TrackerSQL();

    {
        this.sql.init();
    }

    @After
    @Before
    public void setUp() {
        this.sql.cleadDB();
    }

    @Test
    public void checkConnection() {
        var sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

    @Test
    public void add() {
        var vasya = sql.add(new Item("Vasya"));
        assertNotNull(vasya.getId());
        assertThat(vasya, is(sql.findById(vasya.getId())));
    }

    @Test
    public void replace() {
        var vasya = sql.add(new Item("Vasya"));
        var newName = "Vasilii";
        vasya.setName(newName);
        assertTrue(this.sql.replace(vasya.getId(), vasya));
        assertThat(newName, is(sql.findById(vasya.getId()).getName()));
    }

    @Test
    public void delete() {
        var vasya = sql.add(new Item("Vasya"));
        assertTrue(sql.delete(vasya.getId()));
        assertNull(sql.findById(vasya.getId()));
    }

    @Test
    public void findAll() {
        Item vasya = sql.add(new Item("Vasya"));
        Item vasya2 = sql.add(new Item("Vasya"));
        Item petya = sql.add(new Item("Petya"));
        assertThat(sql.findAll(), is(List.of(vasya, vasya2, petya)));
    }

    @Test
    public void findByName() {
        Item vasya = sql.add(new Item("Vasya"));
        Item vasya2 = sql.add(new Item("Vasya"));
        sql.add(new Item("Petya"));
        assertThat(sql.findByName("Vasya"), is(List.of(vasya, vasya2)));
    }

    @Test
    public void findById() {
        sql.add(new Item("Vasya"));
        var petya = sql.add(new Item("Petya"));
        assertThat(petya, is(sql.findById(petya.getId())));
    }
}
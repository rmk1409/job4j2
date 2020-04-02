package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class AbstractStoreTest {
    private AbstractStore<User> store;
    private User user;
    private String id = "some id";

    @Before
    public void setUp() {
        this.store = new UserStore(10);
        this.user = new User(this.id);
        this.store.add(this.user);
    }

    @Test
    public void add() {
        assertThat(this.store.findById(id), is(user));
    }

    @Test
    public void replace() {
        String newId = "new id";
        User newUser = new User(newId);
        this.store.replace(this.id, newUser);
        assertNull(this.store.findById(this.id));
        assertThat(this.store.findById(newId), is(newUser));
    }

    @Test
    public void delete() {
        this.store.delete(this.id);
        assertNull(this.store.findById(this.id));
    }

    @Test
    public void findById() {
        this.add();
    }
}
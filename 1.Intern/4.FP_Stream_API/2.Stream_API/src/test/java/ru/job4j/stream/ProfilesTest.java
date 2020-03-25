package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Pogorelov on 25.03.2020
 */
public class ProfilesTest {
    @Test
    public void collect() {
        Address a1 = new Address("Msc", "Main", 1, 1);
        Profile p = new Profile(a1);
        Address a2 = new Address("Piter", "Nevsk", 10, 10);
        Profile p2 = new Profile(a2);
        List<Address> expected = List.of(a1, a2);
        assertThat(expected, is(Profiles.collect(List.of(p, p2))));
    }
}
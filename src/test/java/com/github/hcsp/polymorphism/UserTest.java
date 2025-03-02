package com.github.hcsp.polymorphism;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void compareToMethodIsCorrect() {
        List<User> users =
                Arrays.asList(
                        new User(100, "b"),
                        new User(10, "z"),
                        new User(1, "a"),
                        new User(2000, "a"));
        List<String> expectedSortedNames = Arrays.asList("a", "a", "b", "z");

        Assertions.assertTrue(new User(1, "a").compareTo(new User(2, "b")) < 0);
        Assertions.assertTrue(new User(1, "b").compareTo(new User(2, "a")) > 0);
        Assertions.assertEquals(
                expectedSortedNames,
                users.stream().sorted().map(User::getName).collect(Collectors.toList()));

        TreeSet<User> treeSet = new TreeSet<>(users);
        Assertions.assertEquals(4, treeSet.size());
        Assertions.assertEquals(
                expectedSortedNames,
                treeSet.stream().sorted().map(User::getName).collect(Collectors.toList()));
    }
}

package io.ljunggren.streamUtils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class StreamUtilsTest {
    
    private final List<String> states = Arrays.asList(new String[] {
            "Alabama",
            "Alaska",
            "Arizona",
            "Arkansas",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "Florida",
            "Georgia"
    });

    @Test
    public void getSliceTest() {
        List<String> sublist = StreamUtils.getSlice(states, 2, 6);
        assertEquals(states.get(2), sublist.get(0));
        assertEquals(states.get(6), sublist.get(4));
    }
    
    @Test
    public void getSliceOutOfBoundsTest() {
        List<String> sublist = StreamUtils.getSlice(states, 7, 20);
        assertEquals(sublist.size(), 3);
    }
    
    @Test
    public void distinctByKeyTest() {
        @Getter
        @AllArgsConstructor
        class User {
            private String firstName;
            private String lastName;
        }
        List<User> users = Arrays.asList(new User[] {
                new User("Alex", "Ljunggren"),
                new User("James", "Ljunggren"),
                new User("Jane", "Doe")
        });
        List<User> uniqueUsersByLastname = users.stream()
                .filter(StreamUtils.distinctByKey(user -> user.getLastName()))
                .collect(Collectors.toList());
        assertEquals(2, uniqueUsersByLastname.size());
        assertEquals(users.get(0), uniqueUsersByLastname.get(0));
        assertEquals(users.get(2), uniqueUsersByLastname.get(1));
    }

}

package treegraph;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayDequeMethodsTest {

    @Test
        // 3-2-1-0
        // ->--->-
    void testIt_stack() {

        Deque<String> integers = new ArrayDeque<>();

        integers.push("zero");
        integers.push("one");
        integers.push("two");
        integers.push("three");

        assertEquals(4, integers.size());

        assertEquals("three", integers.getFirst());
        assertEquals("zero", integers.getLast());

        assertEquals("three", integers.pop());
        assertEquals("two", integers.pop());

        assertEquals(2, integers.size());

        assertEquals("one", integers.getFirst());
        assertEquals("zero", integers.getLast());

    }

    @Test
        // 0-1-2-3
        // -->-->
    void testIt_queue() {

        Deque<String> integers = new ArrayDeque<>();

        integers.offer("zero");
        integers.offer("one");
        integers.offer("two");
        integers.offer("three");

        assertEquals(4, integers.size());

        assertEquals("zero", integers.getFirst());
        assertEquals("three", integers.getLast());

        assertEquals("zero", integers.poll());
        assertEquals("one", integers.poll());

        assertEquals(2, integers.size());

        assertEquals("two", integers.getFirst());
        assertEquals("three", integers.getLast());

    }

    @Test
    void testIt_queue_stack() {

        Deque<String> integers = new ArrayDeque<>();

        integers.offer("zero");
        integers.offer("one");
        integers.offer("two");
        integers.offer("three");

        assertEquals("zero", integers.getFirst());
        assertEquals("three", integers.getLast());

        integers.push("four");

        assertEquals("four", integers.getFirst());
        assertEquals("three", integers.getLast());



    }
}

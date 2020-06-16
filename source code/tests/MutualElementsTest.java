import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MutualElementsTest {

    MutualElements test = new MutualElements();

    @Test
    public void mutualElementsTest1() {
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> b = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 7));

        assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)),test.mutualElements(a, b));
    }

    @Test
    public void mutualElementsTest2() {
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 3, 4, 4, 5, 4));
        List<Integer> b = new ArrayList<Integer>(Arrays.asList(3, 4, 4, 5, 6, 4));

        assertEquals(new ArrayList<Integer>(Arrays.asList(3, 4, 4, 5, 4)),test.mutualElements(a, b));
    }

    @Test
    public void mutualElementsTest3() {
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
        List<Integer> b = new ArrayList<Integer>(Arrays.asList(3, 4, 4, 5, 6, 4));

        assertEquals(new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList())),test.mutualElements(a, b));
    }
}
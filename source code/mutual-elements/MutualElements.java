// Create a method that takes two integer lists as a parameter
// and returns an integer list with the mutual elements from the lists.
// Write at least 3 different test cases.

// For example:
// List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 3, 4));
// List<Integer> b = new ArrayList<Integer>(Arrays.asList(3, 4, 4, 5, 6));

// System.out.println(filterMutualElements(a, b));
// Should print: 
// [3,4]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MutualElements{
    public static void main(String[] args) {

         List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 3, 4, 4, 5, 4));
         List<Integer> b = new ArrayList<Integer>(Arrays.asList(3, 4, 4, 5, 6, 4));

         ArrayList<Integer> mutualElements = mutualElements(a, b);

        for (Integer mutualElement : mutualElements) {
            System.out.print(mutualElement + " ");
        }

    }
    public static ArrayList<Integer> mutualElements(List<Integer> input1, List<Integer> input2){
        ArrayList<Integer> mutualList = new ArrayList<>();

        int indexOf;
        for (int i = 0; i < input1.size(); i++) {
            if(input2.contains(input1.get(i))){
                indexOf = input2.indexOf(input1.get(i));
                mutualList.add(input1.get(i));
                input2.remove(indexOf);
                input1.remove(i);
                i--;
            }
        }

        return mutualList;
    }
}


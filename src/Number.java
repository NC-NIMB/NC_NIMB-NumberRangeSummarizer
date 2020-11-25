import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by NC NIMB on 11/23/2020.
 */

public class Number implements NumberRangeSummarizer { // The number class implements the NumberRangeSummarizer Interface
    private static Scanner sc;

    private int indexIncrement = 0;
    private boolean isSequential;

    private int currentNumber = 0;
    private int nextNumber = 0;


    public static void main(String[] args) { // Main Method

        System.out.println("Please enter your data "); //prompts the user for a string that contains comma separated values
        sc = new Scanner(System.in);

        try {
            String input = sc.nextLine();
            NumberRangeSummarizer obj = new Number(); //creates and instance of the object
            System.out.println(obj.summarizeCollection(obj.collect(input)));
        }

        catch (NumberFormatException e) {
            System.out.println(e);
        }

    }

    public Collection<Integer> collect(String input) { //delimits the comma separated list
        List<Integer> col = Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        return col;
    }

    @Override
    public final String summarizeCollection(Collection<Integer> input) { //groups the number

        ArrayList<Integer> list = new ArrayList<>(input);
        String str = list.get(0).toString();

        return summarize(list, indexIncrement, str);
    }

    private String summarize(ArrayList<Integer> list, int i, String str){ //checks if numbers are sequential
        currentNumber = (list.get(i) + 1);
        nextNumber = list.get(i + 1);

        if(currentNumber == nextNumber){
            i++;
            isSequential = true;
        }
        else if(isSequential) {
            str += "-" + list.get(i);
            i++;
            str += ("," + list.get(i));
            isSequential = false;
        }
        else {
            isSequential = false;
            i++;
            str += "," + list.get(i);
        }
        return (i <= list.size() - 2 ? summarize(list, i, str) : str) ;
    }

}

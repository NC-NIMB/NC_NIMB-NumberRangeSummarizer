import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;


import java.util.Collection;


public class NumberTest extends TestCase {

    private Number numberRangeSummarizer = new Number();

    @Test
    public void testStringSplit() { //checks that the sample numbers have been split correctly
        Collection<Integer> sampleNumbers = numberRangeSummarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        Assert.assertFalse(sampleNumbers.isEmpty());
        Assert.assertEquals(sampleNumbers.iterator().hasNext(), true);
    }


    @Test
    public void testNumbersSummarized() { //checks that sample numbers have been summarized
        String sampleNumbers = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String correctOutput = "1,3,6-8,12-15,21-24,31";

        Collection<Integer> input = numberRangeSummarizer.collect(sampleNumbers);
        Assert.assertEquals(numberRangeSummarizer.summarizeCollection(input), correctOutput);
    }


}
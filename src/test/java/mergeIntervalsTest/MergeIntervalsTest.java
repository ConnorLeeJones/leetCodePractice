package mergeIntervalsTest;

import mergeIntervals.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static mergeIntervals.MergeIntervals.mergeIntervals;

public class MergeIntervalsTest {


    @Test
    public void testMergeOne() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(6,7));
        input.add(new Interval(2,4));
        input.add(new Interval(5,9));

        List<Interval> result = new LinkedList<>();
        result.add(new Interval(2,4));
        result.add(new Interval(5,9));
        Assert.assertTrue(compareIntervalLists(result, mergeIntervals(input)));
    }

    @Test
    public void testMergeTwo() {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,4));
        input.add(new Interval(2,6));
        input.add(new Interval(3,5));

        List<Interval> result = new LinkedList<>();
        result.add(new Interval(1,6));
        Assert.assertTrue(compareIntervalLists(result, mergeIntervals(input)));
    }

    public static boolean compareIntervalLists(List<Interval> l1, List<Interval> l2){
        Collections.sort(l1, (x, y) -> Integer.compare(x.start, y.start));
        Collections.sort(l2, (x, y) -> Integer.compare(x.start, y.start));
        if (l1.size() != l2.size()){
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i).start != l2.get(i).start || l1.get(i).end != l2.get(i).end){
                return false;
            }
        }
        return true;
    }

}

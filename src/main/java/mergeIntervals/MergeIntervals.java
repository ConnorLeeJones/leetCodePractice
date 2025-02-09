package mergeIntervals;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {


    public static List<Interval> mergeIntervals(List<Interval> intervals){
        Collections.sort(intervals, (x, y) -> Integer.compare(x.start, y.start));

        List<Interval> mergedIntervals = new LinkedList<>();
        Iterator<Interval> intervalIterator = intervals.iterator();

        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalIterator.hasNext()){
            interval = intervalIterator.next();
            if (interval.start <= end){ //overlap
                end = Math.max(end, interval.end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
}

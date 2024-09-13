package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class SparseArrays {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> result = new ArrayList<>();

        for (String query : queries) {
            int a = 0;
            for (String string : strings) {
                if (query.equals(string)) {
                    ++a;
                }
            }
            result.add(a);
        }
        return  result;
    }
}

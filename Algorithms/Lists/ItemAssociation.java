import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

public class ItemAssociation {
    
    public static class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main (String[] args) {
        List<PairString> itemAssociation1 = new ArrayList(){
            {
                add(new PairString("item1", "item2"));
                add(new PairString("item3", "item4"));
                add(new PairString("item4", "item5"));
            }
        };
        List<PairString> itemAssociation2 = new ArrayList(){
            {
                add(new PairString("item1", "item2"));
                add(new PairString("item3", "item4"));
                add(new PairString("item4", "item5"));
                add(new PairString("item6", "item7"));
                add(new PairString("item6", "item8"));
            }
        };
        List<PairString> itemAssociation3 = new ArrayList(){
            {
                add(new PairString("item1", "item2"));
                add(new PairString("item4", "item5"));
                add(new PairString("item3", "item4"));
                add(new PairString("item1", "item4"));
            }
        };
        System.out.println(findLargestAssociation(itemAssociation1)); // Output: [item3, item4, item5]
        System.out.println(findLargestAssociation(itemAssociation2)); // Output: [item3, item4, item5], here we got same size, so have to sort lexicographical.
        System.out.println(findLargestAssociation(itemAssociation3)); // Output: [item1, item2, item3, item4, item5]
    }

    public static List<String> findLargestAssociation(List<PairString> itemAssocation) {
        Map<String, java.util.List<String>> map = new HashMap<>();
        List<List<String>> assocList = new ArrayList<>();

        for (PairString pair : itemAssocation) {
            if (!map.containsKey(pair.first)) {
                map.put(pair.first, new ArrayList<>());
            }
            map.get(pair.first).add(pair.second);

            if (!map.containsKey(pair.second)) {
                map.put(pair.second, new ArrayList<>());
            }
            map.get(pair.second).add(pair.first);
        }

        Set<String> visited = new HashSet<>();

        for (String key : map.keySet()) {
            java.util.List<String> assoc = new ArrayList<>();
            dfs(assoc, visited, key, map);

            if (!assoc.isEmpty()) {
                Collections.sort(assoc);
                assocList.add(assoc);
            }
        }

        System.out.println(assocList.toString());

        Collections.sort(assocList, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2) {
                if (l1.size() == l2.size()) {
                    for (int i = 0; i < l1.size(); i++) {
                        if (l1.get(i).equals(l2.get(i))) continue;
                        return l1.get(i).compareTo(l2.get(i));
                    }
                }

                return l2.size() - l1.size();
            }
        });
        return assocList.get(0);
    }

    public static void dfs(List<String> assoc, Set<String> visited, String key, Map<String, List<String>> map) {
        if (visited.contains(key)) return;

        visited.add(key);
        assoc.add(key);
        for (String nextKey : map.get(key)) {
            dfs(assoc, visited, nextKey, map);
        }
    }
}
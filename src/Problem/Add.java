package Problem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Add {
    public static void main(String[] args) {
        int time = 0;
        HashMap<String, Integer> min = new HashMap<>();
        HashMap<String, Integer> hour = new HashMap<>();
        HashMap<String, Integer> blackList = new HashMap<>();
        while (true) {
            time++;
            String user = "";
            int min_count = min.getOrDefault(user, 0);
            min.put(user, min_count + 1);
            int hour_count = hour.getOrDefault(user, 0);
            hour.put(user, hour_count + 1);
            if (time % 60 == 0) {
                for (String i : min.keySet()) {
                    if (min.get(i) >= 500) {
                        min.put(i, 0);
                        blackList.put(i, 3600);
                    }
                }
            }
            if (time % 3600 == 0) {
                for (String i : hour.keySet()) {
                    if (hour.get(i) >= 5000) {
                        hour.put(i, 0);
                        blackList.put(i, 3600);
                    }
                }
            }
            Iterator<Map.Entry<String, Integer>> iterator = blackList.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = (Map.Entry) iterator.next();
                if (entry.getValue() == 1) {
                    iterator.remove();
                    //least time ==1s
                    continue;
                }
                entry.setValue(entry.getValue() - 1);
            }
        }
    }
}

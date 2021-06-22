package SortAlgorithm;

import java.util.*;


/**
 * Hashmap的几种遍历方式
 **/
public class TestHashmap {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "愚者");
        hashMap.put(2, "神孽");
        hashMap.put(3, "阿蒙");
        hashMap.put(4, "亚当");
        hashMap.put(2,"乌洛琉斯");
//        //1
//        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//
//        }
//
//        //2


        //3
        /*
        在迭代的时候从map中删除entries的(通过调用iterator.remover())唯一方法
         */
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry) iterator.next();
            if (entry.getKey() == 2) {
                System.out.println("asds");
                iterator.remove();
            }

            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
        for (int i : hashMap.keySet()) {
            System.out.println(i + "  " + hashMap.get(i));
        }

        List<String> list = new ArrayList<>();
        list.add("徐风年");
        list.add("满子");
        list.add("荷花");
        list.add("asdasdasdasdas");
        System.out.println(list);
//        list.remove(list.size()-1);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(list);
    }
}

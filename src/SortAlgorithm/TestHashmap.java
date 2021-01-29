package SortAlgorithm;

import java.util.*;


/**
 * Hashmap的几种遍历方式
 **/
public class TestHashmap {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "愚者");
        hashMap.put(2, "真实造物主");
        hashMap.put(3, "时天使阿蒙");
        hashMap.put(4, "空天使亚当");

        //1
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //2
        for (int i : hashMap.keySet()) {
            System.out.println(i + " 2 " + hashMap.get(i));
        }

        //3
        /*
        在迭代的时候从map中删除entries的(通过调用iterator.remover())唯一方法
         */
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " 3 " + entry.getValue());
        }

        List<String> list =new ArrayList<>();
        list.add("徐风年");
        list.add("满子");
        list.add("荷花");
        System.out.println(list);
        list.remove(list.size()-1);
        System.out.println(list);
    }
}

package Maps_And_Sets;

import java.util.HashMap;

public class Map_STL {
    static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Rag",19);  map.put("Ranjan",19); map.put("Raushan",20);
        map.put("Ankita",21);  map.put("Raghav",22); map.put("Shashi",19);

        for (String key : map.keySet()){
            System.out.println(key+" "+map.get(key));
        }


//        System.out.println(map+"\n"+"Size: "+map.size());
//        System.out.println(map.remove("Raghav"));
//        System.out.println("Size: "+map.size());
//        System.out.println(map.get("Rag"));
//        map.put("Deepak",20);
//        System.out.println(map+"\n"+"Size: "+map.size());
//        System.out.println(map.containsKey("Rag"));
    }
}

package list;
import java.util.*;

/**
 * @author www
 * @version 1.0
 * @date 2022/3/23
 * @effect
 */
public class LRU<k,v>extends LinkedHashMap<k,v> {
    private int capacity;
    private static final long serialVersionID = 1;

    //带参数
    LRU(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        //System.out.println(eldest.getKey()+"="+eldest.getValue());
        return size() > capacity;
    }

    public static void main(String[] args) {
//        Map<Integer,Integer>map=new LRU<>(4);
//        new HashSet<>();
//        map.put(9,3);
//        map.put(7,4);
//        map.put(5,9);
//        map.put(9,3);
//        for(Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();it.hasNext();){
//            System.out.println(it.next().getKey());
//        }
        Thread t = new Thread() {

            public void run() {
                my360DW();
            }
        };

        t.run();
        System.out.print("DW");
    }

    static void my360DW() {

        System.out.print("360");
    }
}

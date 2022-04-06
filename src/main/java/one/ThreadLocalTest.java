package one;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author www
 * @version 1.0
 * @date 2021/10/15
 * @effect ThreadLocal 测试
 */
public class ThreadLocalTest {

    private static final ExecutorService executorService= Executors.newFixedThreadPool(100);;

    public static void main(String[] args) {
        for (int i = 0; i < 3000; i++) {
            int j = i;
            executorService.execute(()->{
                String date = dateToStr(j*1000);
                System.out.println(date);
            });
        }
        executorService.shutdown();
    }
    public static String dateToStr(int millisSeconds){
        Date date = new Date(millisSeconds);
        SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        return simpleDateFormat.format(date);
    }

}
class ThreadSafeFormatter{
    public static ThreadLocal<SimpleDateFormat>dateFormatThreadLocal = new ThreadLocal(){
        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };
}

package simple;

import common.Cons;
import util.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈东东
 * @date 2020/10/9 13:53
 * @description 一句話描述用途
 */
public class Test {
    public static void main(String[] args) {

        Long l = 100L;
        BigDecimal radius = new BigDecimal(l);
        BigDecimal v = radius.divide(new BigDecimal("95225.087"),20, BigDecimal.ROUND_HALF_UP);
        System.out.println(v);


//        System.out.println(Cons.cityGeoMap);


//        HashMap<String, String> map = new HashMap<>();
//
//        map.put("1", "hello");
//        map.put("2", "world");
//        System.out.println(map.get("1"));
//        System.out.println(map.get("3"));
////
//        HashMap<String, String> map2 = new HashMap<>();
//        map2.put("3","aaa");
//        map2.put("1", "hello222");
//
//        map2.putAll(map);
//        System.out.println(map2);
//

//        Calendar calendar1 = Calendar.getInstance();
//        Calendar calendar2 = Calendar.getInstance();
//        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
//        int offset1 = 1 - dayOfWeek;
//        int offset2 = 7 - dayOfWeek;
//        calendar1.add(Calendar.DATE, offset1 - 7);
//        calendar2.add(Calendar.DATE, offset2 - 7);
//        String start = DateUtil.format(calendar1.getTime(),YMD);
//        String end = DateUtil.format(calendar2.getTime(),YMD);
//
//        System.out.println(start);
//        System.out.println(end);
//创建要序列化的集合对象



    }
}

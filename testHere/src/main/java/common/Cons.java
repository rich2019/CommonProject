package common;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈东东
 * @date 2020/12/18 9:30
 * @description 常量
 */
public class Cons {

    /**
     * 春节日期 2021-01-18 00:00:00
     */
    public static String FESTIVAL_DAY = "1610899200000";

    /**
     * 进出城卡口                进城          出城
     * 高禹  330523022030     北往南 04    南往北 03
     * 晓墅  330523022029     东往西 01    西往东 02
     * 杭垓  330523022039     北往南 04    南往北 03
     * 幽岭  330523022025     南向北 03    北向南 04
     */
    public static final String[] JCKKS = {"330523022030,04,03",
            "330523022029,01,02",
            "330523022039,04,03",
            "330523022025,03,04"};

    /**
     * 测试使用的省的名称
     */
    public static String[] provinces = {"浙E", "皖", "豫", "沪", "苏", "浙A", "浙B", "粤", "京", "闽", "川", "渝"};

    /**
     * 城市地理位置map
     */
    public static Map<String, BigDecimal[]> cityGeoMap= new HashMap<>();

    static{
        cityGeoMap.put("湖州", new BigDecimal[]{BigDecimal.valueOf(120.102398), BigDecimal.valueOf(30.867198)});
        cityGeoMap.put("杭州", new BigDecimal[]{BigDecimal.valueOf(120.209947), BigDecimal.valueOf(30.245853)});
        cityGeoMap.put("宁波", new BigDecimal[]{BigDecimal.valueOf(121.6216), BigDecimal.valueOf(29.859515)});
        cityGeoMap.put("温州", new BigDecimal[]{BigDecimal.valueOf(120.672111), BigDecimal.valueOf(28.000575)});
        cityGeoMap.put("绍兴", new BigDecimal[]{BigDecimal.valueOf(120.582112), BigDecimal.valueOf(29.997117)});
        cityGeoMap.put("嘉兴", new BigDecimal[]{BigDecimal.valueOf(120.750865), BigDecimal.valueOf(30.762653)});
        cityGeoMap.put("金华", new BigDecimal[]{BigDecimal.valueOf(119.649506), BigDecimal.valueOf(29.089524)});
        cityGeoMap.put("衢州", new BigDecimal[]{BigDecimal.valueOf(118.87263), BigDecimal.valueOf(28.941708)});
        cityGeoMap.put("台州", new BigDecimal[]{BigDecimal.valueOf(121.428599), BigDecimal.valueOf(28.661378)});
        cityGeoMap.put("丽水", new BigDecimal[]{BigDecimal.valueOf(119.921786), BigDecimal.valueOf(28.451993)});
        cityGeoMap.put("舟山", new BigDecimal[]{BigDecimal.valueOf(122.106863), BigDecimal.valueOf(30.016028)});
    }

}

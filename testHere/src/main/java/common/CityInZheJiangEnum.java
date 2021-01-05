package common;

/**
 * @author 陈东东
 * @date 2020-09-14 02:42:35
 * @description 浙江的城市枚举类
 */
public enum CityInZheJiangEnum {

    /**
     * 杭州
     */
    a("浙A", "杭州"),
    /**
     * 宁波
     */
    b("浙B", "宁波"),
    /**
     * 温州
     */
    c("浙C", "温州"),
    /**
     * 绍兴
     */
    d("浙D", "绍兴"),
    /**
     * 湖州
     */
    e("浙E", "湖州"),
    /**
     * 嘉兴
     */
    f("浙F", "嘉兴"),
    /**
     * 金华
     */
    g("浙G", "金华"),
    /**
     * 衢州
     */
    h("浙H", "衢州"),
    /**
     * 台州
     */
    j("浙J", "台州"),
    /**
     * 丽水
     */
    k("浙K", "丽水"),
    /**
     * 舟山
     */
    l("浙L", "舟山");

    private String code;

    private String name;

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    CityInZheJiangEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

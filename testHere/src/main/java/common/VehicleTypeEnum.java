package common;

/**
 * @author 陈东东
 * @date 2020-09-14 02:42:35
 * @description 车辆类型枚举
 */
public enum VehicleTypeEnum {

    /**
     * 大型车
     */
    bigCar("01", "大型车"),
    /**
     * 大型新能源汽车
     */
    newEnergyBigCar("51", "大型新能源汽车"),
    /**
     * 小型汽车
     */
    smallCar("03", "小型汽车"),
    /**
     * 小型新能源汽车
     */
    newEnergySmallCar("03", "小型新能源汽车"),
    /**
     * 进城方向
     */
    fxbhIn("1", "进城方向"),
    /**
     * 出城方向
     */
    fxbhOut("2", "出城方向");

    private String code;

    private String name;

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    VehicleTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

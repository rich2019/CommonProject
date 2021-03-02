import java.time.LocalDateTime;

/**
 * @author 陈东东
 * @date 2021/1/11 16:45
 * @description 一句話描述用途
 */
public class Test {
    public static LocalDateTime byWeek(int dictionaryWeek) {
        int day = 0;
        int value = LocalDateTime.now().getDayOfWeek().getValue();
        if (dictionaryWeek == value) {
            day = 7;
        }
        if (value < dictionaryWeek) {
            day = 7 + dictionaryWeek - value;
        }
        if (value > dictionaryWeek) {
            day = 7 - (dictionaryWeek - value);
        }
        return LocalDateTime.now().plusDays(day);
    }

    public static void main(String[] args) {
        LocalDateTime localDate = byWeek(1);
        System.out.println("下周五是："+localDate);
    }
}

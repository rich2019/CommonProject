import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 陈东东
 * @date 2021/1/11 16:45
 * @description 一句話描述用途
 */
public class Test {
    volatile int a = 1;
    public static void main(String[] args) {
        // 一开始我的时间是  2019-01-01 00:00:00
        //1.定义格式
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //2.把字符串转成localDate
        LocalDate localDate = LocalDate.parse("2019-01-01", df);

        //3.定义格式
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //4.把 2019-01-01  转成  2019/01/01
        String format = localDate.format(dtf);
        System.out.println(format);
    }
}

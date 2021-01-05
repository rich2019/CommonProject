package testRead.entities;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class PoliceCar {
    //设置excel表头名称
    @ExcelProperty(value = "序列",index = 0)
    private Integer sno;
    @ExcelProperty(value = "车牌号",index = 1)
    private String cphm;

    @ExcelProperty(value = "所属单位",index = 5)
    private String depCode;


}
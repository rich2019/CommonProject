package testRead.readAndWrite;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author 陈东东
 * @date 2021/1/5 14:45
 * @description 一句話描述用途
 */
@Slf4j
public class Read {

    public static void main(String[] args) {
        excelImport();

    }

    public static void excelImport() {
        List<Object> list = EasyExcelFactory.read(getInputStream("C:\\Users\\rich\\Desktop\\安吉信息\\2021年警车.xls"), new Sheet(1));
        String listString = JSONObject.toJSONString(list);
        log.info("list:{}", listString);
        JSONArray arryList = JSONObject.parseArray(listString);
        // 处理数据
        List<Map<String, Object>> listMap = new ArrayList<>();
        for (int i = 1; i < arryList.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            JSONArray rowData = JSONObject.parseArray(JSONObject.toJSONString(arryList.get(i)));
            map.put("id", rowData.get(0));
            map.put("name", rowData.get(1));
            map.put("sex", rowData.get(2));
            listMap.add(map);
        }
        log.info("data:{}", JSONObject.toJSONString(listMap));
    }

    private static InputStream getInputStream(String fileName) {
        try {
            return new BufferedInputStream(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}

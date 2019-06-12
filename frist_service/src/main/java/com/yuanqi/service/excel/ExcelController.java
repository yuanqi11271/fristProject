package com.yuanqi.service.excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.yuanqi.common.response.BaseResponse;
import com.yuanqi.common.util.POIUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author: yq
 * @Date：2019/5/16 16:56
 * @Describe:
 */
@RestController
public class ExcelController {

    @PostMapping("/importExcel")
    public BaseResponse importExcel(@RequestParam("file") MultipartFile file){
        HashMap<Object, Object> newHashMap = Maps.newLinkedHashMap();
        try {
            InputStream inputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            List<Map<String,Object>> arrList = POIUtils.upload(file, workbook);
            for (Map<String, Object> map : arrList) {
                ArrayList<Object> objects = Lists.newArrayList();
                String team = (String) map.get("参赛团队");
                String school = (String) map.get("学校");
                for (Map<String, Object> objectMap : arrList) {
                    if (team.equals(objectMap.get("参赛团队")) && school.equals(objectMap.get("学校"))){
                        objects.add(objectMap);
                        newHashMap.put(team+school,objects);
                    }
                }
            }

        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return new BaseResponse().buildSuccess(newHashMap);
    }
}

package com.yuanqi.service.excel;

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
import java.util.List;
import java.util.Map;

/**
 * @Author: yq
 * @Date：2019/5/16 16:56
 * @Describe:
 */
@RestController
public class ExcelController {

    @PostMapping("/importExcel")
    public BaseResponse importExcel(@RequestParam("file") MultipartFile file){
        try {
            InputStream inputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Map<Integer, List<List<? super Object>>> map = POIUtils.upload(file, workbook);

            return new BaseResponse().buildSuccess(map);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
}

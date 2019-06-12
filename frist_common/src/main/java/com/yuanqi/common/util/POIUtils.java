package com.yuanqi.common.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.zip.CheckedInputStream;

/**
 * @Author: yq
 * @Date：2019/5/16 17:03
 * @Describe: poiExcel工具类
 */
@Slf4j
public class POIUtils {

    /**
     * @param file 上传的文件
     * @param
     * @return
     */
    // TODO 获取合并单元格的值
    public static List upload(MultipartFile file, Workbook workbook) {

        List<LinkedHashMap<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            // 得到Excel的行数
            int totalRows = sheet.getPhysicalNumberOfRows();
            // 得到Excel的列数(前提是有行数)
            int totalCells = 0;
            if (totalRows > 1 && sheet.getRow(0) != null) {
                totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            }
            // 循环Excel行数
            for (int r = 1; r < totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) {
                    continue;
                }
                // 循环Excel的列
                LinkedHashMap<String, Object> hashMap = Maps.newLinkedHashMap();
                for (int c = 0; c < totalCells; c++) {
                    Object valueObject = null;
                    Cell cell = row.getCell(c);
                    if (cell == null) {
                        continue;
                    }
                    DecimalFormat df = new DecimalFormat("0");
                    try {
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            String value = df.format(cell.getNumericCellValue());
                            valueObject = value;
                        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                            if (!StringUtils.isEmpty(cell.getStringCellValue())) {
                                valueObject = cell.getStringCellValue();
                            }
                        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                            valueObject = "";
                        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                            valueObject = cell.getBooleanCellValue();
                        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                            valueObject = "非法字符";
                        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                            valueObject = cell.getCellFormula();
                        }
                        String checkStr = check(c);
                        hashMap.put(checkStr, valueObject);

                    } catch (Exception e) {
                        log.error("\n==========解析Excel单元格异常==========", e);
                    }
                }
                list.add(hashMap);
            }
        }
        return list;
    }

    public static String check(Integer c) {
        switch (c) {
            case 0:
                return "参赛团队";
            case 1:
                return "姓名";
            case 2:
                return "身份";
            case 3:
                return "学校";
            default:
                return "";
        }
    }


    public static Workbook createWorkBook(MultipartFile file, String path) {
        multipartToFile(file, path);
        File f = createNewFile(file, path);
        Workbook workbook = null;
        try {
            InputStream is = new FileInputStream(f);
            workbook = WorkbookFactory.create(is);
            is.close();
        } catch (InvalidFormatException | IOException e) {
            log.error("\n==========文件流转换为Workbook对象异常============", e);
        }
        return workbook;
    }

    public static void multipartToFile(MultipartFile multfile, String path) {
        File file = createNewFile(multfile, path);
        try {
            multfile.transferTo(file);
        } catch (IOException e) {
            log.error("\n上传的文件保存失败");
        }
    }

    public static File createNewFile(MultipartFile multfile, String path) {
        String fileName = multfile.getOriginalFilename();
        File file = new File(path + fileName);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) parentFile.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            log.error("\n新文件创建失败");
        }
        return file;
    }
}

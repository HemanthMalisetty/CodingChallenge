package com.util.excel_reading;

import org.apache.poi.ss.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReading {
    String path = "src/main/resources/NewspaperChanges.xlsx";
    Workbook workbook = null;
    Sheet sheet = null;
    Row row = null;
    Cell cell = null;

    Map<String, String> myMap = new HashMap<>();
    public Map<String, String > getExcelData(String newspaperName){
        try {
            workbook = WorkbookFactory.create(new File(path));
            sheet = workbook.getSheet("Newspapers");
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i <= lastRowNum; i++){
                row = sheet.getRow(i);
                int lastCellNo = row.getLastCellNum();
                cell = row.getCell(0);
                if (cell.getStringCellValue().equalsIgnoreCase(newspaperName)){
                    for (int j = 1; j < lastCellNo; j++){
                        row = sheet.getRow(0);
                        String key = row.getCell(j).getStringCellValue();

                        row = sheet.getRow(i);
                        cell = row.getCell(j);
                        cell.setCellType(CellType.STRING);
                        String value = cell.getStringCellValue();

                        myMap.put(key, value);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return myMap;
    }

    public static Map<String, String> getNewspaperChargers(String newspaper) {
        ExcelReading excelReading = new ExcelReading();
        return excelReading.getExcelData(newspaper);
    }

}

package Utility;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataReader {

    public static Map<String, String> readKeyValueData(String filePath, String sheetName) {
        Map<String, String> dataMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Start from row 1 if row 0 is header
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);

                if (keyCell == null || valueCell == null) continue;

                String key = keyCell.getStringCellValue().trim();
                String value = "";

                switch (valueCell.getCellType()) {
                    case STRING:
                        value = valueCell.getStringCellValue().trim();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(valueCell)) {
                            value = sdf.format(valueCell.getDateCellValue());
                        } else {
                            value = String.valueOf(valueCell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        value = String.valueOf(valueCell.getBooleanCellValue());
                        break;
                    default:
                        value = "";
                        break;
                }

                dataMap.put(key, value);
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataMap;
    }
}

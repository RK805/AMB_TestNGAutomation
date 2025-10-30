package Utility;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesUtility {
    // read files utility class
    public static String readTxtFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static List<String[]> readCsvFile(String filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            rows.add(line.split(","));
        }
        return rows;
    }

    public static List<String[]> readXlsFile(String filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (Workbook workbook = new HSSFWorkbook(Files.newInputStream(Paths.get(filePath)))) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                List<String> cellValues = new ArrayList<>();
                for ( Cell cell : row) {
                    cellValues.add(cell.toString());
                }
                rows.add(cellValues.toArray(new String[0]));
            }
        }
        return rows;
    }
    // write files utility class
    public static void writeTxtFile(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeCsvFile(String filePath, List<String[]> rows) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8)) {
            for (String[] row : rows) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        }
    }

    public static void writeXlsFile(String filePath, List<String[]> rows) throws IOException {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");
            for (int i = 0; i < rows.size(); i++) {
                Row excelRow = sheet.createRow(i);
                String[] rowData = rows.get(i);
                for (int j = 0; j < rowData.length; j++) {
                    excelRow.createCell(j).setCellValue(rowData[j]);
                }
            }
            try (java.io.OutputStream fileOut = Files.newOutputStream(Paths.get(filePath))) {
                workbook.write(fileOut);
            }
        }
    }


}

 package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

    // Now accepts both excel file path and sheet name
    public static Object[][] getdata(String excelPath, String sheetName) throws IOException {
        File file1 = new File("C:\\Users\\VASUDHA K T\\Documents\\mavenproj\\src\\main\\resources\\Orangehrm_Testdata\\DataSheet.xlsx");
        System.out.println("Reading Excel file: " + file1.getAbsolutePath());

        FileInputStream fs = new FileInputStream(file1);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheet(sheetName);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        int colcount = worksheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Rows: " + rowcount + " | Cols: " + colcount);

        String[][] data = new String[rowcount - 1][colcount];

        // Start from row 1 (skip header row)
        for (int i = 1; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                data[i - 1][j] = worksheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        workbook.close();
        fs.close();

        return data;
    }
}

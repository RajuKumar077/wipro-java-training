package DataProviderTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static String[][] readExcelData() {
        String fileName = "C:\\Users\\Administrator\\eclipse-workspace\\SeleniumPrograms\\src\\test\\java\\tabChangeDynamicTest\\Input.xlsx";
        String[][] inputData = null;

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist at path: " + fileName);
            return new String[0][0];
        }

        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook workBook = new XSSFWorkbook(fis)) {

            // Debug: Print available sheets
            System.out.println("Available Sheets:");
            for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
                System.out.println(workBook.getSheetName(i));
            }

            XSSFSheet sheet = workBook.getSheet("Sheet1"); // ✅ Change sheet name to "Sheet1"

            if (sheet == null) {
                System.out.println("Sheet 'Sheet1' not found! Check sheet name.");
                return new String[0][0];
            }

            if (sheet.getRow(0) == null) {
                System.out.println("First row is empty! Ensure Excel file has headers.");
                return new String[0][0];
            }

            int rowCount = sheet.getLastRowNum();
            int cellCount = sheet.getRow(0).getLastCellNum();

            inputData = new String[rowCount][cellCount];
            DataFormatter df = new DataFormatter();

            for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
                for (int cellNo = 0; cellNo < cellCount; cellNo++) {
                    XSSFCell cell = sheet.getRow(rowNo).getCell(cellNo);
                    inputData[rowNo - 1][cellNo] = (cell != null) ? df.formatCellValue(cell) : "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputData;
    }

    public static void main(String[] args) {
        String[][] data = readExcelData();
        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}

package org.kodejava.example.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class ObtainingCellType {
    public static void main(String[] args) throws Exception {
        String filename = "..\\celltype.xls";

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);

            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();

                    int type = cell.getCellType();
                    if (type == HSSFCell.CELL_TYPE_STRING) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = STRING; Value = "
                                + cell.getRichStringCellValue().toString());
                    } else if (type == HSSFCell.CELL_TYPE_NUMERIC) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = NUMERIC; Value = "
                                + cell.getNumericCellValue());
                    } else if (type == HSSFCell.CELL_TYPE_BOOLEAN) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = BOOLEAN; Value = "
                                + cell.getBooleanCellValue());
                    } else if (type == HSSFCell.CELL_TYPE_BLANK) {
                        System.out.println("[" + cell.getRowIndex() + ", "
                                + cell.getColumnIndex() + "] = BLANK CELL");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}

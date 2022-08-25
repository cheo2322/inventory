package com.example.inventory.service;

import com.example.inventory.model.Product;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InventoryService {

  public void addRows(Product product) {

    try {
      Path path = Path.of("INV.xlsx");
      InputStream inputStream = new FileInputStream(path.toAbsolutePath().toString());
      Workbook workbook = WorkbookFactory.create(inputStream);

      // Get first sheet of Excel file
      Sheet sheet = workbook.getSheetAt(3);
      // get latest index numbers
      int rowIndex = sheet.getLastRowNum();

      // Populate the index value of new row
      rowIndex = rowIndex + 1;
      createNewRow(workbook, sheet, rowIndex, product);

      // Write updated Excel file
      OutputStream outputStream = new FileOutputStream(path.toAbsolutePath().toString());
      workbook.write(outputStream);

      inputStream.close();
      workbook.close();
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void createNewRow(Workbook workbook, Sheet sheet, int rowIndex, Product product) {
    Row row = sheet.createRow(rowIndex);

    Cell cell = row.createCell(0);
    cell.setCellValue(product.getCode());

    cell = row.createCell(1);
    cell.setCellValue(product.getCreationDate());

    cell = row.createCell(2);
    cell.setCellValue(product.getInvoiceCode());

    cell = row.createCell(3);
    cell.setCellValue(product.getSupplier());

    cell = row.createCell(4);
    cell.setCellValue(product.getCategory().toString());

    cell = row.createCell(5);
    cell.setCellValue(product.getDescription());

    cell = row.createCell(6);
    cell.setCellValue(product.getAmount());

    cell = row.createCell(7);
    cell.setCellValue(product.getPrice());

    cell = row.createCell(8);
    cell.setCellValue(product.getKgPrice());
  }
}

package com.example.inventory;

import com.example.inventory.model.Product;
import com.example.inventory.model.Product.Category;
import com.example.inventory.service.InventoryService;
import java.nio.file.Paths;

public class InventoryApp {
  public static void main(String[] args) {

    InventoryService inventoryService = new InventoryService();

    Product product = new Product("code-2", "invoiceCode-1", "supplier-1", Category.GAS, "description-1", 1.0, 1.0, 1.0);

    inventoryService.addRows(product);

    System.out.println(Paths.get("").toAbsolutePath());
  }
}

package com.example.inventory.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Product {

  private final String creationDate =
      LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  @NonNull private String code;
  @NonNull private String invoiceCode;

  @NonNull private String supplier;

  @NonNull private Category category;

  @NonNull private String description;

  @NonNull private Double amount;

  @NonNull private Double price;

  @NonNull private Double kgPrice;

  public enum Category {
    SOLID,
    LIQUID,
    GAS
  }
}

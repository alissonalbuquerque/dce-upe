package com.upe.dce.core.gerarPdf;

import lombok.Data;

@Data
public class QuoteItem {
    private String description;
    private Integer quantity;
    private Double unitPrice;
    private Double total;

}

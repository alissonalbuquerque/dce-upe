package com.upe.dce.core.gerarPdf;

import java.util.Map;

public interface IPdfGenerateService {

  void generatePdfFile(String templateName, String fileName , Map<String, Object> data);
}

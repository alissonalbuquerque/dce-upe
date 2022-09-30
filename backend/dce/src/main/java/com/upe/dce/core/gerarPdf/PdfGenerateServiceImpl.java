package com.upe.dce.core.gerarPdf;

import com.lowagie.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

@Slf4j
@Service
public class PdfGenerateServiceImpl implements IPdfGenerateService {

  @Autowired
  private TemplateEngine templateEngine;

  @Value("${pdf.directory}")
  private String pdfDirectory;

  @Override
  public void generatePdfFile(String templateName, String fileName, Map<String, Object> data) {
    Context context = new Context();
    context.setVariables(data);

    String htmlContent = templateEngine.process(templateName, context);
    try {
      FileOutputStream outputStream = new FileOutputStream(pdfDirectory + fileName);
      ITextRenderer renderer = new ITextRenderer();
      renderer.setDocumentFromString(htmlContent);
      renderer.layout();
      renderer.createPDF(outputStream, false);
      renderer.finishPDF();
    } catch (FileNotFoundException | DocumentException e) {
      log.error(e.getMessage(), e);
    }

  }
}

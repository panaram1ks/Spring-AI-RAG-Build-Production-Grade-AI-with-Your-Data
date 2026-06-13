package com.nexacorp.ai.ingestion.pdf;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class PdfIngestionService {

    private static final String PDF_DIRECTORY = "data/pdfs";

    public void ingestPdfs() throws Exception {
        File[] pdfFiles = new File(PDF_DIRECTORY).listFiles();

        for (File pdfFile : pdfFiles) {
            ingestSinglePdf(pdfFile);
        }
    }

    private void ingestSinglePdf(File pdfFile) throws IOException {
        log.info("Ingesting PDF name: {}", pdfFile.getName());

        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            log.info("--- Extracted text: ({}) ---", pdfFile.getName());
            log.info(text);
        }

    }

}

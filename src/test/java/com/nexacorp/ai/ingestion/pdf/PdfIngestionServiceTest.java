package com.nexacorp.ai.ingestion.pdf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PdfIngestionServiceTest {

    @Autowired
    PdfIngestionService pdfIngestionService;

    @Test
    void ingestPdf_forLearning() throws Exception{
        pdfIngestionService.ingestPdfs();
    }
}

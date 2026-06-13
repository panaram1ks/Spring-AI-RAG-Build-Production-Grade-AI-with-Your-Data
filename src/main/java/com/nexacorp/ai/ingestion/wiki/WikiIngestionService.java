package com.nexacorp.ai.ingestion.wiki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Service
public class WikiIngestionService {

    private static final String WIKI_DIRECTORY = "data/wiki";

    public void ingestWikiFiles() throws Exception {
        File[] markdownFiles = new File(WIKI_DIRECTORY).listFiles();

        for (File markdownFile : markdownFiles) {
            ingestSingleWikiFile(markdownFile);
        }
    }

    private void ingestSingleWikiFile(File markdownFile) throws IOException {
        log.info("Ingesting MD name: {}", markdownFile.getName());

        String content = Files.readString(markdownFile.toPath());
        log.info("---WIKI content ({})", markdownFile.getName());
        log.info(content);
    }

}

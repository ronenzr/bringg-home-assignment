package com.bringg.demo.dna.genefinder.services;

import com.bringg.demo.dna.genefinder.utils.FixedSizeStringBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FileService {

    private static Logger log = LoggerFactory.getLogger(FileService.class);

    public Set<String> findStringsByPrefix(String filePath, Charset encoding, String prefix) {
        try (FileReader fileReader = new FileReader(ResourceUtils.getFile((filePath)), encoding)) {
            return findByPrefix(fileReader, prefix);
        } catch (Exception ex) {
            log.error("[FileService] Error while searching for string in file: {}", filePath, ex);
            return null;
        }
    }

    //--

    private Set<String> findByPrefix(Reader reader, String prefix) throws IOException {
        FixedSizeStringBuffer prefixBuffer = new FixedSizeStringBuffer(prefix.length());
        List<StringBuilder> geneBuilders = new ArrayList<>();
        int ch;
        while ((ch = reader.read()) >= 0) {
            prefixBuffer.append((char) ch);
            appendToMany(geneBuilders, (char) ch);

            if (prefixBuffer.toString().equals(prefix)) {
                StringBuilder geneStringBuilder = new StringBuilder(prefixBuffer.toString());
                geneBuilders.add(geneStringBuilder);
            }
        }

        return geneBuilders.stream()
                .map(builder -> builder.toString())
                .collect(Collectors.toSet());
    }

    private String readToEnd(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = reader.read()) >= 0) {
            sb.append((char) ch);
        }

        return sb.toString();
    }

    private void appendToMany(List<StringBuilder> builders, char toAppend) {
        for (StringBuilder builder : builders) {
            builder.append(toAppend);
        }
    }
}

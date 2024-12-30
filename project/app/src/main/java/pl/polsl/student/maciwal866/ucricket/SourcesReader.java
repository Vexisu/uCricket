package pl.polsl.student.maciwal866.ucricket;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class SourcesReader {
    private LinkedHashSet<String> sourcePaths = new LinkedHashSet<>();
    private static final Pattern IMPORT_PATTERN = Pattern.compile("import ([a-zA-Z][a-zA-Z0-9]*(:[a-zA-Z][a-zA-Z0-9]*)*);");

    public SourcesReader(String path) {
        sourcePaths.add(path);
        findDependentSources(toFilePath(path));
    }
   
    private void findDependentSources(String path){
        try (var reader = new FileReader(path)) {
            var scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                var line = scanner.nextLine();
                var matcher = IMPORT_PATTERN.matcher(line);
                if (matcher.find() && sourcePaths.add(matcher.group(1))) {
                    var importPath = matcher.group(1);
                    System.out.format("Found new dependent source: %s\n", importPath);
                    findDependentSources(toFilePath(importPath));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toFilePath(String importPath) {
        return importPath.replace(":", "/") + ".uchirp";
    }

    public Reader getSequencedSource() throws FileNotFoundException {
        var sourceStreams = new Vector<FileInputStream>();
        for (var sourcePath : sourcePaths) {
            sourceStreams.add(new FileInputStream(toFilePath(sourcePath)));
        }
        return new BufferedReader(new InputStreamReader(new SequenceInputStream(sourceStreams.elements())));
    }
}

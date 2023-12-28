package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path s : sources) {
                zip.putNextEntry(new ZipEntry(s.toString()));
                try (BufferedInputStream output = new BufferedInputStream(
                        new FileInputStream(s.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException();
        }
        Zip zip = new Zip();
        /*zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );*/
        ArgsName virtualMachine = validate(args);
        Path path = Paths.get(virtualMachine.get("d"));
        List<Path> search = Search.search(path, p -> !p.toFile().getName().endsWith(virtualMachine.get("e")));
        zip.packFiles(search, new File(virtualMachine.get("o")));
    }

    private static ArgsName validate(String[] args) {
        ArgsName virtualMachine = ArgsName.of(args);
        String e = virtualMachine.get("e");
        String o = virtualMachine.get("o");
        String d = virtualMachine.get("d");
        Pattern patternExclude = Pattern.compile("\\S+");
        Pattern patternOutput = Pattern.compile("^.\\S*.\\.zip");
        if (!patternExclude.matcher(virtualMachine.get("e")).find()) {
            throw new IllegalArgumentException(String.format("No such exclude %s", e));
        }
        if (!patternOutput.matcher(o).find()) {
            throw new IllegalArgumentException(String.format("No such output %s", o));
        }
        if (!new File(d).isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", d));
        }
        return virtualMachine;
    }

}

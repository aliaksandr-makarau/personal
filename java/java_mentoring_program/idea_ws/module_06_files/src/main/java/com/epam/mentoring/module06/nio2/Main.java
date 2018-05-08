package com.epam.mentoring.module06.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Module 06 - NIO 2");

        Path source = Paths.get("data\\hello_world.txt");
        Path target = Paths.get("data\\hello_world_2.txt");

        System.out.println(source.getFileSystem().getRootDirectories());

        for (Path element : source) {
            System.out.println(element);
        }

        Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);

        File toRemove = new File("data\\hello_world_2.txt");
        toRemove.delete();

        Path pathDir = Paths.get("data\\new_dir_path");
        Path newDir = Files.createDirectory(pathDir);

        System.out.println(Files.isReadable(pathDir));
        System.out.println(Files.isWritable(pathDir));
        System.out.println(Files.isExecutable(newDir));

        Files.deleteIfExists(pathDir);
    }
}

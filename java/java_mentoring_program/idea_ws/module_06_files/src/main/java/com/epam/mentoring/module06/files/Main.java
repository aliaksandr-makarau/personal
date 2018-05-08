package com.epam.mentoring.module06.files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Module 06 - Simple Files API");

        File fileExample = new File("data\\text_file_example.txt");
        System.out.println(fileExample.exists());
        fileExample.createNewFile();
        System.out.println(fileExample.exists());

        File helloWorldFile = new File("data\\hello_world.txt");
        System.out.println(helloWorldFile.exists());
        System.out.println(helloWorldFile.length());

        if (fileExample.renameTo(new File("data\\text_file_example_2.txt"))) {
            System.out.println(fileExample.exists());
            System.out.println(fileExample.delete());
            System.out.println(fileExample.exists());
        }

        File renamedFileExample = new File("data\\text_file_example_2.txt");
        renamedFileExample.delete();

        File dirExample = new File("data\\new_directory");
        if (dirExample.mkdir()) {
            System.out.println(dirExample.exists());
            System.out.println(dirExample.isDirectory());
        }

        String[] subDirExample = dirExample.list();
        Arrays.asList(subDirExample).stream().forEach(System.out::println);

        File[] files = dirExample.listFiles();
        Arrays.asList(files).stream().forEach(System.out::println);

        catalogRetriever(dirExample.getAbsolutePath());
    }

    public static void catalogRetriever(String catalogPath) {
        File catalog = new File(catalogPath);
        System.out.println(catalog.getAbsolutePath());

        if (catalog.isDirectory()) {
            String[] children = catalog.list();

            for (String curChild : children) {
                catalogRetriever(catalogPath + "\\" + curChild);
            }
        }
    }
}

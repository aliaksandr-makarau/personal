package com.epam.mentoring.module06.readwriters;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader reader = null;
        try {
            reader = new FileReader("data\\hello_world.txt");
            int curChar = reader.read();

            while (curChar != -1) {
                System.out.println(curChar);
                curChar = reader.read();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            reader.close();
        }

        InputStream stream = null;
        try {
            stream = new FileInputStream("data\\hello_world.txt");
            reader = new InputStreamReader(stream);

            int curChar = reader.read();

            while (curChar != -1) {
                System.out.print((char) curChar);
                curChar = reader.read();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            reader.close();
            if (stream != null) {
                stream.close();
            }
        }
    }
}

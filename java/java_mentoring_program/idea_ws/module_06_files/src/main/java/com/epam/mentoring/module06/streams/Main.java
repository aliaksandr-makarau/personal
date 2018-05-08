package com.epam.mentoring.module06.streams;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Module 06 - InputStream / OutputStream API");

        // 1. Open stream
        // 2. Work with stream
        // 3. Close stream

        // Reading by bytes

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream("data\\hello_world.txt");
            out = new FileOutputStream("data\\hello_world_2.txt");

            int curByte = in.read();
            while (curByte != -1) {
                System.out.println(curByte);
                out.write(curByte);
                curByte = in.read();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            in.close();
            out.close();
        }

        File toRemove = new File("data\\hello_world_2.txt");
        toRemove.delete();

        try {
            in = new FileInputStream("data\\hello_world.txt");

            int curByte = in.read();
            while (curByte != -1) {
                System.out.print((char)curByte);
                curByte = in.read();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            in.close();
            out.close();
        }

    }
}

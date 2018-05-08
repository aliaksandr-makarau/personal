package com.epam.mentoring.module06.buffered;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Module 06 - BufferedReader / BufferedWriter API");

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader("data\\hello_world.txt"));
            writer = new PrintWriter(new FileWriter("data\\hello_world_2.txt"));
            String curLine = reader.readLine();

            while (curLine != null) {
                System.out.println(curLine);
                writer.write(curLine);
                curLine = reader.readLine();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
                reader = null;
            }
            if (writer != null) {
                writer.close();
                writer = null;
            }
        }

        File toRemove = new File("data\\hello_world_2.txt");
        toRemove.delete();

        System.out.format("Example of double output %.3f", 10.0);
    }
}

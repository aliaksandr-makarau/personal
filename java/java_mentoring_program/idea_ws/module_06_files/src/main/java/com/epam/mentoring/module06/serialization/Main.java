package com.epam.mentoring.module06.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Module 06 - Serialization");

        OutputStream out = new FileOutputStream("data\\serialization_out.out");
        ObjectOutputStream objOutput = new ObjectOutputStream(out);
        TestSerialize test = new TestSerialize();
        test.version = 20;
        test.version_not_serializable = 90;
        System.out.println(test.version_not_serializable);

        objOutput.writeObject(test);
        objOutput.flush();
        objOutput.close();

        InputStream in = new FileInputStream("data\\serialization_out.out");
        ObjectInputStream objInput = new ObjectInputStream(in);

        TestSerialize inTest = (TestSerialize) objInput.readObject();
        System.out.println(inTest.version);
        System.out.println(inTest.version_not_serializable);

        objInput.close();

        File toRemove = new File("data\\serialization_out.out");
        toRemove.delete();
    }
}

class TestSerialize implements Serializable {
    // static variables are not serializable
    public static byte static_version = 102;

    // transient variables are not serializable
    public transient byte version_not_serializable = 67;

    public byte version = 100;
    public byte count = 2;
}
package gr.codehub.cookbook.io;

import java.io.*;

public class DataIO {

    public static void saveDemo(String outFilename) throws IOException {

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(outFilename))));

        out.writeDouble(3.14);
        out.writeInt(1346);
        out.writeUTF("Ελληνικά");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(outFilename))));

        double pi = in.readDouble();
        double num = in.readInt();
        String str = in.readUTF();
        in.close();

        System.out.println("pi = " + pi);
        System.out.println("number = " + num);
        System.out.println("string = " + str);
    }

    public static void main(String[] args) {

        try {
            saveDemo("C:\\Users\\john\\Documents\\Templates\\data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package gr.codehub.cookbook.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteIO {

    public static void copyFile(String inFilename, String outFilename) throws IOException {

        FileInputStream in = new FileInputStream(inFilename);
        FileOutputStream out = new FileOutputStream(outFilename);

        boolean finished = false;
        while (!finished) {
            int b = in.read();
            if (b == -1)
                finished = true;
            else
                out.write(b);
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        try {
            copyFile("C:\\Users\\john\\Documents\\CV_Mpalatsos_EN.pdf", "C:\\Users\\john\\Documents\\Templates\\b.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

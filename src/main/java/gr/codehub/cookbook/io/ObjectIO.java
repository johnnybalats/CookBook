package gr.codehub.cookbook.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectIO {

    public static void saveObject(String outFilename, Object o) throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outFilename));
        out.writeObject(o);
        out.close();
    }

    public static Object readObject(String inFilename) throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(inFilename));
        Object o = in.readObject();
        in.close();
        return o;
    }

    public static <T> T copyObject(T o) {

        try {

            Path tempFile = Files.createTempFile(null, null);
            saveObject(tempFile.toString(), o);
            T o2 = (T)readObject(tempFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

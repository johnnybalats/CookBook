package gr.codehub.cookbook.io;

import gr.codehub.cookbook.model.Ingredient;

import java.io.*;

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

        return null;
    }

    public static void main(String[] args) {

        Ingredient i1 = new Ingredient("water", 1000);
        try {
            saveObject("C:\\Users\\john\\Documents\\myFile.txt", i1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Ingredient i2 = (Ingredient)readObject("C:\\Users\\john\\Documents\\myFile.txt");
            System.out.println("Ingredient 2 is " + i2.getName() + " and has quantity " + i2.getQuantity());
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package voleyballers;

import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Extension"))) {
            ObjectPlus.Load(ois);
        } catch (Exception e) {
            System.out.println("No extension");
        }

        FileOutputStream file2 = new FileOutputStream("Extension");

        ObjectOutputStream save2 = new ObjectOutputStream(file2);

        ObjectPlus.Save(save2);
        save2.close();


        System.out.println("\nExtension loaded from file: ");

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Extension"));
            System.out.println(ois.readObject());
            ois.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    }
}
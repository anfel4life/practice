package com.company.Services;


import java.io.*;

public abstract class DataKeeperUtils {

    private static String PATH = "./StaffStructureFile.bin";

    public static boolean  write(Object object) {
        try (FileOutputStream out = new FileOutputStream(PATH)) {
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream dout = new ObjectOutputStream(bout);
            dout.writeObject(object);
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Object read() {
        try (FileInputStream out = new FileInputStream(PATH)) {
            BufferedInputStream bout = new BufferedInputStream(out);
            ObjectInputStream dout = new ObjectInputStream(bout);
            return dout.readObject();
        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
            return null;
        }
    }
}

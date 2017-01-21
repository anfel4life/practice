package com.company.Services;

import java.io.*;

public abstract class DataKeeperUtils {

    private static String PATH_TO_STAFF_STRUCTURE_FILE = "./StaffStructureFile.bin";
    private static String PATH_TO_UNIQUE_EMPLOYEE_ID_FILE = "./EmployeeIdFile.bin";
    private static String PATH_TO_UNIQUE_NODE_ID_FILE = "./NodeIdFile.bin";

    public static boolean writeEmployeeId(Object object){
        return write(object, PATH_TO_UNIQUE_EMPLOYEE_ID_FILE);
    }

    public static boolean writeNodeId(Object object){
        return write(object, PATH_TO_UNIQUE_NODE_ID_FILE);
    }

    public static boolean writeStaffStructure(Object object){
        return write(object, PATH_TO_STAFF_STRUCTURE_FILE);
    }

    public static Object readEmployeeId(){
       return read(PATH_TO_UNIQUE_EMPLOYEE_ID_FILE);
    }

    public static Object readNodeId(){
        return read(PATH_TO_UNIQUE_NODE_ID_FILE);
    }

    public static Object readStaffStructure(){
        return read(PATH_TO_STAFF_STRUCTURE_FILE);
    }

    private static boolean  write(Object object, String path) {
        try (FileOutputStream out = new FileOutputStream(path)) {
            BufferedOutputStream bout = new BufferedOutputStream(out);
            ObjectOutputStream dout = new ObjectOutputStream(bout);
            dout.writeObject(object);
            dout.flush();
        } catch (IOException e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static Object read(String path) {
        try (FileInputStream out = new FileInputStream(path)) {
            BufferedInputStream bout = new BufferedInputStream(out);
            ObjectInputStream dout = new ObjectInputStream(bout);
            return dout.readObject();
        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
            return null;
        }
    }
}

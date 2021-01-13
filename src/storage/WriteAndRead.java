package storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteAndRead {
    public static void write(Object obj,String pathName){
        try {
            FileOutputStream fis= new FileOutputStream(pathName);
            ObjectOutputStream obOs= new ObjectOutputStream(fis);
            obOs.writeObject(obj);
            obOs.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static Object read(String pathName){
        Object obj =null;
        try {
            FileInputStream fos= new FileInputStream(pathName);
            ObjectInputStream ois= new ObjectInputStream(fos);
            obj = ois.readObject();
            ois.close();
            fos.close();
        } catch (Exception e) {
            System.out.println(e);;
        }
        return obj;
    }

}

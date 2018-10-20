import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    HashMap<Long, HashMap<Long, ArrayList<File>>> files = new HashMap<Long, HashMap<Long, ArrayList<File>>>();
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\darso\\IdeaProjects\\Duplicate\\DublFiles");
        for (File file : dir.listFiles()){

            System.out.format("%1$s %2$d\n", file.getName(), GetCRC(file));

        }
    }

    static Long GetCRC(File iFile){

        int byteRead;
        long result = 0;
        try (
                InputStream inputStream = new FileInputStream(iFile);
        ) {



            while ((byteRead = inputStream.read()) != -1) {
                result = result + byteRead;
                
            }
            inputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return (Long) result;

    }




}

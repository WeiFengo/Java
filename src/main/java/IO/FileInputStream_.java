package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\java\\Spring\\file.txt";
        FileInputStream file = null;
        int x;
        try {
            file = new FileInputStream(filePath);
            while ((x = file.read())!=-1)
            {
                System.out.print((char)x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            file.close();;
        }

    }
}

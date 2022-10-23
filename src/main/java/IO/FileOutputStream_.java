package IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void testOutputFile() throws IOException {
        String filePath = "E:\\java\\Spring\\output.txt";
        FileOutputStream file = null;
        file = new FileOutputStream(filePath,true);
        String s = "6666AAAA你好啊";
        file.write(s.getBytes());


        file.close();
    }

    @Test
    public void copyImg() throws IOException{
        String imgPath = "E:\\java\\Spring\\pic\\0a3b3288-3446-4420-bbff-f263d0c02d8e.jpg";
        String imgPath2 = "E:\\java\\Spring\\img.jpg";
        FileInputStream input = new FileInputStream(imgPath);
        FileOutputStream output = new FileOutputStream(imgPath2);
        int x;
        while((x=input.read())!=-1){
            output.write((char)x);
        }

        input.close();
        output.close();
    }
}


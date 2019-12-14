package online.ludzh;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.util.Objects;

/**
 * Created by ludzh on 2019/11/23.
 */
public class TsFileRenameTest {



    public static void main(String[] args) {

//        String testPath = "/Users/ludzh/Documents/PPPD795/文档任务组_20191123_094439/uxnCkWuf0.ts";
//        File testFile = new File(testPath);
//        File destFile = new File("/Users/ludzh/Documents/PPPD795/文档任务组_20191123_094439/uxnCkWuf000.ts");
//        testFile.renameTo(destFile);

        //zw_bdtKKWTk_wm0

        String fileNameHead = "JBXADwmC";
        String path = "/Users/ludzh/Documents/XXXX/XXXX";
        File dir = new File(path);
        for (File file : dir.listFiles()){
            String fileName = file.getName();
            if (Objects.equals(".DS_Store", fileName)){
                continue;
            }
            fileName = fileName.split("\\.")[0];
            String fileNum = fileName.substring(fileNameHead.length());
            if(fileNum.length() == 1){
                fileNum = "00" + fileNum;
            }
            if(fileNum.length() == 2){
                fileNum = "0" + fileNum;
            }
            String newFileName = fileNameHead + fileNum + ".ts";
            System.out.println(newFileName);
            File destFile = new File(path + "/" + newFileName);
            file.renameTo(destFile);
        }

    }
}

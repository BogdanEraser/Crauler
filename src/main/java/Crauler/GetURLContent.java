package Crauler;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Bogdan Kukharskiy on 17.09.2015.
 */
public class GetURLContent {

    public static Logger logger = Logger.getLogger(GetURLContent.class);

    public static void writeToFileByUrl(String urlAddress, String fileName) {

        try {
            URL url;
            url = new URL(urlAddress);
            URLConnection conn = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));


            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            //FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            String inputLine;

            while ((inputLine = br.readLine()) != null) {  //пока не конец считанной строки по УРЛу, пишем в файл
                bw.write(inputLine);
            }
            bw.flush();
            bw.close();
            br.close();
            System.out.println("Seems to be done");
            //logger.info("done getting data from " + urlAddress);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String urlAddress = "http://www.mkyong.com";
        //save to this filename
        String fileName = "D:/Java/Crauler/src/main/java/Crauler/test.html";
        writeToFileByUrl(urlAddress, fileName);
    }
}

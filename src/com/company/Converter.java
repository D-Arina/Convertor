package com.company;
import java.io.*;
import java.nio.charset.Charset;

public class Converter {

    public void convert(File in, String codIn, File out, String codOut) throws Exception {
        try {
            InputStream is = new FileInputStream(in);
            OutputStream off = new FileOutputStream(out);
            byte[] buffer = new byte[is.available()];
            is.read(buffer, 0, is.available());

            Charset codI = Charset.forName(codIn);
            Charset codO = Charset.forName(codOut);

            String s = new String(buffer, codI);
            buffer = s.getBytes(codO);

            off.write(buffer, 0, buffer.length);
        }catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }


    }

    public static void main(String[] args) throws Exception {
        File file = new File ("C://Users//dudki//IdeaProjects//Convector//myFile.txt");
        File file1 = new File("C://Users//dudki//IdeaProjects//Convector//myFile2.txt");
        Converter con = new Converter();
        con.convert(file, "UTF-8", file1, "ISO8859-5");
    }


}

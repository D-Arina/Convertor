package com.company;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Путь к файлу in: ");
        String in = scanner.nextLine();
        System.out.println("Кодировка файла in");
        String codIn = scanner.nextLine();
        System.out.println("Имя выходного файла");
        String out = scanner.nextLine();
        System.out.println("Кодировка выходного файла");
        String codOut = scanner.nextLine();

        File file = new File (in);
        File file1 = new File(out);

        Converter con = new Converter();
        con.convert(file, codIn, file1, codOut);
        // UTF-8, ISO8859-5
        //C://Users//dudki//IdeaProjects//Convector//myFile.txt
        //C://Users//dudki//IdeaProjects//Convector//myFile5.txt
    }


}

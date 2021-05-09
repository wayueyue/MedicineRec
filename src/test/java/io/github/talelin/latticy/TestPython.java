package io.github.talelin.latticy;

import java.io.*;

public class TestPython {
    public static void main(String[] args) {
        try {
            args = new String[] { "python", "E:\\Destop\\medicine\\he_20210425(3).py", "头痛,发热,汗出" };
            Process proc = Runtime.getRuntime().exec(args);
            InputStream inputStream = proc.getInputStream();
            InputStreamReader outputReader= new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(outputReader);
            String output = bufferedReader.readLine();
            System.out.println(output);
            bufferedReader.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

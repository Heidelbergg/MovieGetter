package com.example.moviegetter;

import android.content.Context;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class PopulateDB {

    public static void copyDB(Context context){
        try{
            String destination = "/data/data/"+ context.getPackageName() + "/databases";
            File file = new File(destination);

            if(!file.exists()){
                file.mkdir();
                rawCopy(context.getAssets().open("movies.db"), new FileOutputStream(destination + "/movies.db"));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void rawCopy(InputStream inputStream, OutputStream outputStream) throws IOException{
        byte[] buffer = new byte[1024];
        int length;
        while((length = inputStream.read(buffer)) > 0){
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }
}
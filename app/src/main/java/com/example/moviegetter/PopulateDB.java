package com.example.moviegetter;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PopulateDB {

    public static void copyDB(Context context){
        try{
            String destPath = "/data/data/"+ context.getPackageName() + "/databases";
            File f = new File(destPath);
            if(!f.exists()){
                f.mkdir();
                // Copy the db from assets folder into the databases folder
                rawCopy(context.getAssets().open("movies.db"), new FileOutputStream(destPath + "/movies.db"));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
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
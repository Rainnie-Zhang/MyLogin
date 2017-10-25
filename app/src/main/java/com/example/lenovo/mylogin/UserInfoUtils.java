package com.example.lenovo.mylogin;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2017/10/24.
 */

public class UserInfoUtils {
    public static boolean saveInfo(Context context,String username, String pwd){
        try {
            String result=username+"##"+pwd;
            String path=context.getFilesDir().getPath();
            File file=new File(path,"info.txt");
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(result.getBytes());
            fos.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public static Map<String,String> readInfo(Context context){
        try {
            Map<String,String> maps= new HashMap<String,String>();
            String path=context.getFilesDir().getPath();
            File file=new File(path,"info.txt");
            FileInputStream fis=new FileInputStream(file);
            BufferedReader buf=new BufferedReader(new InputStreamReader(fis));
            String content=buf.readLine();

            String[] spilts=content.split("##");
            String name=spilts[0];
            String pwd=spilts[1];
            maps.put("name",name);
            maps.put("pwd",pwd);
            fis.close();
            return maps;
        }catch (Exception e){
            e.printStackTrace();
            return  null;

        }

    }

}

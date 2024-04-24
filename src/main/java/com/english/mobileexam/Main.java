package com.english.mobileexam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.apache.commons.io.*;

public class Main {
    public static void main(String[] args) {

        File currentDir = new File(System.getProperty("user.dir"));
        ArrayList<File> files = new ArrayList<File>(Arrays.asList(Objects.requireNonNull(currentDir.listFiles())));
       files.removeIf(new Predicate<File>() {
           @Override
           public boolean test(File file) {
               return file.isDirectory();
           }
       });
       ArrayList<File> dirs =  new ArrayList<>();
       files.forEach(new Consumer<File>() {
           @Override
           public void accept(File file) {
               ArrayList<String> parts = new ArrayList<>( Arrays.asList(file.getName().split("")));
               parts =  new ArrayList<>(parts.stream().limit(4).toList());
               final String[] dateFolder = {""};
               parts.forEach(new Consumer<String>() {
                   @Override
                   public void accept(String s) {
                       dateFolder[0] +=s;
                   }
               });
               if(!new File(currentDir.getPath()+"\\"+dateFolder[0]).exists()  ){


                   try {

                       FileUtils.moveFileToDirectory(file, new File(currentDir.getPath()+"\\"+dateFolder[0]),true);
                   }catch (IOException ex){
                       ex.printStackTrace();
                   }
//                   FileOutputStream fos = null;
//                   try {
//                       File dir =  new File(currentDir.getPath()+"\\"+dateFolder[0]);
//                       dir.mkdir();
//
//                       fos = new FileOutputStream(dir);
//                       boolean success = file.renameTo(new File(dir.getPath()+"\\"+file));
//                       boolean isNull = file== null;
//                       System.out.println(success);
//                       fos =  new FileOutputStream(file);
//                   } catch (FileNotFoundException e) {
//                       e.printStackTrace();
//                   } finally {
//                       try {
//                           if (fos != null) {
//                               fos.close();
//                           }
//                       } catch (IOException e) {
//                           e.printStackTrace();
//                       }
//                   }

               }else {

try {
    FileUtils.moveFileToDirectory(file,new File(currentDir.getPath()+"\\"+dateFolder[0]),false);
}catch (IOException ex){
    ex.printStackTrace();
}
//                   FileOutputStream fos = null;
//                   try {
//                       File dir =  new File(currentDir.getPath()+"\\"+dateFolder[0]);
//
//                        boolean success = file.renameTo(new File(dir.getAbsolutePath()+"\\"+file));
//                        System.out.println(success);
//                       fos =  new FileOutputStream(file);
//                   } catch (FileNotFoundException e) {
//                       e.printStackTrace();
//                   } finally {
//                       try {
//                           if (fos != null) {
//                               fos.close();
//                           }
//                       } catch (IOException e) {
//                           e.printStackTrace();
//                       }
//                   }
               }
           }
       });



        }
    }

package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int c;
        do {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Создать новую заметку");
            System.out.println("2. Чтение созданной заметки");
            System.out.println("3. Удаление созданной заметки");
            System.out.println("4. Редактирование заметки");
            System.out.println("5. Выйти");
            Scanner scan = new Scanner(System.in);
            c = scan.nextInt();
            switch (c) {
                case 1:
                    new1();
                    break;

                case 2:
                    rd();
                    break;

                case 3:
                    del();
                    break;

                case 4:
                    red();
                    break;

                case 5:
                    System.out.println("Выход");
                    break;
            }
        }while (c < 4) ;

    }
    private static void new1() {
        System.out.println("Введите имя файла в виде даты");
        Scanner scn = new Scanner(System.in);
        String name = String.valueOf(scn.nextLine());

        try(FileWriter writer = new FileWriter(name, false))
        {
            System.out.println("Введите текст заметки");
            while (true)
            {
                Scanner scan = new Scanner(System.in);
                String t = String.valueOf(scan.nextLine());
                String text = t;
                if (text.equals("exit")) {
                    break;
                }
                else {
                    writer.write(text + "\r\n");
                    writer.flush();
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    private static void del(){
        System.out.println("Введите имя файла");
        Scanner scn1 = new Scanner(System.in);
        String name1 = String.valueOf(scn1.nextLine());

        File file = new File("" + name1);
        if(file.delete()){
            System.out.println("/home/user/IdeaProjects/diary/" + name1 +  " файл удален");
        }else System.out.println("/home/user/IdeaProjects/diary/" + name1 + " файл не был обнаружен:(");
    }
    private static void rd(){
        System.out.println("Введите имя заметки");
        Scanner scn = new Scanner(System.in);
        String name = String.valueOf(scn.nextLine());

        try(FileReader reader = new FileReader(name))
        {
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    private static void red() throws IOException {
        String separator = File.separator;
        System.out.println("Введите имя заметки");
        Scanner scn = new Scanner(System.in);
        String n = String.valueOf(scn.nextLine());

        System.out.println("Введите имя для новой заметки");
        Scanner scn1 = new Scanner(System.in);
        String n1 = String.valueOf(scn1.nextLine());

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/user/IdeaProjects/diary/" + n)));
        PrintWriter ed = new PrintWriter(new FileWriter("/home/user/IdeaProjects/diary/" + n1), true);
        String newst = "";

        System.out.println("Введите часть заметки, которую хотите заменить:");
        Scanner scan = new Scanner(System.in);
        String text = String.valueOf(scan.nextLine());

        System.out.println("Введите, на что заменить:");
        Scanner scan1 = new Scanner(System.in);
        String text1 = String.valueOf(scan1.nextLine());

        while (null != (newst = in.readLine())) {
            try {
                if (newst.contains(text)) {
                    newst = newst.replace(text, text1);
                }
                ed.println(newst);
            } catch (Exception e) {

            }
            {
            }
        }
        {
        }
    }
    {
    }
}
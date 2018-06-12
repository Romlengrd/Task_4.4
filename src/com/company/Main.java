package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Film[] films = new Film[10];
        String[] actors = new String[5];
        Film[] newFilms = new Film[10];

        /* while */
        /*if or switch для выбора действия*/

        /*Добавить фильм в коллекцию*/
        System.out.println("Введите название фильма для добавки в коллецию");
        String f = "Красная жара"; // scanner
        System.out.println("Вы ввели - ");
        for(int i=0;i<films.length;i++) {
            if (films[i]==null) {
             films[i]=new Film();
                films[i].setName(f);
                System.out.println(films[i]);
                break;
            } else System.out.println("Нет места для добавления фильма");
        }


        /*показать всю коллекцию*/
        //for(int i=0;i<films.length;i++) {
          //  if (films[i]==null) {
            //    System.out.println(films[i]);
            //}

        /* создать список актеров и добавить в конкретный фильм*/
        System.out.println("Введите список актеров через запятую");
        String a = "Арнольд Шварцнегер, Второй актер, Третий актер"; // scanner
        actors = a.split(",");
        for(int i=0;i<actors.length;i++) {
            actors[i] = actors[i].trim();
                System.out.println(actors[i]);
        }

        System.out.println("Введите в какой по порядку фильм добавить этот список");
        int num = 0; //scan -1
        if (films[num]!=null) { films[num].setActor(actors); }
        else {
            System.out.println("Нет фильма");
        }

        /* удаление*/
        //System.out.println("Введите какой по порядку фильм удалить");
        //int num = 0; //scan -1
        //if (films[num]!=null) { films[num]=null; }
        //else {
         //   System.out.println("Нет фильма");
        //}


        /* ДЕМО вызов на время отсутсвия while-if*/
        for(int i=0;i<films.length;i++) {
            if (films[i] != null) {
                System.out.println(films[i]);
            }
        }

        /* Сериализация*/
        ObjectOutputStream oos;
        try (FileOutputStream fos = new FileOutputStream("src\\com\\company\\file.ser")) {
            oos = new ObjectOutputStream(fos);
            oos.writeObject(films);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Десериализация */
        ObjectInputStream iis;
        try (FileInputStream fis = new FileInputStream("src\\com\\company\\file.ser")) {
            iis = new ObjectInputStream(fis);
            newFilms = (Film[]) iis.readObject(); //чтобы было видно что это не тотже массив, а десериализованный
            films = newFilms;



            /* ДЕМО вывод для проверки*/
            for(int i=0;i<films.length;i++) {
                if (films[i] != null) {
                    System.out.println(films[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

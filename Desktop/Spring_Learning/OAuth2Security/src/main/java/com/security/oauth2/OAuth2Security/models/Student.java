/*package com.security.oauth2.OAuth2Security.models;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

@Component
public class Student {

    private int studentCount;
    private String name;
    private int year;
    private int grade;
    private static int id = 1000;
    private static int courseCost = 600;
    private String uniqueId;
    private float cartBalance = 0;
    private String courses;


    public Student(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name");
        this.name = scanner.nextLine();
        System.out.println("Enter Year");
        this.year = scanner.nextInt();
        System.out.println("1 - Fresher\n2 - Associate \n3 - ETangineer \n4 - Manager");
        this.grade = scanner.nextInt();
        setUniqueID();
        getUniqueId();
        getEnrollment();
    }


    private void setStudentCount(){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter the count of new students");
         this.studentCount = scanner.nextInt();
     }

    private void setUniqueID(){
            id++;
         this.uniqueId = grade +"1"+ id ;
    }

    public String getUniqueId() {
        System.out.println(uniqueId);
        return uniqueId;
    }

    public float getBalance() {
        return cartBalance;
    }


    public void getEnrollment(){
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Course Name\n Q to quit");
            String newCourse = scanner.nextLine();
            if (!newCourse.equals("Q")){
                 courses += " " + newCourse;
                 cartBalance += 600;

            } else break;
        } while ( 1!= 0);


    }


}*/

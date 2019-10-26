/*Name: Anureet Kaur
  Class: CSC 20- 01
  Description: This is the Student course class that that implements Comparable and Serializable. It has instance variables like units,
  name, grade, year, semester and course c.It compares various functionalities of those instance variables and calculates the grade.
  Date: 07/03/18
*/
import java.util.*;
import java.io.Serializable;
public class StudentCourse implements Comparable, Serializable
{
   //instance variables 
   private int units;
   private String name;
   private String grade;
   private int year;
   private String semester;
   private Course c;
   
   //constructor
   public StudentCourse(int units, String name, String grade, int year, String semester, Course c)
   {
      this.units = units;
      this.name = name;
      this.grade = grade;
      this.year = year;
      this.semester = semester;
      this.c = c;
   }
   
   //getter methods
   public int getUnits()
   {
      return this.units;
   }
   public String getGrade()
   {
      return this.grade;
   }
   
   public int getYear()
   {
      return this.year;
   }
   
   public String getSemester()
   {
      return this.semester;
   }
   
   public Course getC()
   {
      return this.c;
   }
   
   //setter methods
   public void setUnits(int units)
   {
      this.units = units;
   }
   public void setGrade(String grade)
   {
      this.grade = grade;
   }
   
   public void setYear(int year)
   {
      this.year = year;
   }
   
   public void setSemester(String semester)
   {
      this.semester = semester;
   }
   
   public void setC(Course c)
   {
      this.c = c;
   }
   
   //toString method
   public String toString()
   {
      return c.toString() + "\nGrade: " + grade + "\nYear: " + year + "\nSemester: " + semester;
   }
   
   //equals method
   public boolean equals(Object o)
   {
      StudentCourse s;
      if (o instanceof StudentCourse)
      {
         s = (StudentCourse) o;
         return this.grade.equalsIgnoreCase(s.grade) && this.year == s.year && this.semester.equals(s.semester);
      }
      else 
         return false;
   }
   
   //compareTo method
   public int compareTo(Object o)
   {
      if (o instanceof StudentCourse)
      {
         StudentCourse c = (StudentCourse) o;
         if(this.units > c.units)
            return 1;
         else if(this.units < c.units)
            return -1;
         else 
            return 0;
      }
      else 
         return Integer.MIN_VALUE;
   }
   
   //this method gets a string and returns the double of that letter grade
   public double calculateGrade(String s) {
       String ss = s.toUpperCase();
       switch(ss) {
           case "A":
               return 4.0;
           case "A-":
               return 3.7;
           case "B+":
               return 3.3;
           case "B":
               return 3.0;
           case "B-":
               return 2.7;
           case "C+":
               return 2.3;
           case "C":
               return 2.0;
           case "C-":
               return 1.7;
           case "D+":
               return 1.3;
           case "D":
               return 1.0;
           case "D-":
               return 0.7;
           case "F":
               return 0.0;
       }
       return -1.0;
   }
   
   //compares a specific name with course name
   public boolean compareName(String s) {
        return this.name.equalsIgnoreCase(s);
    }
      
   //compares a specific number with course number
   public boolean compareNum(int num) {
       return this.c.getNumber() == num;
   }
   
   
}


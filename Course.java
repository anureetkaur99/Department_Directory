/*Name: Anureet Kaur
  Class: CSC 20- 01
  Description: This is the Course class that implements Comparable and Serializable. It has instance variables like units, number,
  name, preRequisite, section and instructor and compares various functionalities of those instance variables.
  Date: 07/03/18
*/
import java.util.ArrayList;
import java.io.Serializable;
public class Course implements Comparable, Serializable
{
   //instance variables
   private int units;
   private int number;
   private String name;
   private Course preRequisite;
   private int section;
   private Person instructor;
   
   //constructor
   public Course(int units, String name, int number, Course preRequisite, int section, Person instructor)
   {
      this.units = units;
      this.number = number;
      this.name = name;
      this.preRequisite = preRequisite;
      this.section = section;
      this.instructor = instructor;
   }
   
   //generic constructor
   public Course (String name)
   {
      this.name = name;
   }
   
   
   //getter methods
   public int getUnits()
   {
      return this.units;
   }
   
   public int getNumber()
   {
      return this.number;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public Course getPreRequisite()
   {
      return this.preRequisite;
   }
   
   public int getSection()
   {
      return this.section;
   }
   
   public Person getInstructor()
   {
      return this.instructor;
   }
   
   //setter methods
   public void setUnits(int units)
   {
      this.units = units;
   }
   
   public void setNumber(int number)
   {
      this.number = number;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public void setPreRequisite(Course preRequisite)
   {
      this.preRequisite = preRequisite;
   } 
   
   public void setSection(int section)
   {
      this.section = section;
   }
   
   public void setInstructor(Person instructor)
   {
      this.instructor = instructor;
   }
   
   //equals method
   public boolean equals(Object o)
   {
      Course c;
      if (o instanceof Course)
      {
         c = (Course) o;
         return this.number == c.number; //compared based on the course number
      }
      else 
         return false;
   }
   
   //toString method
   public String toString()
   {
      return "\nUnits: " + units + "\nCourse Number: " + number + "\nName: " + name + "\nPre-requisite: " + preRequisite.getName() + "\nSection: " + section + "\nInstructor: " + instructor + "\n";
   }
   
   //compareTo method
   public int compareTo(Object o)
   {
      Course c;
      if (o instanceof Course)
      {
         c = (Course) o;
         if(this.number > c.number)
            return 1;
         else if(this.number < c.number)
            return -1;
         else 
            return 0;
      }
      else 
         return Integer.MIN_VALUE;
   }
  
   //compares a specific name with course name
   public boolean compareName(String s) {
        return this.name.equalsIgnoreCase(s);
   }
   
   //compares a specific number with course number
   public boolean compareNum(int num) {
       return this.number == num;
   }
   
   //compares a given instructor name with the text file instructors
   public boolean instructor(String s) {
       String instructor = this.instructor.getName() + " " + this.instructor.getLastName();
        return instructor.equalsIgnoreCase(s);
    }
}
/*Name: Shiwei Fang, Anureet Kaur
  Class: CSC 20- 01
  Description: This is the student class which extends person
    holds student specific info like grades, major classes taken
  Date: 07/03/18
*/
import java.io.Serializable;
public class Student extends Person implements Comparable, Serializable {
    private String major;
    private StudentCourseList myList;
    private int units;
    private int id;
    
    //constructor
    public Student(String first, String last, String major, int id) {
        super(first, last);
        this.major = major;
        this.id = id;
        this.units = majorUnits(major);
        this.myList = new StudentCourseList();
    }
    
    //getter
    public String getMajor() {
        return major;
    }
    
    public StudentCourseList getList() {
        return myList;
    }
    
    public int getUnits() {
        return units;
    }
    
    //calculates units for major based on major
    public int majorUnits(String s) {
        String ss = s.toUpperCase();
        switch(ss) {
            case "CSC":
                return 81;
            case "CPE":
                return 101;
            case "CE":
                return 99;
        }
        return 81;
    } 
    
    //calculates units completed based on classes which have scores
    public int unitsCompleted() {
        return myList.addUnits();
    }
    
    //calculates units left to complete in major
    public int unitsLeft() {
        return units - this.unitsCompleted();
    }
    
    //getter for ID
    public int getID() {
        return id;
    }
    
    //setters
    public void setMajor(String m) {
        major = m;
    }
    
    public void setList(StudentCourseList l) {
        myList = l;
    }
    
    public void setUnits(int u) {
        units = u;
    }
    
    public void setID(int i) {
        id = i;
    }
    
    //calls super method since equals checks same things (first and last names)
    public boolean equals(Object o) {
        return super.equals(o);
    }
    
    public String toString() {
        return super.toString() + "\nMajor: " + major + "\nMajor Units: " + units + "\nGPA: " + this.getGPA() + "\nStudent ID: " + id + "\n";
    }
    
    //calls super method since equals checks same things (first and last names)
    public int compareTo(Object o) {
        return super.compareTo(o);
    }
    
    //calculates GPA by traversing linked list instance variable mylist
    //converts letter grade to grade points and multiplies by units to properly weight GPA
    public double getGPA() {
        StudentCourseNode temp = myList.front;
        double gpa = 0.0;
        while(temp != null) {
            if(temp.course.calculateGrade(temp.course.getGrade()) > 0) {
               gpa += (temp.course.calculateGrade(temp.course.getGrade()) * 1.0 * temp.course.getUnits());
            }
            temp = temp.getNext(); 
        }
        return gpa / (this.unitsCompleted() * 1.0);
    }
    
    
    
}

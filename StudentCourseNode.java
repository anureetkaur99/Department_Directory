/*Name: Shiwei Fang, Anureet Kaur
  Class: CSC 20- 01
  Description: This is the studentcourse node for studentcourselist which holds studentcourses
  Date: 07/03/18
*/
import java.io.Serializable;
public class StudentCourseNode implements Serializable {
    public StudentCourse course;
    public StudentCourseNode next;
    
    //genric constuctor
    public StudentCourseNode() {
        course = null;
    }
    
    //constructor
    public StudentCourseNode(StudentCourse sc) {
        course = sc;
    }
    //setter
    public void setNext(StudentCourseNode n) {
        next = n;
    }
    //getter
    public StudentCourseNode getNext() {
        return next;
    }
    //getter
    public StudentCourse getStudentCourse() {
        return course;
    }
}

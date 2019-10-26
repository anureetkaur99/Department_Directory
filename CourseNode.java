/*Name: Anureet Kaur
  Class: CSC 20- 01
  Description: This is the CourseNode class for the CourseList class
  Date: 07/03/18
*/
import java.io.Serializable;
public class CourseNode implements Serializable
{
   //instance variables
   public Course c;
   public CourseNode next;
   
   //instantiates a node
   public CourseNode()
   {
      this.c = null;
   }
   //constructor
   public CourseNode(Course c)
   {
      this.c = c;
   }
   
   //returns the reference to the next node in the list
   public CourseNode getNext()
   {
      return this.next;
   }
   
   //set next to n
   public void setNext(CourseNode n)
   {
      next = n;
   }
   
   //return the course
   public Course getC()
   {
      return this.c;
   }
   
   //sets the C
   public void setC(Course c)
   {
      this.c = c;
   }
   
}
/*Name: Anureet Kaur
  Class: CSC 20- 01
  Description: This is the CourseList class that implements list methods and some additional methods as well.
  Date: 07/03/18
*/
import java.util.*;
import java.io.*;
import java.io.Serializable;
public class CourseList implements List, Comparable, Serializable
{
   //instance variables
   private CourseNode front;
   
   //generic constructor
   public CourseList() {
       front = null;
   }
   //instantiate the front to the course c
   public CourseList(CourseNode c)
   {
      front = c;
   }
   
   //getter method
   public CourseNode getFront() {
       return this.front;
   }
   
   //adds the object to the end of the list
   public void add(Object o)
   {
      CourseNode current = front;
      if (o instanceof Course)
      {
         Course s = (Course) o;
         CourseNode n = new CourseNode(s);
         while (current.getNext() != null)
         {
            current = current.getNext();
         }
         current.setNext(n);
      }
   }
   
   //removes the object from the list
   public void remove(Object o)
   {
      CourseNode current = front;
      CourseNode pre = current;
      if (o instanceof Course) {
         Course s = (Course) o;
         CourseNode n = new CourseNode(s);
         if (front.getC() == n.getC()) {
            front = front.getNext();
         }
         while (n.getC() != current.getC()) {
            pre = current;
            current = current.getNext();
         }
         pre.setNext(current.getNext());
      }
   }
   
   //inserts the object at the given position
   public void insert(int pos, Object o)
   {
      if (o instanceof Course)
      {
         Course s = (Course) o;
         CourseNode n = new CourseNode(s);
         CourseNode pre = front;
         CourseNode current = pre;
         int count = 0;
         while (pre != null && count < pos - 1)
         {
            current = pre;
            pre = pre.getNext();
            count++;
         }
         current.setNext(n);
         n.setNext(pre);
      }
   }
   
   //searches the object at the given position
   public Object search(Object o)
   {
     if (o instanceof Course)
      {
         Course s = (Course) o;
         CourseNode n = new CourseNode(s);
         CourseNode current = front;
         while (current != null)
         {
            if (current.getC().equals(n.getC()))
               return current.getC().toString();
            else 
               current = current.getNext();
         }
      }
      return "Not found";
   }
   
   //returns the size of the list
   public int size()
   {
      CourseNode s = front;
      int size = 0;
      while (s != null)
      {
         s = s.getNext();
         size++;
      }
      return size;
   }
   
   //sorts the element in the list
   public void sort()
   {
      int count = 0;
      CourseNode copy = front;
      while(copy!=null) {
         copy = copy.getNext();
         count++;
      }
      if (count > 1) {
         for (int i = 0; i < count; i++ ) {
            CourseNode current = front;
            CourseNode pre = front.getNext();
            for (int j = 0; j < count - 1; j++) {
               if (current.getC().compareTo(pre.getC()) > 0) {
                  Course temp = current.getC();
                  current.setC(pre.getC());
                  pre.setC(temp);
               }   
               current = pre;
               pre = pre.getNext();
            } 
         }
      }
   }
   
   //returns a copy of the list
   public Object copy()
   {
       CourseList c = new CourseList(front);
       CourseNode current = front;
       while (current != null)
       {
          c.add(current.getC());
          current = current.getNext();
       }
       return c; 
   }
   
   //determines if the list is empty or not
   public boolean isEmpty()
   {
      return front == null;
   }
   
   //adds the object to the beginning of the list
   public void addFirst(Object o)
   {
      CourseNode current = front;
      if (o instanceof CourseNode)
      {
         CourseNode n = (CourseNode) o;
         n.setNext(current);
         front = n;
      }
   }
   
   //returns a string representing the objects store in the list
   public String toString()
   {
      CourseNode current = front;
      String s = "";
      while (current != null)
      {
         s += current.getC();
         current = current.getNext();
      }
      return s;
   }
   
   //compare method
   public int compareTo(Object o)
   {
      if (o instanceof CourseList)
      {
         CourseList s = (CourseList) o;
         //when sizes are not the same
         if (s.size() != this.size())
         {
            if (s.size() > this.size())
               return 1;
            else if (s.size() < this.size())
               return -1;
         }
         //when sizes are same, then we compare each element
         CourseNode one = this.front;
         CourseNode two = s.front;
         while (one != null && two != null)
         {
            if (one.getC().compareTo(two.getC()) != 0)
               return one.getC().compareTo(two.getC());
            else 
            {
               one = this.front.getNext();
               two = s.front.getNext();
            }
         }
      }
      return Integer.MIN_VALUE;
   }
   
   //checks if that course exists using string
    public boolean exists(String s) {
        CourseNode temp = front;
        while(temp != null) {
            if(temp.c.compareName(s)) return true;
            else temp = temp.getNext();
        }
        return false;
    }
    
    //checks if that course exists using int
    public boolean exists(int num) {
        CourseNode temp = front;
        while(temp != null) {
            if(temp.c.compareNum(num)) return true;
            else temp = temp.getNext();
        }
        return false;
    }
    
    //when it finds the course number, it returns the course
    public Course convert(int num) {
        CourseNode temp = front;
        while(temp != null) {
            if(temp.c.compareNum(num)) return temp.c;
            else temp = temp.getNext();
        }
        return temp.c;
    }
    
    //checks if the course is same as in the text file
    public String sameName(String s) {
        String ss = "";
        CourseNode temp = front;
        while(temp != null) {
            if(temp.c.compareName(s)) {
                ss += temp.c.toString();
            }
            temp = temp.getNext();
        }
        return ss;
    }
    
    //checks if the instructor is same as in the text file
    public String sameInstructor(String s) {
        String ss = "";
        CourseNode temp = front;
        while(temp != null) {
            if(temp.c.instructor(s)) {
                ss += temp.c.toString();
            }
            temp = temp.getNext();
        }
        return ss;
    }
    
    
}
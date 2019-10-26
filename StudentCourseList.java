/*Name: Anureet Kaur, Shiwei Fang
  Class: CSC 20- 01
  Description: This is the studentcourselist which holds studentcoursenodes which hold studentcourses 
    which hold student specific info on courses
  Date: 07/03/18
*/
import java.io.Serializable;
public class StudentCourseList implements List, Comparable, Serializable {
    public StudentCourseNode front;
    private int count;
    
    //null constructor
    StudentCourseList () {
        front = null;
    }
    StudentCourseList (StudentCourseNode c) {
        front = c;
        count = 1;
    }
    
    //returns front
    public StudentCourseNode getFront() {
        return front;
    }
    
    //adds course to end of linkedlist
    public void add(Object o){
        if(o instanceof StudentCourse) {
            StudentCourse sc = (StudentCourse) o;
            StudentCourseNode c = new StudentCourseNode(sc);
            StudentCourseNode copy = front;
            while(copy.getNext() != null) {
                copy = copy.getNext();
            }
            copy.setNext(c);
            count++;
        } else {
            System.out.println("Please enter a valid course");
        }
    }
    
    //removes course with specified course number
    public void removeNum(int num)
    {
      if(front != null && size() != 0 && size() != 1)
      {
         Course n;
         StudentCourseNode current = front;
         StudentCourseNode pre = current;
         while (current.course.getC().getNumber() != num)
         {
            pre = current;
            current = current.next;
         }
         if (pre == front && current == front)
            front = current.next;
         else
            pre.setNext(current.next);
      }
      else if(size() == 1)
         front = null;
      else
         System.out.print("The Course you entered does not exist\n");
   }    
    
    //removes first instance of specified course
    public void remove(Object o){
        StudentCourseNode current = front;
        StudentCourseNode pre = current;
        if (o instanceof StudentCourse) {
           StudentCourse s = (StudentCourse) o;
           StudentCourseNode n = new StudentCourseNode(s);
           if (front.course == n.course) {
              front = front.next;
           }
           while (n.course != current.course) {
              pre = current;
              current = current.next;
           }
           pre.setNext(current.next);
        }
    }
    
    //inserts course at specified index
    public void insert(int pos, Object o){
        if(o instanceof StudentCourse && pos <= count + 1) {
            StudentCourse sc = (StudentCourse) o;
            StudentCourseNode n = new StudentCourseNode(sc);
            StudentCourseNode copy = front;
            pos--;
            for(int i = 1; i <= count; i++) {
                if(i == pos) {
                    StudentCourseNode temp = copy.getNext();
                    copy.setNext(n);
                    n.setNext(temp);
                    break;
                }
                copy = copy.getNext();
            }
            count++;
            } else {
            System.out.println("Please enter valid numbers");
        }
    }
    
    //searches for specified course
    public Object search(Object o){
        if(o instanceof StudentCourse) {
            StudentCourse sc = (StudentCourse) o;
            StudentCourseNode temp = front;
            while(temp != null) {
                if(temp.course.equals(sc)) return temp;
                else temp = temp.getNext();
            }
        }
        return "Not Found";
    }
    
    //returns size of linkedlist
    public int size(){
        return count;
    }
    
    //inserts course at specified index
    public void insert(Object o, int pos){
        if(o instanceof StudentCourse && pos <= count + 1) {
            StudentCourse sc = (StudentCourse) o;
            StudentCourseNode n = new StudentCourseNode(sc);
            StudentCourseNode copy = front;
            pos--;
            for(int i = 1; i <= count; i++) {
                if(i == pos) {
                    StudentCourseNode temp = copy.getNext();
                    copy.setNext(n);
                    n.setNext(temp);
                    break;
                }
                copy = copy.getNext();
            }
            count++;
            } else {
            System.out.println("Please enter valid numbers");
        }
    }
    
    //basic sorting algorithm
    public void sort() {
        if (count > 1) {
            for (int i = 0; i < count; i++ ) {
                StudentCourseNode curr = front;
                StudentCourseNode next = front.next;
                for (int j = 0; j < count - 1; j++) {
                    if (curr.course.compareTo(next.course) > 0) {
                        StudentCourse temp = curr.course;
                        curr.course = next.course;
                        next.course = temp;
                    } 
                    curr = next;
                    next = next.next;                   
                } 
            }
        }
    }
    
    //copies list and returns copy
    public StudentCourseList copy(){
        StudentCourseList copy = new StudentCourseList();
        StudentCourseNode temp = front;
        copy.front = new StudentCourseNode(front.course);
        StudentCourseNode ctemp = copy.front;
        while(temp.next != null) {
            temp = temp.next;
            ctemp.next = new StudentCourseNode(temp.course);
            ctemp = ctemp.next;
        }
        return copy;
    }
    
    //checks if list is empty
    public boolean isEmpty(){
        return front == null;
    }
    
    //adds course to front of list
    public void addFirst(Object o){
        if(o instanceof StudentCourse) {
            StudentCourse sc = (StudentCourse) o;
            StudentCourseNode n = new StudentCourseNode(sc);
            n.setNext(front);
            front = n;
            count++;
         } else {
            System.out.println("Please enter a valid number");
            }
    }

    public String toString(){
        String s = "";
        StudentCourseNode copy = front;
        while(copy.getNext() != null) {
            s = s + copy.course.toString();
            copy = copy.next;
        }
        s = s + copy.course.toString();
        return s;
    }
    
    //checks if course exists in list based on name
    public boolean exists(String s) {
        StudentCourseNode temp = front;
        while(temp != null) {
            if(temp.course.compareName(s)) return true;
            else temp = temp.getNext();
        }
        return false;
    }
    
    //looks for class in list based on name and sees if course has been passed before
    public boolean passed(String s) {
        StudentCourseNode temp = front;
        while(temp != null) {
            if(temp.course.compareName(s)) return temp.course.calculateGrade(temp.course.getGrade()) > 0;
            else temp = temp.getNext();
        }
        return false;
    }
    
    //looks for class in list based on number and sees if course has been passed before
    public boolean passed(int num) {
        StudentCourseNode temp = front;
        while(temp != null) {
            if(temp.course.compareNum(num)) return temp.course.calculateGrade(temp.course.getGrade()) > 0;
            else temp = temp.getNext();
        }
        return false;
    }
    
    //adds all units of courses in list together
    public int addUnits() {
        StudentCourseNode temp = front;
        int unit = 0;
        while(temp != null) {
            if(temp.course.calculateGrade(temp.course.getGrade()) > 0) {
               unit += temp.course.getUnits();
            }
            temp = temp.getNext();
        }
        return unit;
    }
    
    //compares two different lists
    public int compareTo(Object o)
   {
      if (o instanceof StudentCourseList)
      {
         StudentCourseList s = (StudentCourseList) o;
         //when sizes are not the same
         if (s.size() != this.size())
         {
            if (s.size() > this.size())
               return 1;
            else if (s.size() < this.size())
               return -1;
         }
         //when sizes are same, then we compare each element
         StudentCourseNode one = this.front;
         StudentCourseNode two = s.front;
         while (one != null && two != null)
         {
            if (one.course.compareTo(two.course) != 0)
               return one.course.compareTo(two.course);
            else 
            {
               one = this.front.getNext();
               two = s.front.getNext();
            }
         }
      }
      return Integer.MIN_VALUE;
   }
   
    //checks if class has a passing grade or not
   public boolean hasGrade(int num) {
      StudentCourseNode temp = front;
      while (temp != null) {
         if (temp.course.getC().getNumber() == num) {
            return temp.course.calculateGrade(temp.course.getGrade()) > 0;
         }
         temp = temp.next;
      }
      return false;
   }  
}

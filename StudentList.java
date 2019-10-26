/*Name: Shiwei Fang, Anureet Kaur
  Class: CSC 20- 01
  Description: This is the studentlist which holds all students within it
  Date: 07/03/18
*/
import java.io.Serializable;
import java.util.ArrayList;


public class StudentList implements List, Comparable, Serializable {
    private ArrayList<Student> list = new ArrayList<>();
    
    //returns list
    public ArrayList<Student> getList() {
        return list;
    }
    
    //adds student to end of list
    public void add(Object o) {
        if(o instanceof Student) {
            Student s = (Student) o;
            list.add(s);
        } else {
            System.out.println("Please enter a valid student");
        }
    }
    
    //removes first specified student from the list
    public void remove(Object o) {
        if(o instanceof Student) {
            Student s = (Student) o;
            list.remove(s);
        } else {
            System.out.println("Please enter a valid student");
        }
    }
    
    //inserts student at specified index
    public void insert(int pos, Object o) {
        if(o instanceof Student && pos >= 0 && pos < list.size()) {
            Student s = (Student) o;
            list.add(pos, s);
        } else {
            System.out.println("Please enter a valid student");
        }
    }
    
    //returns list size
    public int size() {
        return list.size();
    }
    
    //inserts student at specified index
    public void insert(Object o, int pos) {
        if(o instanceof Student && pos >= 0 && pos < list.size()) {
            Student s = (Student) o;
            list.add(pos, s);
        } else {
            System.out.println("Please enter a valid student");
        }
    }
    
    //copies list and returns copy
    public Object copy()
   {
      ArrayList<Student> a = new ArrayList<Student>();
      for(int i=0; i<a.size(); i++)
      {
         a.add(list.get(i));
      }
      return a;
   }
    
    //checks if list is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    //adds student to front of list
    public void addFirst(Object o) {
        if(o instanceof Student) {
            Student s = (Student) o;
            list.add(0, s);
        } else {
            System.out.println("Please enter a valid student");   
        }
    }
    
    public String toString() {
        String s = "";
        for(int i = 0; i < list.size(); i++) {
            s += list.get(i).toString();
        }
        return s;
    }
    
    //finds student in list
    public Object search(Object o)
   {
      String stu;
      if(o instanceof String)
      {
         stu = (String) o;
         int i = 0;
         while(i != list.size())
         {
            if(list.get(i).getName().equalsIgnoreCase(stu))
               return i + "";
            else 
               i++;
         }
      }
      return "No Such Person Found";
   }
    
    //basic sort algorithm
    public void sort() {
        for(int i = 1; i < list.size(); i++) {
            for(int j = i; j > 0; j--) {
                if(list.get(j).compareTo(list.get(j - 1)) < 0) {
                    Student temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
    
    //compares two lsits together
    public int compareTo(Object o)
   {
      int a = 0;
      Student n;
      n = (Student)o;
      for(int i=0; i<list.size(); i++)
      {
         a = list.get(i).compareTo(n);
         if(a!=0)
            return Integer.MIN_VALUE;
      }
      return a;
   }
}

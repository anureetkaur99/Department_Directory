/*Name: Shiwei Fang, Anureet Kaur
  Class: CSC 20- 01
  Description: This is the Person class, which holds basic person information (first name, last name)
  Date: 07/03/18
*/
import java.io.Serializable;

public class Person implements Comparable, Serializable {
    private String name;
    private String lastName;
    
    //constructor
    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    
    //getter
    public String getName() {
        return name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    //setter
    public void setName(String s) {
        this.name = s;
    }
    
    public void setLastName(String s) {
        this.lastName = s;
    }
    
    //equals method checks names
    public boolean equals(Object o) {
        if(o instanceof Person) {
            Person p = (Person) o;
            return this.name.equalsIgnoreCase(p.name) && this.lastName.equalsIgnoreCase(p.lastName);
        } else {
            return false;
        }
    }
    
    public String toString() {
        return "\n" + this.name + " " + this.lastName;
    }
    
    //compareTo compares last names as long as they are not equal
    //compares first names if last names are equal
    public int compareTo(Object o) {
        if(o instanceof Person) {
            Person p = (Person) o;
            if(this.lastName.compareTo(p.lastName) != 0)
                return this.lastName.compareTo(p.lastName);
            else return this.name.compareTo(p.name);
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
}

/*Name: Shiwei Fang, Anureet Kaur
  Class: CSC 20- 01
  Description: This is the List interface class for all List related classes
  Date: 07/03/18
*/
import java.io.Serializable;
public interface List {
    public void add(Object o);
    public void remove(Object o);
    public void insert(int pos, Object o);
    public Object search(Object o);
    public int size();
    public void sort();
    public Object copy();
    public boolean isEmpty();
    public void addFirst(Object o);
    public String toString();
}

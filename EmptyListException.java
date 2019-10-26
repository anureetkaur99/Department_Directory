/*Name: Anureet Kaur
  Class: CSC 20- 01
  Description: This is the cumstom made exception class that extends exception
  Date: 07/03/18
*/

public class EmptyListException extends Exception {
   //default constructor
   public EmptyListException() {
      super();
   }
   
   //constructor with the message
   public EmptyListException(String message) {
      super(message);
   }
}
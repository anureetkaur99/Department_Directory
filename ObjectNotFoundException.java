/*Name: Anureet Kaur
  Class: CSC 20- 01
  Description: This is the cumstom made exception class that extends exception
  Date: 07/03/18
*/

public class ObjectNotFoundException extends Exception {
   //default constructor
   public ObjectNotFoundException() {
      super();
   }
   
   //constructor with the message
   public ObjectNotFoundException(String message) {
      super(message);
   }
}
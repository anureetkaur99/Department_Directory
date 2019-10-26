/*Name: Anureet Kaur
  Class: CSC 20- 01
  Description: This is the main driver of the CSC Department Project 
  Date: 07/03/18
*/
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
     
    //main method: checks for serializable, calls the menu method
    public static void main (String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, EmptyListException, ObjectNotFoundException {
        CourseList clist = null;
        StudentList slist = new StudentList();
        File s = new File("Stu.dat");
        File c = new File("Courses.dat");
        if (!s.exists()) 
           slist = studentPopulate();
        if (!c.exists())
           clist = coursePopulate();
        if (s.exists()) {
           ObjectInputStream extra = new ObjectInputStream(new FileInputStream("Stu.dat"));
           slist = (StudentList)extra.readObject();
        }
        if (c.exists()) {
           ObjectInputStream extra1 = new ObjectInputStream(new FileInputStream("Courses.dat"));
           clist = (CourseList)extra1.readObject();
        }
        menu(slist, clist);
    }
    
    //populates the student list arraylist, implements serializable
    public static StudentList studentPopulate() throws IOException, EmptyListException, ObjectNotFoundException {
        File f = new File("Stu.txt");
        Scanner input = new Scanner(f);
        StudentList slist = new StudentList();
        while(input.hasNextLine()) {
            String line = input.nextLine();
            Scanner token = new Scanner(line);
            String first = token.next();
            String last = token.next();
            int id = token.nextInt();
            String major = token.next();
            Student s = new Student(first, last, major, id);
            slist.add(s);
        }
        //serializable
        ObjectOutputStream space = new ObjectOutputStream(new FileOutputStream("Stu.dat"));
        space.writeObject(slist);
        space.close();
        return slist;
    }
    
    //populates the courselist linked list, implements serializable
    public static CourseList coursePopulate() throws IOException, EmptyListException, ObjectNotFoundException {
        File f = new File("Courses.txt");
        //the first node
        Course none = new Course("not applicable");
        Person prof = new Person("Holly", "Tajlil");
        Course one = new Course(3, "CSC10", 12345, none, 01, prof);
        CourseNode one1 = new CourseNode(one);
        CourseList clist = new CourseList(one1);
        Scanner input = new Scanner(f);
        //adding the rest in the linked list
        while(input.hasNextLine()) {
            String line = input.nextLine();
            Scanner token = new Scanner(line);
            int units = Integer.parseInt(token.next());
            String name = token.next();
            int num = token.nextInt();
            String pre = token.next();
            Course preC = new Course(pre);
            int section = token.nextInt();
            String first = token.next();
            String last = token.next();
            Person instructor = new Person(first, last);
            Course c = new Course(units, name, num, preC, section, instructor);
            clist.add(c);
        }
        //serializable
        ObjectOutputStream space = new ObjectOutputStream(new FileOutputStream("Courses.dat"));
        space.writeObject(clist);
        space.close();
        return clist;
    }
    
    //menu method that prints all the options, performs data validation, and serializable
    public static void menu(StudentList slist, CourseList clist) throws IOException, EmptyListException, ObjectNotFoundException {
        Scanner kb = new Scanner(System.in);
        int option = -1;
        do {
            System.out.println("Welcome to the Course Portal");
            System.out.println("1. List all students");
            System.out.println("2. List all courses");
            System.out.println("3. Student options");
            System.out.println("4. Admin options");
            System.out.println("5. Exit program");
            System.out.print("Please select an option from the menu (1 - 5): ");
            option = dataValid(kb);
            //checking if there are options other than 1-5
            while (option < 0 && option > 5) {
               while (!kb.hasNextInt()) {
                   kb.nextLine();
                   System.out.print("Please enter a valid number: ");
               }
               option = kb.nextInt();
            }
            if(option == 1) {
               slist.sort();
               System.out.println(slist);
            }
            else if(option == 2) {
               clist.sort();
               System.out.println(clist);
            }
            else if(option == 3) studentMenu(slist, clist);
            else if(option == 4) adminMenu(slist, clist);
            else if(option != 5){
                System.out.println("Invalid, Try again!\n");
            }
        } while(option != 5);
        System.out.println("Thank you!");
        
        //serializable
        ObjectOutputStream place = new ObjectOutputStream(new FileOutputStream("Stu.dat", false));
        place.writeObject(slist);
        place.close();
        ObjectOutputStream place1 = new ObjectOutputStream(new FileOutputStream("Courses.dat", false));
        place1.writeObject(clist);
        place1.close();
    }
    
    //prints the student menu options, performs data validation
    public static void studentMenu(StudentList slist, CourseList clist) throws EmptyListException, ObjectNotFoundException {
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter your student ID: ");
        int id = dataValid(kb);
        int option = -1;
        ArrayList<Student> list = slist.getList();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getID() == id) {
                do {
                //options in the student menu
                    System.out.println(list.get(i));
                    System.out.println("Please select an option: ");
                    System.out.println("1. Display list of courses taken");
                    System.out.println("2. Display GPA");
                    System.out.println("3. Add course");
                    System.out.println("4. Remove course");
                    System.out.println("5. Display units completed");
                    System.out.println("6. Display units left");
                    System.out.println("7. List all courses taught by an instructor");
                    System.out.println("8. List all course sections of a particular course");
                    System.out.println("9. Exit menu");
                    option = dataValid(kb);
                    //checks to see options are between 1-9
                    while (option < 0 && option > 9) {
                       while (!kb.hasNextInt()) {
                           kb.nextLine();
                           System.out.print("Please enter a valid number: ");
                       }
                       option = kb.nextInt();
                    }
                    if(option == 1) { 
                    //checks empty method if there are any coures taken
                        if (list.get(i).getList().isEmpty()) {
                           System.out.println("No courses taken\n");
                        }
                        else {
                           System.out.println("Courses Taken:\n" + list.get(i).getList());
                        }
                    }
                    else if(option == 2) System.out.printf("%.2f" , list.get(i).getGPA());
                    else if(option == 3) {
                        //asks for all the info about the course that the user wants to add
                        System.out.println("Enter the course number you would like to add: ");
                        int num = dataValid(kb);
                        if(clist.exists(num)) {
                            if(prereq(num, list.get(i).getList(),clist) || clist.convert(num).getName().equalsIgnoreCase("CSC10")) {
                                if(!list.get(i).getList().passed(num)) {
                                    System.out.println("How many units is this class? ");
                                    int units = dataValid(kb);
                                    System.out.println("What year did you take this class? ");
                                    int year = dataValid(kb);
                                    kb.nextLine();
                                    System.out.println("What grade did you receive in this class? ");
                                    String grade = kb.nextLine();
                                    System.out.println("Which semester did you take this class? ");
                                    String sem = kb.nextLine();
                                    StudentCourse sc = new StudentCourse(units, clist.convert(num).getName(),grade, year, sem, clist.convert(num));
                                    if(list.get(i).getList().isEmpty()) {
                                        StudentCourseNode scn = new StudentCourseNode(sc);
                                        list.get(i).getList().front = scn;
                                    } else {
                                        list.get( i ).getList().add( sc );
                                    }
                                    System.out.println(list.get(i).getList().toString());
                                } else System.out.println("Cannot remove course already taken!");
                            } else System.out.println("Prerequisites not met!");
                        } else System.out.println("Course does not exist!");
                    }
                    else if(option == 4) {
                    //removes only if the course exists in the student mylist
                        System.out.println("What course number would you like to remove? ");
                        int remove = dataValid(kb);
                        if (!clist.isEmpty()) {
                           if (clist.exists(remove)) {
                              if (!list.get(i).getList().hasGrade(remove)) {
                                 list.get(i).getList().removeNum(remove);
                              }
                           }
                        }
                    }
                    //prints units left and completed
                    else if(option == 5) System.out.println("Units Completed: " + list.get(i).unitsCompleted());
                    else if(option == 6) System.out.println("Units left: " + list.get(i).unitsLeft());
                    else if(option == 7) {
                        System.out.print("Which instructor's classes would you like to search? ");
                        String instructor = kb.nextLine();
                        System.out.println(clist.sameInstructor(instructor));
                    } else if(option == 8) {
                        System.out.print("Which sections would you like to search? ");
                        String course = kb.nextLine();
                        System.out.println(clist.sameName(course));
                    } else if(option != 9) System.out.println("Please enter a valid option");
                } while(option != 9);
            }
        }
    }
    
    //prints the admin menu options, performs data validation
    public static void adminMenu(StudentList slist, CourseList clist) throws EmptyListException, ObjectNotFoundException {
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter admin password: ");
        String pass = kb.nextLine();
        int option = -1;
        //prompts access denied if the correct password is not entered
        if(pass.equals("password")) {
            do{
                System.out.println("Please select an option: ");
                System.out.println("1. Add a new course");
                System.out.println("2. Remove a course");
                System.out.println("3. Add a new student");
                System.out.println("4. Exit menu");
                option = dataValid(kb);
                //checks if options are between 1-4
                while (option < 0 && option > 4) {
                       while (!kb.hasNextInt()) {
                           kb.nextLine();
                           System.out.print("Please enter a valid number: ");
                       }
                       option = kb.nextInt();
                }
                if(option == 1) {
                //asks the admin user to enter all info about the course
                    System.out.print("Please enter the number of units for this course: ");
                    int unit = dataValid(kb);
                    System.out.print("Please enter the course number: ");
                    int num = dataValid(kb);
                    System.out.print("Please enter the section for this course: ");
                    int section = dataValid(kb);
                    kb.nextLine();
                    System.out.print("Please enter the name for this course: ");
                    String name = kb.nextLine();
                    System.out.print("Please enter the prerequisite for this course: ");
                    String pre = kb.nextLine();
                    Course prereq = new Course(pre);
                    System.out.print("Please enter the first name of the instructor for this course: ");
                    String first = kb.nextLine();
                    System.out.print("Please enter the last name of the instructor for this course: ");
                    String last = kb.nextLine();
                    Person p = new Person(first, last);
                    Course c = new Course(unit, name, num, prereq, section, p);
                    if (!clist.exists(num)) {
                       clist.add(c);
                       System.out.println("The course is added");
                    }
                    else {
                       System.out.println("The course already exists");
                    }
                    clist.add(c);
                } else if(option == 2) {
                 //asks the admin user to enter info to remove the course
                    System.out.print("Please enter the course number you'd like to delete");
                    int num = dataValid(kb);
                    if(clist.exists(num)) {
                        Course x = clist.convert(num);
                        clist.remove(x);
                    } else System.out.println("Please enter valid course to remove");
                } else if(option == 3) {
                //asks the admin user to enter all info about the student
                    System.out.print("What is the id of this student? ");
                    int id = dataValid(kb);
                    kb.nextLine();
                    System.out.print("What is the first name of this student? ");
                    String name1 = kb.nextLine();
                    System.out.print("What is the last name of this student? ");
                    String name2 = kb.nextLine();
                    System.out.print("What is the major of this student? ");
                    String major = kb.nextLine();
                    Student ss = new Student(name1, name2, major, id);
                    slist.add(ss); 
                } else if (option != 4) System.out.println("Please enter a valid number: ");
            } while(option != 4);
        }
        else 
            System.out.println("\nAccess Denied\n");
    }
    
    //checks for prerequisite
    public static boolean prereq(int num, StudentCourseList slist, CourseList clist) throws EmptyListException, ObjectNotFoundException{
        CourseNode temp = clist.getFront();
        while(temp != null) {
            if(temp.c.compareNum(num)) {
                String ss = temp.c.getPreRequisite().getName();
                return slist.exists(ss);
            }
            else temp = temp.getNext();
        }
        return false;
    } 
    
    //data validation method
    public static int dataValid(Scanner kb) {
       while(!kb.hasNextInt()) {
          kb.next();
          System.out.println("Invalid input. Try again!");
       }
       int input = kb.nextInt();
       return input;
    }
    
}
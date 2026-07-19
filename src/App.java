import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("admin", "101ff01010"));

        ArrayList<Student> students = new ArrayList<Student>();

        System.out.println("=== Welcome to Student Management System ===");

        System.out.print("Enter Username: ");
        String enterUsername = sc.nextLine();
        System.out.print("Enter Password: ");
        String enterPassword = sc.nextLine();

        User currentUser = null;

        for (User u : users) {
            if (u.getUsername().equals(enterUsername)) {
                if (u.checkPassword(enterPassword)) {
                    currentUser = u;
                }
            }
        }

        if (currentUser == null) {
            System.out.println("Login failed. Wrong username or password.");
            return; 
        }

        System.out.println("Login successful! Welcome, " + currentUser.getUsername());

       
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Subject to Student");
            System.out.println("4. Add Mark to Subject");
            System.out.println("5. View Student Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Enter student ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                Student newStudent = new Student(id, name);
                students.add(newStudent);
                System.out.println("Student added successfully!");

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No students yet.");
                } else {
                    for (Student s : students) {
                        System.out.println("ID: " + s.getId() + " - Name: " + s.getName());
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter student ID: ");
                int id = Integer.parseInt(sc.nextLine());
                Student found = null;

                for (Student s : students) {
                    if (s.getId() == id) {
                        found = s;
                    }
                }

                if (found == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.print("Enter subject ID: ");
                    int subId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter subject name: ");
                    String subName = sc.nextLine();

                    Subject newSubject = new Subject(subId, subName);
                    found.addSubject(newSubject);
                    System.out.println("Subject added to student!");
                }

            } else if (choice == 4) {
                System.out.print("Enter student ID: ");
                int id = Integer.parseInt(sc.nextLine());
                Student foundStudent = null;

                for (Student s : students) {
                    if (s.getId() == id) {
                        foundStudent = s;
                    }
                }

                if (foundStudent == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.print("Enter subject ID: ");
                    int subId = Integer.parseInt(sc.nextLine());
                    Subject foundSubject = null;

                    for (Subject sub : foundStudent.getSubjects()) {
                        if (sub.getSubjectId() == subId) {
                            foundSubject = sub;
                        }
                    }

                    if (foundSubject == null) {
                        System.out.println("Subject not found for this student.");
                    } else {
                        System.out.print("Enter term (Term1/Term2/Term3): ");
                        String term = sc.nextLine();
                        System.out.print("Enter score: ");
                        double score = Double.parseDouble(sc.nextLine());

                        Mark newMark = new Mark(term, score);
                        foundSubject.addMark(newMark);
                        System.out.println("Mark added!");
                    }
                }

            } else if (choice == 5) {
                System.out.print("Enter student ID: ");
                int id = Integer.parseInt(sc.nextLine());
                Student foundStudent = null;

                for (Student s : students) {
                    if (s.getId() == id) {
                        foundStudent = s;
                    }
                }

                if (foundStudent == null) {
                    System.out.println("Student not found.");
                } else {
                    System.out.println("Report for: " + foundStudent.getName());
                    for (Subject sub : foundStudent.getSubjects()) {
                        System.out.println("  Subject: " + sub.getSubjectName());
                        for (Mark m : sub.getMarks()) {
                            System.out.println("    " + m.getTerm() + ": " + m.getScore());
                        }
                    }
                }

            } else if (choice == 6) {
                running = false;
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid option, try again.");
            }
        }
    }
}
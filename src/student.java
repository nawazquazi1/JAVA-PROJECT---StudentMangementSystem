import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class student {
    private String firstName;
    private String lastName;
    private int gradeLevel;
    private String studentId;
    private int balance = 0;
    private static int cost = 600;
    private static int id = 1000;
    private ArrayList<String> course;

    public student() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student First Name : ");
        this.firstName = sc.nextLine();

        System.out.print("Enter Student Last Name : ");
        this.lastName = sc.nextLine();

        System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior \nEnter Student Class Level :");
        int i = sc.nextInt();
        if (i < 5) {
            this.gradeLevel = i;
        } else {
            System.out.println("Invalid class level \n plz choice the valid class level ");
            return;
        }
        setStudentId();
        enroll();
        System.out.println("Your Selected Course : " + this.course);
        System.out.print("Plz pay the fees : $");
        payFees();
    }

    // generate an id
    private void setStudentId() {
        id++;
        this.studentId = gradeLevel + "" + id;
    }

    // Enroll in Courses
    public void enroll() {
        Scanner sc = new Scanner(System.in);
        course = new ArrayList<>();
        do {
            System.out.println("Enter Course to Enroll \n1 - History 101 \n2 - Mathematics 101 \n3 - English\n4 - Computer Science 101 \n5 - Chemistry \n0 - Quit");
            int Chose = sc.nextInt();
            switch (Chose) {
                case 1 -> {
                    this.course.add("History 101");
                    balance += cost;
                }
                case 2 -> {
                    this.course.add("Mathematics");
                    balance += cost;
                }
                case 3 -> {
                    this.course.add("English");
                    balance += cost;
                }
                case 4 -> {
                    this.course.add("Computer Science");
                    balance += cost;
                }
                case 5 -> {
                    this.course.add("Chemistry");
                    balance += cost;
                }
                case 0 -> {
                    System.out.println("BREAK");
                    return;
                }
                default -> {
                    this.course.add("Course not available");
                }
            }
        } while (true);
    }

    // Vive Balance
    public void viveBalance()
    {
        System.out.println(this.balance);
    }

    // pay Fees
    public void payFees() {
        viveBalance();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your payment : $");
        do {
            System.out.print("REEnter Your payment : $");
            int payment = sc.nextInt();
            if (payment == this.balance) {
                balance -= payment;
                System.out.println("Thank You For Your Payment of $" + payment);
                return;
            } else {
                System.out.println("------ PLZ PAY FULL FEES ------");
            }
        } while (true);
    }

    public void showInfo() {
        System.out.println("\nstudentId : "+studentId+"Name : " + firstName + lastName + "\ngradeLevel : "+gradeLevel+"\nCourses Enrolled : " + course + "\nBalance : $" + balance);

    }

}

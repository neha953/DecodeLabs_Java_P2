import java.util.Scanner;

public class DecodeLabs_Java_P2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("   DECODELABS - STUDENT GRADE CALCULATOR  ");
        System.out.println("==========================================");

        // Student name lo
        System.out.print("\nEnter Student Name: ");
        String studentName = sc.nextLine();

        // Kitne subjects hain
        int numSubjects = 0;
        while (true) {
            System.out.print("How many subjects? ");
            try {
                numSubjects = Integer.parseInt(sc.nextLine());
                if (numSubjects <= 0) {
                    System.out.println("❌ Enter at least 1 subject!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("❌ Invalid! Enter a number.");
            }
        }

        // Har subject ke marks lo
        int totalMarks = 0;
        String[] subjectNames = {"Math", "English", "Science", "Urdu",
                                  "Computer", "Physics", "Chemistry",
                                  "Biology", "History", "Geography"};

        System.out.println("\n--- Enter Marks (0 to 100) ---");

        for (int i = 0; i < numSubjects; i++) {
            String subjectLabel = (i < subjectNames.length) 
                                   ? subjectNames[i] 
                                   : "Subject " + (i + 1);
            int marks = -1;

            while (true) {
                System.out.print(subjectLabel + ": ");
                try {
                    marks = Integer.parseInt(sc.nextLine());

                    // Validation - 0 se 100 ke beech hona chahiye
                    if (marks < 0 || marks > 100) {
                        System.out.println("❌ Invalid! Marks must be 0-100. Try again.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("❌ Invalid! Enter numbers only.");
                }
            }

            totalMarks += marks;
        }

        // Average calculate karo - type casting zaruri hai!
        double average = (double) totalMarks / numSubjects;

        // Grade assign karo - Logic Ladder
        String grade;
        String remarks;

        if (average >= 90) {
            grade = "A+";
            remarks = "Outstanding! 🌟";
        } else if (average >= 80) {
            grade = "A";
            remarks = "Excellent! 🎉";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Good Work! 👍";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Satisfactory";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Needs Improvement";
        } else {
            grade = "F";
            remarks = "FAIL - Please study harder";
        }

        // Pass ya Fail
        String status = (average >= 50) ? "✅ PASS" : "❌ FAIL";

        // Result display karo - printf se clean formatting
        System.out.println("\n==========================================");
        System.out.println("            RESULT CARD                  ");
        System.out.println("==========================================");
        System.out.printf("Student Name  : %s%n", studentName);
        System.out.printf("Total Subjects: %d%n", numSubjects);
        System.out.printf("Total Marks   : %d / %d%n", totalMarks, numSubjects * 100);
        System.out.printf("Average       : %.2f%%%n", average);
        System.out.printf("Grade         : %s%n", grade);
        System.out.printf("Status        : %s%n", status);
        System.out.printf("Remarks       : %s%n", remarks);
        System.out.println("==========================================");

        sc.close();
    }
}
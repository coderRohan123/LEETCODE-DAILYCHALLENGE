public class NumberofStudentsUnabletoEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int circleStudentCount = 0;
        int squareStudentCount = 0;

        // Count the number of students who want each type of sandwich
        for (int student : students) {
            if (student == 0) {
                circleStudentCount++;
            } else {
                squareStudentCount++;
            }
        }

        // Serve sandwiches to students
        for (int sandwich : sandwiches) {
            // No student wants the circle sandwich on top of the stack
            if (sandwich == 0 && circleStudentCount == 0) {
                return squareStudentCount;
            }
            // No student wants the square sandwich on top of the stack
            if (sandwich == 1 && squareStudentCount == 0) {
                return circleStudentCount;
            }
            // Decrement the count of the served sandwich type
            if (sandwich == 0) {
                circleStudentCount--;
            } else {
                squareStudentCount--;
            }
        }
        // Every student received a sandwich
        return 0;
    }

    public static void main(String[] args) {
        NumberofStudentsUnabletoEatLunch ob=new NumberofStudentsUnabletoEatLunch();
        System.out.println(ob.countStudents(new int[] {1,1,1,0,0,1},new int[] {1,0,0,0,1,1}));
    }
}

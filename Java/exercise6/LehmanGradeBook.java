public class LehmanGradeBook {
    public boolean isPassing(int grade) throws IllegalArgumentException {
        if (grade >= 0 && grade <= 100) {
            return grade >= 70;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public char getLetterGrade(int score) throws IllegalArgumentException {
        if (score >= 0 && score <= 100) {
            if (score >= 90 && score <= 100) {
                return 'A';
            }
            else if (score >= 80 && score < 90) {
                return 'B';
            }
            else if (score >= 70 && score < 80) {
                return 'C';
            }
            else if (score >= 60 && score < 70) {
                return 'D';
            }
            else {
                return 'F';
            }
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}

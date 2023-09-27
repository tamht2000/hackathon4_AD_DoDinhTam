package ra.model;

import java.util.Scanner;

public class Mark {
    private ra.model.Student[] Students;
    // Các thuộc tính private
    private Student[] students;
    private Subject[] subjects;
    private int idCount = 1;
    private int markId;       // Mã điểm - int (tự tăng)
    private Student student;  // Sinh viên - Student (Không được null)
    private Subject subject;  // Môn học - Subject (Không được null)
    private double point;     // Điểm số - double (từ 0 đến 10)

    // Constructor mặc định
    public Mark() {
        this.markId = idCount++;
    }

    // Constructor với các thuộc tính chính
    public Mark(Student student, Subject subject, double point) {
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    // Getter và Setter cho các thuộc tính
    public int getMarkId() {
        return markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }


    // Phương thức inputData() để nhập thông tin từ bàn phím
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        // Hiển thị danh sách học sinh và cho người dùng chọn
        System.out.println("Danh sách học sinh:");
         for (Student student : students) {
             System.out.println(student.getStudentId() + ": " + student.getStudentName());
         }

        System.out.println("Danh sách môn học:");
         for (Subject subject : subjects) {
             System.out.println(subject.getSubjectId() + ": " + subject.getSubjectName());
         }

        // Nhập thông tin từ bàn phím
        System.out.print("Nhập ID của học sinh: ");
        int studentId = scanner.nextInt();
         Student student = findStudentById(studentId);
         if (student != null) {
             this.student = student;
         } else {
             System.out.println("Không tìm thấy học sinh với ID này.");
             return;
         }

        System.out.print("Nhập ID của môn học: ");
        String subjectId = scanner.next();
         Subject subject = findSubjectById(subjectId);
         if (subject != null) {
             this.subject = subject;
         } else {
             System.out.println("Không tìm thấy môn học với ID này.");
             return;
         }

        System.out.print("Nhập điểm số (từ 0 đến 10): ");
        double point = scanner.nextDouble();

        // Kiểm tra điểm số hợp lệ
        if (point >= 0 && point <= 10) {
            this.point = point;
        } else {
            System.out.println("Điểm số không hợp lệ. Phải từ 0 đến 10.");
        }
    }

    public Student findStudentById(int studentId ) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public Subject findSubjectById(String subjectId) {
        for (Subject subject : subjects) {
            if (subject.getSubjectId().equals(subjectId)) {
                return subject;
            }
        }
        return null;
    }

    // Phương thức displayData() để hiển thị thông tin điểm số
    public void displayData() {
        System.out.println("ID điểm: " + markId);
        System.out.println("Tên học sinh: " + student.getStudentName());
        System.out.println("Tên môn học: " + subject.getSubjectName());
        System.out.println("Điểm số: " + point);
    }
}

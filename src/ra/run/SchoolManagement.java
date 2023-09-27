package ra.run;

import ra.model.Mark;
import ra.model.Student;
import ra.model.Subject;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static Student[] students = new Student[100];
    private static Subject[] subjects = new Subject[10];

    private static Mark[] marks = new Mark[100];
    private static int numberOfMark;
    private static int numberOfSubject;
    private  static int numberOfStudents;

    public SchoolManagement(){
        students = new Student[100];
        subjects = new Subject[10];
        marks = new Mark[100];
        numberOfStudents = 0;
        numberOfSubject = 0;
        numberOfMark = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("************************SCHOOL-MANAGEMENT*************************");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý môn học");
            System.out.println("3. Quản lý điểm thi");
            System.out.println("4. Thoát");

            System.out.print("Chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentManagementMenu();
                    break;
                case 2:
                    subjectManagementMenu();
                    break;
                case 3:
                    markManagementMenu();
                    break;
                case 4:
                    System.out.println("Chương trình kết thúc.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
            }
        }
    }

    private static void studentManagementMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************STUDENT-MANAGEMENT************************");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách tất cả học sinh đã lưu trữ");
            System.out.println("3. Thay đổi thông tin học sinh theo mã id");
            System.out.println("4. Xóa học sinh theo mã id");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateStudentInfo();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
            }
        }
    }

    private static void subjectManagementMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************SUBJECT-MANAGEMENT************************");
            System.out.println("1. Thêm mới môn học");
            System.out.println("2. Hiển thị danh sách tất cả môn học đã lưu trữ");
            System.out.println("3. Thay đổi thông tin môn học theo mã id");
            System.out.println("4. Xóa môn học theo mã id");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSubject();
                    break;
                case 2:
                    displaySubjects();
                    break;
                case 3:
                    updateSubjectInfo();
                    break;
                case 4:
                    deleteSubject();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
            }
        }
    }

    private static void markManagementMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*********************MARK-MANAGEMENT************************");
            System.out.println("1. Thêm mới điểm thi cho 1 sinh viên");
            System.out.println("2. Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần");
            System.out.println("3. Thay đổi điểm theo mã id");
            System.out.println("4. Xóa điểm theo mã id");
            System.out.println("5. Hiển thị danh sách điểm thi theo mã môn học");
            System.out.println("6. Hiển thị đánh giá học lực của từng học sinh theo mã môn học");
            System.out.println("7. Thoát");

            System.out.print("Chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMark();
                    break;
                case 2:
                    displayMarksSortedByPoint();
                    break;
                case 3:
                    updateMark();
                    break;
                case 4:
                    deleteMark();
                    break;
                case 5:
                    displayMarksBySubject();
                    break;
                case 6:
                    displayStudentPerformanceBySubject();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
            }
        }
    }


    // Student
    public static void addStudent() {
        System.out.println("nhập số lượng student cần thêm:");
        int n = Integer.parseInt(scanner.nextLine());
        if(n < 1 || n > 100) {
            System.out.println("số lượng không hợp lệ.");
            return;
        }
        for (int i = 0; i < n; i++) {
            students[numberOfStudents] = new Student();
            students[numberOfStudents].inputData(scanner);
            numberOfStudents++;
        }
    }

    private static void displayStudents() {
        if (numberOfStudents == 0) {
            System.out.println("Danh sách student đang trống.");
        } else {
            System.out.println("Thông tin tất cả student :");
            for (int i =0; i < numberOfStudents; i++) {
                students[i].displayData();
            }
        }
    }

    public static void updateStudentInfo() {
        if(numberOfStudents == 0) {
            System.out.println("danh sách đang rỗng.");
        }
        System.out.println("nhập mã student cần sửa:");
        int studentId = Integer.parseInt(scanner.nextLine());

        for (Student student:students) {
            if(student.getStudentId() == studentId){
                student.inputData(scanner);
                System.out.println("Thông tin đã được cập nhật");
                return;
            }
        }
        System.out.println("Không tìm thấy student có mã" + studentId);
    }

    public static void deleteStudent() {
        if(numberOfStudents == 0) {
            System.out.println("danh sách đang rỗng.");
        }
        while (true) {
            System.out.print("Nhập mã student cần xóa (hoặc nhập -1 để thoát): ");
            int studentId = scanner.nextInt();
            scanner.nextLine();

            if (studentId == -1) {
                System.out.println("Đã thoát khỏi chức năng xóa student.");
                return;
            }

            int foundIndex = -1;
            for (int i = 0; i < numberOfStudents; i++) {
                if (students[i].getStudentId() == studentId) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex != -1) {
                // Xóa sách và cập nhật lại ID của sách còn lại
                for (int i = foundIndex; i < numberOfStudents - 1; i++) {
                    students[i] = students[i + 1];
                    students[i].setStudentId(students[i].getStudentId() - 1); // Giảm ID đi 1
                }
                students[numberOfStudents - 1] = null;
                numberOfStudents--;

                System.out.println("Student đã được xóa.");
            } else {
                System.out.println("Không tìm thấy student có mã " + studentId + ". Vui lòng nhập lại.");
            }
        }
    }

    // Suvject
    public static void addSubject() {
        System.out.println("nhập số lượng môn học cần thêm:");
        int n = Integer.parseInt(scanner.nextLine());
        if(n < 1 || n > 100) {
            System.out.println("số lượng không hợp lệ.");
            return;
        }
        for (int i = 0; i < n; i++) {
            subjects[numberOfSubject] = new Subject();
            subjects[numberOfSubject].inputData();
            numberOfSubject++;
        }
    }

    private static void displaySubjects() {
        if (numberOfSubject == 0) {
            System.out.println("Danh sách môn học đang trống.");
        } else {
            System.out.println("Thông tin tất cả môn học :");
            for (int i =0; i < numberOfSubject; i++) {
                subjects[i].displayData();
            }
        }
    }

    public static void updateSubjectInfo() {
        if(numberOfSubject == 0) {
            System.out.println("danh sách đang rỗng.");
        }
        System.out.println("nhập mã môn học cần sửa:");
        String subjectId = scanner.nextLine();

        for (int i = 0; i < numberOfSubject; i++) {
            if(subjects[i].getSubjectId().equals(subjectId)) {
                subjects[i].inputData();
                System.out.println("Thông tin đã được cập nhật");
                return;
            }
        }


        System.out.println("Không tìm thấy student có mã " + subjectId);
    }

    public static void deleteSubject() {
        if (numberOfSubject == 0) {
            System.out.println("Danh sách đang rỗng.");
            return;
        }

        boolean isValid = false;
        do {
            System.out.print("Nhập mã môn học cần xóa hoặc nhập 'q' để thoát: ");
            String subjectId = scanner.nextLine();

            if (subjectId.equalsIgnoreCase("q")) {
                // Người dùng muốn thoát, thoát khỏi vòng lặp
                break;
            }

            boolean found = false;

            for (int i = 0; i < numberOfSubject; i++) {
                if (subjects[i].getSubjectId().equals(subjectId)) {
                    // Di chuyển các môn học bên phải của mảng sang trái để ghi đè môn học bị xóa
                    for (int j = i; j < numberOfSubject - 1; j++) {
                        subjects[j] = subjects[j + 1];
                    }

                    numberOfSubject--;
                    found = true;
                    System.out.println("Đã xóa môn học có mã: " + subjectId);
                    break;
                }
            }

            if (!found) {
                System.out.println("Không tìm thấy môn học có mã " + subjectId + ". Vui lòng nhập lại.");
            } else {
                isValid = true;
            }
        } while (!isValid);
    }

    // Mark

    private static void addMark() {
        Mark mark = new Mark();
        mark.inputData();
        // Lưu mark vào danh sách hoặc cơ sở dữ liệu của bạn
    }

    private static void displayMarksSortedByPoint() {

    }

    private static void updateMark() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã điểm cần cập nhật: ");
        int markId = scanner.nextInt();

        // Tìm mark theo markId, nếu tìm thấy thì cập nhật điểm
        // Nếu không tìm thấy thì thông báo lỗi
    }

    private static void deleteMark() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã điểm cần xóa: ");
        int markId = scanner.nextInt();

        // Tìm mark theo markId, nếu tìm thấy thì xóa điểm
        // Nếu không tìm thấy thì thông báo lỗi
    }

    private static void displayMarksBySubject() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học: ");
        String subjectId = scanner.next();

        // Lọc và hiển thị danh sách điểm cho môn học có subjectId tương ứng
    }

    private static void displayStudentPerformanceBySubject() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học: ");
        String subjectId = scanner.next();

        // Tính và hiển thị đánh giá học lực của từng học sinh cho môn học có subjectId tương ứng
    }


}


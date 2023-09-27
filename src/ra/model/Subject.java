package ra.model;

import java.util.Scanner;

public class Subject {
    // Các thuộc tính private
    private String subjectId;      // Mã môn học - String (Gồm 5 kí tự bắt đầu bằng "MH" và 3 kí tự số bất kì, không trùng lặp)
    private String subjectName;    // Tên môn học - String (Không được để trống, không trùng nhau)

    // Constructor mặc định
    public Subject() {
    }

    // Constructor với các thuộc tính chính
    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    // Getter và Setter cho các thuộc tính
    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    // Phương thức inputData() để nhập thông tin từ bàn phím
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập mã môn học (bắt đầu bằng \"MH\" và 3 kí tự số bất kì): ");
            String id = scanner.nextLine();

            // Kiểm tra định dạng của mã môn học
            if (isValidSubjectId(id)) {
                this.subjectId = id;
                break; // Thoát khỏi vòng lặp khi nhập đúng
            } else {
                System.out.println("Mã môn học không hợp lệ. Mã môn học phải bắt đầu bằng \"MH\" và có 3 kí tự số.");
            }
        }

        while (true) {
            System.out.print("Nhập tên môn học: ");
            String name = scanner.nextLine();

            // Kiểm tra tên môn học không được để trống
            if (!name.isEmpty()) {
                this.subjectName = name;
                break; // Thoát khỏi vòng lặp khi nhập đúng
            } else {
                System.out.println("Tên môn học không được để trống.");
            }
        }
    }

    // Phương thức displayData() để hiển thị thông tin của môn học
    public void displayData() {
        System.out.println("Mã môn học: " + subjectId);
        System.out.println("Tên môn học: " + subjectName);
    }

    // Phương thức kiểm tra định dạng mã môn học
    private boolean isValidSubjectId(String id) {
        // Kiểm tra xem mã môn học có bắt đầu bằng "MH" và có đúng 3 kí tự số không
        return id.matches("MH\\d{3}");
    }
}

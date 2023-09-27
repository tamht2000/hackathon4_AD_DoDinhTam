package ra.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Student {
    private static int nextStudentId = 1;

    private int studentId;
    private String studentName;
    private String birthDay;
    private String address;
    private boolean gender;
    private String phone;

    // Constructors
    public Student() {
        this.studentId = nextStudentId++;
    }

    public Student(String studentName, String birthDay, String address, boolean gender, String phone) {
        this();
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    // Getter and Setter methods
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Method to input student data from the keyboard
    public void inputData(Scanner scanner) {

        System.out.println("Enter student information:");

        while (true) {
            System.out.print("Tên : ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                this.studentName = name;
                break;
            } else {
                System.out.println("Tên không hợp lệ, thử lại.");
            }
        }

        while (true) {
            System.out.print("Ngày sinh (dd/MM/yyyy): ");
            String birthDate = scanner.nextLine();
            this.birthDay = String.valueOf(birthDate);
            break;
        }

        while (true) {
            System.out.print("Địa chỉ: ");
            String address = scanner.nextLine().trim();
            if (!address.isEmpty()) {
                this.address = address;
                break;
            } else {
                System.out.println("Địa chỉ không hợp lệ, vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Giới tính (Nam/Nữ): ");
            String genderStr = scanner.nextLine().trim();
            if (genderStr.equalsIgnoreCase("Nam")) {
                this.gender = true;
                break;
            } else if (genderStr.equalsIgnoreCase("Nữ")) {
                this.gender = false;
                break;
            } else {
                System.out.println("Không đúng. hãy nhập Nam hoặc Nữ.");
            }
        }

        while (true) {
            System.out.print("Số điện thoại (10 hoặc 11 số bắt đầu bằng số 0): ");
            String phone = scanner.nextLine().trim();
            if (isValidPhone(phone)) {
                this.phone = phone;
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    private static Set<String> usedPhoneNumbers = new HashSet<>();

    private boolean isValidPhone(String phone) {
        String regex = "0\\d{9,10}";
        boolean isValidFormat = Pattern.matches(regex, phone);

        if (!isValidFormat) {
            System.out.println("Số điện thoại không hợp lệ, vui lòng thử lại.");
            return false;
        }

        // Kiểm tra tính duy nhất
        if (usedPhoneNumbers.contains(phone)) {
            System.out.println("Số điện thoại đã được sử dụng, vui lòng nhập số khác.");
            return false;
        }

        // Nếu số điện thoại hợp lệ và duy nhất, thêm nó vào danh sách đã sử dụng
        usedPhoneNumbers.add(phone);
        return true;
    }

    // Method to display all student data
    public void displayData() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Date of Birth: " + birthDay);
        System.out.println("Address: " + address);
        System.out.println("Gender: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Phone: " + phone);
    }


}

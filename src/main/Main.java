package main;

import Model.DanhBa;
import file.ManagerFile;
import manage.QuanLyDanhBa;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner= new Scanner(System.in);

        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();

        int choice = -1;
        while (choice!=0) {
            System.out.println("Menu");
            System.out.println("1.Xem danh sach");
            System.out.println("2.Them moi");
            System.out.println("3.Cap nhat");
            System.out.println("4.Xoa");
            System.out.println("5.Tim kiem");
            System.out.println("6.Doc tu file");
            System.out.println("7.Ghi vao file");
            System.out.println("8.Thoat");
            System.out.println("Moi nhap lua chon");

            boolean check2 = false;
            while (!check2) {
                try {
                    choice = scanner.nextInt();
                    if (choice < 0 || choice > 8) throw new Exception();
                    check2 = true;
                } catch (InputMismatchException e) {
                    System.out.println("Vui long nhap so");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Chỉ được nhập số từ 0 - 8");
                }
            }

            switch (choice){

                case 1:
                    quanLyDanhBa.display();
                    break;
                case 2:
                    System.out.println("NHap id");
                    int id= scanner.nextInt();
                    System.out.println("Nhap vao so dien thoai");
                    String soDienThoai = enterPhoneNumber();
                    scanner.nextLine();
                    System.out.println("Nhap vao nhom danh ba");
                    String nhomDanhBa = scanner.nextLine();
                    System.out.println("Nhap vao ho va ten");
                    String hoVaTen = scanner.nextLine();
                    System.out.println("Nhap vao gioi tinh");
                    String gioiTinh = scanner.nextLine();
                    System.out.println("Nhap vao dia chi");
                    String diaChi = scanner.nextLine();
                    System.out.println("Nhap vao ngay sinh");
                    String ngaySinh = scanner.nextLine();
                    System.out.println("Nhap vao email");
                    String email = entermail();
                    quanLyDanhBa.add(new DanhBa(id,soDienThoai,nhomDanhBa,hoVaTen,gioiTinh,diaChi,ngaySinh,email));
                    ManagerFile.writeToFile(quanLyDanhBa.getDanhBaList());
                    break;


                case 3:
                    System.out.println("Nhap vao sdt can sUa");
                    String sdtCanSUa = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("NHap id sua");
                    int idSua= scanner.nextInt();
                    System.out.println("Nhap vao so dien thoai sua");
                    String soDienThoaiSua = enterPhoneNumber();
                    scanner.nextLine();
                    System.out.println("Nhap vao nhom danh ba sua");
                    String nhomDanhBaSua = scanner.nextLine();
                    System.out.println("Nhap vao ho va ten sua");
                    String hoVaTenSua = scanner.nextLine();
                    System.out.println("Nhap vao gioi tinh sau sua");
                    String gioiTinhSua = scanner.nextLine();
                    System.out.println("Nhap vao dia chi sua");
                    String diaChiSua = scanner.nextLine();
                    System.out.println("Nhap vao ngay sinh sua");
                    String ngaySinhSua = scanner.nextLine();
                    System.out.println("Nhap vao email");
                    String emailSua = entermail();
                    DanhBa bd = new DanhBa(idSua,soDienThoaiSua,nhomDanhBaSua,hoVaTenSua,gioiTinhSua,diaChiSua,ngaySinhSua,emailSua);
                    quanLyDanhBa.edit(sdtCanSUa,bd);
                    ManagerFile.writeToFile(quanLyDanhBa.getDanhBaList());
                    break;

                case 4:
                    System.out.println("Nhap so dien thoai can xoa");
                    scanner.nextLine();
                    String soDienThoai1 = scanner.nextLine();
                    quanLyDanhBa.delete(soDienThoai1);
                    break;
                case 5:
                    System.out.println("Nhap so dien thoai can tim kiem");
                    scanner.nextLine();
                    String sdtTimKiem = scanner.nextLine();
                    System.out.println(quanLyDanhBa.findByNumberPhone(sdtTimKiem));
                    break;
                case 6:
                    ManagerFile.writeToFile(quanLyDanhBa.getDanhBaList());
                    break;
                case 7:
                    ManagerFile.readFromFile();
                    break;
                case 8:
                    quanLyDanhBa.exit();
                    break;

            }


        }

    }

    private static String entermail() {
        Scanner scanner = new Scanner(System.in);
        String email;
            while (true) {
                String inputEmail = scanner.nextLine();
                if (!Validate.validateEmail(inputEmail)) {
                    System.out.println("️ Email khong hop le !!!");
                    System.out.println(">[Chu y]: Email co dang: abc.company@yahoo.com/abc12.company@gmail.vn/...");
                    System.out.println("--------------------");
                } else {
                    email = inputEmail;
                    break;
                }
            }
            return email;
    }

    public static  String enterPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
            String phoneNumber;
            while (true) {
                String phone = scanner.nextLine();
                if (!Validate.validatePhone(phone)) {
                    System.out.println(" So dien thoai khong hop le");
                    System.out.println(">[Chu y]: So dien thoai co dinh dang: (0xxxxxxxxx)");
                    System.out.println("--------------------");
                } else {
                    phoneNumber = phone;
                    break;
                }
            }
         return phoneNumber;
        }

}

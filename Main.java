import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

        static void hienDanhSach(ArrayList<NguoiLaoDong> ds, String loai) {
        System.out.println();
        System.out.println("=== DANH SACH " + loai.toUpperCase() + " ===");
        if (ds.isEmpty()) {
            System.out.println("(Danh sach trong)");
            return;
        }

                String vien = "+-------------+----------------------+------+------------+---------------+-------------+";
                System.out.println(vien);
                System.out.printf("| %-11s | %-20s | %4s | %10s | %-13s | %11s |%n",
                "Loai", "Ho ten", "Tuoi", "Luong CB", "Chi tiet", "Luong");
        System.out.println(vien);

        for (NguoiLaoDong nld : ds) {
            nld.Hien();
        }

        System.out.println(vien);
    }

    // Tao doi tuong tuong ung voi loai duoc chon
    static NguoiLaoDong taoMoi(String loai) {
        switch (loai) {
            case "giang vien":
                return new Giangvien();
            case "nhan vien":
                return new Nhanvien();
            default:
                return new Quanly();
        }
    }

    static void menuDanhSach(Scanner sc, ArrayList<NguoiLaoDong> ds, String loai) {
        int chon = -1;

        do {
            System.out.println();
            System.out.println("=== MENU " + loai.toUpperCase() + " ===");
            System.out.println("1. Them " + loai);
            System.out.println("2. Hien danh sach " + loai);
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");

            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le!");
                chon = -1;
                continue;
            }

            switch (chon) {
                case 1:
                    NguoiLaoDong nld = taoMoi(loai);
                    try {
                        nld.Nhap(sc);
                        ds.add(nld);
                        System.out.println("-> Da them.");
                    } catch (InputMismatchException e) {
                        sc.nextLine();
                        System.out.println("Du lieu nhap sai dinh dang, bo qua "
                                + loai + " nay!");
                    }
                    break;
                case 2:
                    hienDanhSach(ds, loai);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NguoiLaoDong> dsGiangVien = new ArrayList<>();
        ArrayList<NguoiLaoDong> dsNhanVien = new ArrayList<>();
        ArrayList<NguoiLaoDong> dsQuanLy = new ArrayList<>();

        System.out.println("=== CHUONG TRINH QUAN LY NGUOI LAO DONG ===");

        int chon = -1;
        do {
            System.out.println();
            System.out.println("1. Giang vien");
            System.out.println("2. Nhan vien");
            System.out.println("3. Quan ly");
            System.out.println("4. Hien tat ca");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le!");
                continue;
            }

            switch (chon) {
                case 1:
                    menuDanhSach(sc, dsGiangVien, "giang vien");
                    break;
                case 2:
                    menuDanhSach(sc, dsNhanVien, "nhan vien");
                    break;
                case 3:
                    menuDanhSach(sc, dsQuanLy, "quan ly");
                    break;
                case 4:
                    ArrayList<NguoiLaoDong> tatCa = new ArrayList<>();
                    tatCa.addAll(dsGiangVien);
                    tatCa.addAll(dsNhanVien);
                    tatCa.addAll(dsQuanLy);
                    hienDanhSach(tatCa, "tat ca nguoi lao dong");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }
}
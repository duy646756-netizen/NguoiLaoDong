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
        for (NguoiLaoDong nld : ds) {
            nld.Hien();
        }
    }

    static void menuDanhSach(Scanner sc, ArrayList<NguoiLaoDong> ds, boolean laGiangVien) {
        int chon = -1;
        String loai = laGiangVien ? "giang vien" : "nhan vien";

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
                    NguoiLaoDong nld = laGiangVien ? new Giangvien() : new Nhanvien();
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

        System.out.println("=== CHUONG TRINH QUAN LY NGUOI LAO DONG ===");

        int chon = -1;
        do {
            System.out.println();
            System.out.println("1. Giang vien");
            System.out.println("2. Nhan vien");
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
                    menuDanhSach(sc, dsGiangVien, true);
                    break;
                case 2:
                    menuDanhSach(sc, dsNhanVien, false);
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

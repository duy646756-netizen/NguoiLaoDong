import java.util.Locale;
import java.util.Scanner;

public class Nhanvien extends NguoiLaoDong {

    private int soNgayCong;

    public Nhanvien() {
    }

    public Nhanvien(String hoTen, int tuoi, double luongCoBan, int soNgayCong) {
        super(hoTen, tuoi, luongCoBan);
        this.soNgayCong = soNgayCong;
    }

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

        public double TinhLuong() {
        return getLuongCoBan() / 26 * soNgayCong;
    }

    // Dinh dang so tien: 9000000 -> 9,000,000
    private String dinhDang(double soTien) {
        return String.format(Locale.US, "%,.0f", soTien);
    }

    @Override
    public void Nhap(Scanner sc) {
        super.Nhap(sc);

        System.out.print("Nhap so ngay cong: ");
        setSoNgayCong(sc.nextInt());
        sc.nextLine();
    }

       @Override
    public void Hien() {
        System.out.printf("| %-11s | %-20s | %4d | %10s | %-13s | %11s |%n",
                "Nhan vien", getHoTen(), getTuoi(), dinhDang(getLuongCoBan()),
                soNgayCong + " ngay", dinhDang(TinhLuong()));
    }
}
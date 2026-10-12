import java.util.Locale;
import java.util.Scanner;

public class Quanly extends NguoiLaoDong {

    private double phuCapChucVu;

    public Quanly() {
    }

    public Quanly(String hoTen, int tuoi, double luongCoBan, double phuCapChucVu) {
        super(hoTen, tuoi, luongCoBan);
        this.phuCapChucVu = phuCapChucVu;
    }

    public double getPhuCapChucVu() {
        return phuCapChucVu;
    }

    public void setPhuCapChucVu(double phuCapChucVu) {
        this.phuCapChucVu = phuCapChucVu;
    }

    // Luong = luong co ban + phu cap chuc vu
    public double TinhLuong() {
        return getLuongCoBan() + phuCapChucVu;
    }

    // Dinh dang so tien: 9000000 -> 9,000,000
    private String dinhDang(double soTien) {
        return String.format(Locale.US, "%,.0f", soTien);
    }

    @Override
    public void Nhap(Scanner sc) {
        super.Nhap(sc);

        System.out.print("Nhap phu cap chuc vu: ");
        setPhuCapChucVu(sc.nextDouble());
        sc.nextLine();
    }

               @Override
    public void Hien() {
        System.out.printf("| %-11s | %-20s | %4d | %10s | %-13s | %11s |%n",
                "Quan ly", getHoTen(), getTuoi(), dinhDang(getLuongCoBan()),
                "PC " + dinhDang(phuCapChucVu), dinhDang(TinhLuong()));
    }
}
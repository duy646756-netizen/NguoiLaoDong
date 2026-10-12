import java.util.Locale;
import java.util.Scanner;

public class Giangvien extends NguoiLaoDong {

    private int soTietDay;

    public Giangvien() {
    }

    public Giangvien(String hoTen, int tuoi, double luongCoBan, int soTietDay) {
        super(hoTen, tuoi, luongCoBan);
        this.soTietDay = soTietDay;
    }

    public int getSoTietDay() {
        return soTietDay;
    }

    public void setSoTietDay(int soTietDay) {
        this.soTietDay = soTietDay;
    }

    // Luong = luong co ban (1 tiet) x so tiet day
    public double TinhLuong() {
        return getLuongCoBan() * soTietDay;
    }

    // Dinh dang so tien: 9000000 -> 9,000,000
    private String dinhDang(double soTien) {
        return String.format(Locale.US, "%,.0f", soTien);
    }

    @Override
    public void Nhap(Scanner sc) {
        super.Nhap(sc);

        System.out.print("Nhap so tiet day: ");
        setSoTietDay(sc.nextInt());
        sc.nextLine();
    }

    @Override
    public void Hien() {
        System.out.println("[Giang vien] Ho ten: " + getHoTen()
                + " | Tuoi: " + getTuoi()
                + " | Luong CB: " + dinhDang(getLuongCoBan())
                + " | Tiet day: " + soTietDay
                + " | Luong: " + dinhDang(TinhLuong()));
    }
}

import java.util.Scanner;
import java.util.Locale;     
import java.text.NumberFormat;

public class GajiKaryawan {
    public static void main(String[] args) {
        Locale indonesia = Locale.of("id", "ID");
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(indonesia);

        Scanner input = new Scanner(System.in);
        input.useLocale(indonesia);

        String golongan;
        int jamLembur;
        double gajiPokok = 0;
        double persenLembur = 0;

        System.out.print("Masukkan Golongan (A/B/C): ");
        golongan = input.nextLine().trim().toUpperCase();

        System.out.print("Masukkan Jam Lembur: ");
        while (!input.hasNextInt()) {
            System.out.print("Harus angka! Masukkan Jam Lembur: ");
            input.next();
        }
        jamLembur = input.nextInt();

        if (golongan.equals("A")) {
            gajiPokok = 5000000;
        } else if (golongan.equals("B")) {
            gajiPokok = 6500000;
        } else if (golongan.equals("C")) {
            gajiPokok = 9500000;
        } else {
            System.out.println("Golongan tidak valid! Harus A, B, atau C.");
            input.close();
            return;
        }

        if (jamLembur < 0) {
            System.out.println("Jam lembur tidak boleh minus!");
            input.close();
            return;
        } else if (jamLembur == 0) {
            persenLembur = 0;
        } else if (jamLembur == 1) {
            persenLembur = 30;
        } else if (jamLembur == 2) {
            persenLembur = 32;
        } else if (jamLembur == 3) {
            persenLembur = 34;
        } else if (jamLembur == 4) {
            persenLembur = 36;
        } else {
            persenLembur = 38;
        }

        double gajiLembur = gajiPokok * persenLembur / 100;
        double totalPenghasilan = gajiPokok + gajiLembur;

        System.out.println("\n===== SLIP GAJI KARYAWAN =====");
        System.out.println("Golongan          : " + golongan);
        System.out.println("Jam Lembur        : " + jamLembur + " jam");
        System.out.println("Gaji Pokok        : " + rupiah.format(gajiPokok));
        System.out.println("Persentase Lembur : " + (int)persenLembur + "%");
        System.out.println("Gaji Lembur       : " + rupiah.format(gajiLembur));
        System.out.println("--------------------------------");
        System.out.println("Jumlah Penghasilan: " + rupiah.format(totalPenghasilan));

        input.close();
    }
}
package view;

import java.util.Scanner;

import controller.RawatInapController;

public class Menu {
    Scanner input = new Scanner(System.in);
    RawatInapController objRawat = new RawatInapController();
    RawatInapView rawatView = new RawatInapView();

    public void menu() {
        String pilih;
        do {
            System.out.println("""
                    1. Login
                    2. Exit
                    """);
            System.out.print("Masukkan Pilihan Anda = ");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" -> login();
                case "2" -> System.out.println();
                default -> System.out.println("Inputan Tidak Ada");
            }
        } while (!pilih.equals("2"));
    }

    private void menuAdmin() {
        String pilih;
        do {
            System.out.println("""
                    1. RawatInap
                    2. Daftar Rawat Inap
                    3. Daftar Kamar Yang Tersedia
                    4. Rawat Jalan
                    5. Exit
                    """);
            System.out.print("Masukkan Pilihan Anda = ");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" -> rawatView.rawatInap();
                case "2" -> rawatView.cetakData();
                case "3" -> rawatView.cetakKamar();
                case "4" -> rawatView.rawatJalan();
                case "5" -> System.out.println();
                default -> System.out.println("Inputan Tidak Ada");
            }
        } while (!pilih.equals("5"));
    }

    private void login() {
        try {
            boolean status = false;
            System.out.print("Masukkan No kartu Pegawai = ");
            int kartu = input.nextInt();
            input.nextLine();
            System.out.print("Masukkan Password         = ");
            String password = input.nextLine();

            status = objRawat.loginAdmin(kartu, password);
            if (status) {
                System.out.println("Berhasil Login");
                menuAdmin();
            } else {
                System.out.println("Kartu Pegawai Atau Password Salah");
            }
        } catch (Exception e) {
            input.nextLine();
        }
    }
}

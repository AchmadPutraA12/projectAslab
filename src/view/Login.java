package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.RawatInapController;

public class Login extends Frame {
    private JLabel rsLabel, kartuLabel, passwordLabel;
    private JTextField kartuField;
    private JPasswordField passwordField;
    private JButton loginBtn;

    public Login() {
        super("Login", 400, 600);
        setLocation(500, 150);
    }

    @Override
    protected void component() {
        rsLabel = new JLabel("Rumah Sakit Abal-Abal");
        rsLabel.setFont(new Font("Arial", Font.BOLD, 24));
        setBound(rsLabel, 65, 200, 300, 45);

        kartuLabel = new JLabel("Kartu Pegawai");
        kartuLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(kartuLabel, 65, 250, 100, 18);

        kartuField = new JTextField();
        setBound(kartuField, 65, 270, 270, 30);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(passwordLabel, 65, 315, 100, 18);

        passwordField = new JPasswordField();
        setBound(passwordField, 65, 335, 270, 30);

        loginBtn = new JButton("Masuk");
        loginBtn.setForeground(Color.white);
        loginBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setFocusPainted(false);
        setBound(loginBtn, 157, 380, 85, 30);
    }

    @Override
    protected void event() {
        RawatInapController objekRawat = new RawatInapController();

        loginBtn.addActionListener((e) -> {
            try {
                int kartPegawai = Integer.parseInt(kartuField.getText());
                String password = String.valueOf(passwordField.getPassword());
                boolean status = objekRawat.loginAdmin(kartPegawai, password);
                if (status) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang", "Login Sukses",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new MenuGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Valid", "Login Sukses",
                            JOptionPane.ERROR_MESSAGE);
                    dispose();
                    new Login().setVisible(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan Inputan Yang benar", "Login Sukses",
                        JOptionPane.ERROR_MESSAGE);
                dispose();
                new Login().setVisible(true);
            }

        });
    }
}

package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;


public class MenuGui extends Frame{
    private JLabel rsLabel;
    private JButton keluarBtn, rawatBtn, daftarBtn;

    public MenuGui(){
        super("Menu", 400, 600);
        setLocation(500, 150);
    }

    @Override
    protected void component(){
        rsLabel = new JLabel("Rumah Sakit Abal-Abal");
        rsLabel.setFont(new Font("Arial", Font.BOLD, 24));
        setBound(rsLabel, 65, 200, 300, 45);

        rawatBtn = new JButton("Rawat Inap");
        rawatBtn.setForeground(Color.white);
        rawatBtn.setBackground(Color.DARK_GRAY);
        rawatBtn.setFocusPainted(false);
        setBound(rawatBtn, 140, 250, 124, 30);

        daftarBtn = new JButton("Daftar Rawat Inap");
        daftarBtn.setForeground(Color.white);
        daftarBtn.setBackground(Color.DARK_GRAY);
        daftarBtn.setFocusPainted(false);
        setBound(daftarBtn, 140, 310, 124, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(Color.DARK_GRAY);
        keluarBtn.setFocusPainted(false);
        setBound(keluarBtn, 140, 370, 124, 30);
    }

    @Override
    protected void event(){
        rawatBtn.addActionListener((e) -> {
            dispose();
            new MenuAdminGui().setVisible(true);
        });

        daftarBtn.addActionListener((e) -> {
            dispose();
            new DaftarRawatGui().setVisible(true);
        });

        keluarBtn.addActionListener((e) -> {
            dispose();
            new Login().setVisible(true);
        });
    }
}

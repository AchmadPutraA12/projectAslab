package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.RawatInapController;
import entity.KamarEntity;
import utils.FormatUang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuAdminGui extends Frame {
    private JTable dataKamarTable;
    private JScrollPane scrollPane;
    private JLabel adminLabel, adminIcon, idLabel, namaLabel, nipLabel, umurLabel, alamatLabel, lamaLabel;
    private JTextField idField, namaField, nipField, umurField, alamatField, lamaField;
    private JButton keluarBtn, saveBtn;
    private JTextField selectedField = new JTextField();

    public MenuAdminGui() {
        super("Page Admin", 1450, 800);
        setLocation(40, 40);
    }

    @Override
    protected void component() {
        adminIcon = new JLabel(loadImage("src/asset/admin.png", 50, 50));
        setBound(adminIcon, 300, 70, 110, 100);

        adminLabel = new JLabel("Admin Page");
        adminLabel.setFont(new Font("Arial", Font.BOLD, 24));
        adminLabel.setForeground(Color.blue);
        setBound(adminLabel, 100, 100, 200, 45);

        idLabel = new JLabel("ID Pasien");
        idLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(idLabel, 65, 170, 150, 18);

        idField = new JTextField();
        setBound(idField, 65, 190, 270, 30);

        namaLabel = new JLabel("Nama Pasien");
        namaLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(namaLabel, 65, 235, 150, 18);

        namaField = new JTextField();
        setBound(namaField, 65, 255, 270, 30);

        umurLabel = new JLabel("Umur Passien");
        umurLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(umurLabel, 65, 365, 150, 18);

        umurField = new JTextField();
        setBound(umurField, 65, 385, 270, 30);

        alamatLabel = new JLabel("Alamat Passien");
        alamatLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(alamatLabel, 65, 430, 150, 18);

        alamatField = new JTextField();
        setBound(alamatField, 65, 450, 270, 30);

        lamaLabel = new JLabel("Lama Inap Pasien");
        lamaLabel.setFont(new Font("Arial", Font.BOLD, 13));
        setBound(lamaLabel, 65, 495, 150, 18);

        lamaField = new JTextField();
        setBound(lamaField, 65, 515, 270, 30);

        saveBtn = new JButton("Save");
        saveBtn.setForeground(Color.white);
        saveBtn.setBackground(Color.DARK_GRAY);
        saveBtn.setFocusPainted(false);
        setBound(saveBtn, 65, 565, 85, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(Color.DARK_GRAY);
        keluarBtn.setFocusPainted(false);
        setBound(keluarBtn, 250, 565, 85, 30);

        dataKamarTable = new JTable();
        dataKamarTable.setModel(createDataTable());
        dataKamarTable.setDefaultEditor(Object.class, null);
        dataKamarTable.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(dataKamarTable);
        setBound(scrollPane, 400, 190, 1000, 200);

    }

    @Override
    protected void event() {
        RawatInapController objRawat = new RawatInapController();

        dataKamarTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = dataKamarTable.getSelectedRow();
                String selectedId = dataKamarTable.getValueAt(i, 0).toString();
                selectedField.setText(selectedId);
            }
        });
        
        keluarBtn.addActionListener((e) -> {
            dispose();
            new MenuGui().setVisible(true);
        });

        saveBtn.addActionListener((e) -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String nama = namaField.getText();
                int umur = Integer.parseInt(umurField.getText());
                String alamat = alamatField.getText();
                int lama = Integer.parseInt(lamaField.getText());
                String kode = selectedField.getText();
                KamarEntity kamar = objRawat.cariKamar(kode);
                if (kamar != null) {
                    JOptionPane.showMessageDialog(null, "Data Telah Masuk", "Sukses",
                            JOptionPane.INFORMATION_MESSAGE);
                            objRawat.pesanKamar(id, nama, umur, alamat, kamar, lama);
                            objRawat.rawatInap(kamar);
                    dispose();
                    new MenuAdminGui().setVisible(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan Data yang Benar", "Gagal",
                            JOptionPane.ERROR_MESSAGE);
                    dispose();
                    new MenuAdminGui().setVisible(true);
            }
        });
    }

    private DefaultTableModel createDataTable() {
        DefaultTableModel dataTable = new DefaultTableModel();
        Object column[] = {
                "KODE KAMAR",
                "JENIS KAMAR",
                "HARGA KAMAR",
        };
        dataTable.setColumnIdentifiers(column);
        RawatInapController objekRawat = new RawatInapController();
        ArrayList<KamarEntity> arrayKamar = objekRawat.allArrayKamar();
        for (KamarEntity objek : arrayKamar) {
            if (objek.getStatus() == true) {
                Object[] data = new String[] {
                        objek.getKodeKamar(),
                        objek.getJenisKamar(),
                        String.valueOf(FormatUang.formatRupiah(objek.getHargaPermalam()))
                };
                dataTable.addRow(data);
            }
        }
        return dataTable;
    }
}

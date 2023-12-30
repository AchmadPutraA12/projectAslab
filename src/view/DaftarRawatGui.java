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
import entity.RawatInapEntity;
import utils.FormatUang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DaftarRawatGui extends Frame {
    private JTable dataRawatInap;
    private JScrollPane scrollPane;

    private JButton keluarBtn, saveBtn;
    private JTextField selectedField = new JTextField();

    public DaftarRawatGui() {
        super("Page Admin", 1450, 800);
        setLocation(40, 40);
    }

    @Override
    protected void component() {
        saveBtn = new JButton("Save");
        saveBtn.setForeground(Color.white);
        saveBtn.setBackground(Color.DARK_GRAY);
        saveBtn.setFocusPainted(false);
        setBound(saveBtn, 620, 484, 85, 30);

        keluarBtn = new JButton("Keluar");
        keluarBtn.setForeground(Color.white);
        keluarBtn.setBackground(Color.DARK_GRAY);
        keluarBtn.setFocusPainted(false);
        setBound(keluarBtn, 750, 484, 85, 30);

        dataRawatInap = new JTable();
        dataRawatInap.setModel(createDataTable());
        dataRawatInap.setDefaultEditor(Object.class, null);
        dataRawatInap.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(dataRawatInap);
        setBound(scrollPane, 144, 223, 1161, 200);

    }

    @Override
    protected void event() {

        dataRawatInap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = dataRawatInap.getSelectedRow();
                String selectedId = dataRawatInap.getValueAt(i, 0).toString();
                selectedField.setText(selectedId);
            }
        });

        keluarBtn.addActionListener((e) -> {
            dispose();
            new MenuGui().setVisible(true);
        });

        saveBtn.addActionListener((e) -> {

        });
    }

    private DefaultTableModel createDataTable() {
        DefaultTableModel dataTable = new DefaultTableModel();
        Object column[] = {
                "Nama Pasien",
                "Umur Pasien",
                "Alamat Pasien",
                "Jenis Kamar",
                "Harga Kamar",
                "Total Harga Kamar",
                "Lama Bermalam",
                "Tanggal Masuk",
                "Tanggal Keluar",
        };
        dataTable.setColumnIdentifiers(column);
        RawatInapController objekRawat = new RawatInapController();
        ArrayList<RawatInapEntity> arrayInap = objekRawat.allArrayRawat();
        for (RawatInapEntity objek : arrayInap) {
            Object[] data = new String[] {
                    objek.getPasien().getNama(),
                    String.valueOf(objek.getPasien().getUmur()),
                    objek.getPasien().getAlamat(),
                    objek.getKamar().getJenisKamar(),
                    String.valueOf(FormatUang.formatRupiah(objek.getKamar().getHargaPermalam())),
                    String.valueOf(objek.getBerapaMalam()),
                    String.valueOf(FormatUang.formatRupiah(objek.getTotalHarga())),
                    objek.getTanggalMasuk(),
                    objek.getTanggalKeluar(),
            };
            dataTable.addRow(data);

        }
        return dataTable;
    }
}

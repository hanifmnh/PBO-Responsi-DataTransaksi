package Transaksi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewData extends JFrame {
    JLabel lId = new JLabel("ID Transaksi");
    JLabel lNama = new JLabel("Nama Barang");
    JLabel lKasir = new JLabel("Nama Kasir");
    JLabel lJumlah = new JLabel("Jumlah Barang");
    JLabel lHarga = new JLabel("Harga Satuan");
    JLabel lDiskon = new JLabel("Diskon");

    public JTextField tfId = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfKasir = new JTextField();
    public JTextField tfJumlah = new JTextField();
    public JTextField tfHarga = new JTextField();
    public JTextField tfDiskon = new JTextField();

    public JButton btnCreate = new JButton("Create");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnClear = new JButton("Clear");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object[] namaKolom = {"ID Transaksi", "Nama Barang", "Nama Kasir", "Jumlah Barang", "Harga Satuan", "Diskon", "Total Harga"};

    public ViewData() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("DATA TRANSAKSI");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 600, 500);

        add(lId);
        add(lNama);
        add(lKasir);
        add(lJumlah);
        add(lHarga);
        add(lDiskon);

        lId.setBounds(650, 40, 90, 25);
        lNama.setBounds(650, 90, 90, 25);
        lKasir.setBounds(650, 140, 90, 25);
        lJumlah.setBounds(650, 190, 90, 25);
        lHarga.setBounds(650, 240, 90, 25);
        lDiskon.setBounds(650, 290, 90, 25);

        add(tfId);
        add(tfNama);
        add(tfKasir);
        add(tfJumlah);
        add(tfHarga);
        add(tfDiskon);

        tfId.setBounds(640, 65, 140, 25);
        tfNama.setBounds(640, 115, 140, 25);
        tfKasir.setBounds(640, 165, 140, 25);
        tfJumlah.setBounds(640, 215, 140, 25);
        tfHarga.setBounds(640, 265, 140, 25);
        tfDiskon.setBounds(640, 315, 140, 25);

        add(btnCreate);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);

        btnCreate.setBounds(640, 365, 140, 30);
        btnUpdate.setBounds(640, 400, 140, 30);
        btnDelete.setBounds(640, 435, 140, 30);
        btnClear.setBounds(640, 470, 140, 30);

    }

    public String getId() {
        return tfId.getText();
    }

    public String getNama() {
        return tfNama.getText();
    }

    public String getKasir() {
        return tfKasir.getText();
    }

    public String getJumlah() {
        return tfJumlah.getText();
    }

    public String getHarga() {
        return tfHarga.getText();
    }

    public String getDiskon() {
        return tfDiskon.getText();
    }
}
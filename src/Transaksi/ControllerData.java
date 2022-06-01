package Transaksi;

import java.awt.event.*;
import javax.swing.*;

public class ControllerData {
    ModelData modelData;
    ViewData viewData;

    public String data;

    public ControllerData(ModelData modelData, ViewData viewData) {
        this.modelData = modelData;
        this.viewData = viewData;

        if (modelData.getBanyakData()!=0) {
            String[][] dataTransaksi = modelData.listTransaksi();
            viewData.tabel.setModel((new JTable(dataTransaksi, viewData.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewData.tabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int row = viewData.tabel.getSelectedRow();
                data = viewData.tabel.getValueAt(row, 0).toString();
                System.out.println(data);
            }
        });

        viewData.btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = viewData.getId();
                String nama = viewData.getNama();
                String kasir = viewData.getKasir();
                int jumlah = Integer.parseInt(viewData.getJumlah());
                double harga = Double.parseDouble(viewData.getHarga());
                double diskon = Double.parseDouble(viewData.getDiskon());
                double total = (harga * ((100-diskon)/100));
                modelData.insertData(id, nama, kasir, jumlah, harga, diskon, total);

                String[][] dataTransaksi = modelData.listTransaksi();
                viewData.tabel.setModel((new JTable(dataTransaksi, viewData.namaKolom)).getModel());
            }
        });

        viewData.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = viewData.getId();
                String nama = viewData.getNama();
                String kasir = viewData.getKasir();
                int jumlah = Integer.parseInt(viewData.getJumlah());
                double harga = Double.parseDouble(viewData.getHarga());
                double diskon = Double.parseDouble(viewData.getDiskon());
                double total = (harga * ((100-diskon)/100));
                modelData.updateData(id, nama, kasir, jumlah, harga, diskon, total);

                String[][] dataTransaksi = modelData.listTransaksi();
                viewData.tabel.setModel((new JTable(dataTransaksi, viewData.namaKolom)).getModel());
            }
        });

        viewData.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int confirm = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menghapus Barang Dengan Kode " + data + "?", "Opsi", JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    modelData.deleteData(data);
                    String[][] dataTransaksi = modelData.listTransaksi();
                    viewData.tabel.setModel((new JTable(dataTransaksi, viewData.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Jadi Dihapus");
                }
            }
        });

        viewData.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewData.tfId.setText("");
                viewData.tfNama.setText("");
                viewData.tfKasir.setText("");
                viewData.tfJumlah.setText("");
                viewData.tfHarga.setText("");
                viewData.tfDiskon.setText("");
            }
        });
    }
}

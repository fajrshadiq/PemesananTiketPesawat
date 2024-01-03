/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketpesawat;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LENOVO
 */
public class transaksi extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();

    /**
     * Creates new form transaksi
     */
    public transaksi() {
        initComponents();
        k.connect();
        refreshTable();
    }
    
    class tran extends transaksi{
        int id_transaksi, harga_tiket, jumlah_tiket, total_pembayaran;
        String nama_pelanggan,tanggal, nama_maskapai, tujuan_penerbangan, jenis_penerbangan, jam_penerbangan;
        
        public tran(){
            this.nama_pelanggan = namaText.getText();
            this.tanggal = tanggalText.getText();
            this.nama_maskapai = cb_maskapai.getSelectedItem().toString();
            this.tujuan_penerbangan = cbTujuan.getSelectedItem().toString();
            this.jenis_penerbangan = cbJenis.getSelectedItem().toString();
            this.jam_penerbangan = cbJam.getSelectedItem().toString();
            this.harga_tiket = Integer.parseInt(hargaText.getText());
            this.jumlah_tiket = Integer.parseInt(jumlahText.getText());
            this.total_pembayaran = this.harga_tiket * this.jumlah_tiket;
        }
    
    }
    
        public void refreshTable(){
            model = new DefaultTableModel();
            model.addColumn("ID Transaksi");
            model.addColumn("Nama Pelanggan");
            model.addColumn("Tanggal");
            model.addColumn("Nama Maskapai");
            model.addColumn("Tujuan Penerbangan");
            model.addColumn("Jenis Penerbangan");
            model.addColumn("Jam Penerbangan");
            model.addColumn("Harga Tiket");
            model.addColumn("Jumlah Tiket");
            model.addColumn("Total Pembayaran");
            tableTransaksi.setModel(model);
            
            try {
            this.stat = k.getCon().prepareStatement("select * from transaksi");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
               Object[] data = { 
                   rs.getInt("id_transaksi"),
                   rs.getString("nama_pelanggan"),
                    rs.getString("tanggal"),
                   rs.getString("nama_maskapai"),
                   rs.getString("tujuan_penerbangan"),
                   rs.getString("jenis_penerbangan"),
                   rs.getString("jam_penerbangan"),
                   rs.getInt("harga_tiket"),
                   rs.getInt("jumlah_tiket"),
                   rs.getInt("total_pembayaran")
               };
              model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            IDTransaksiText.setText("");
            namaText.setText("");
            hargaText.setText("");
            jumlahText.setText("");
            totalText.setText("");
        }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namaText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IDTransaksiText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbJenis = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbJam = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        hargaText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jumlahText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btInput = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        cbTujuan = new javax.swing.JComboBox<>();
        btLogout = new javax.swing.JButton();
        cb_maskapai = new javax.swing.JComboBox<>();
        btHitung = new javax.swing.JButton();
        tanggalText = new com.github.lgooddatepicker.components.DatePicker();
        btCetak = new javax.swing.JButton();
        btMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Transaksi Penjualan");

        jLabel2.setText("ID Transaksi");

        jLabel3.setText("Nama Pelanggan");

        IDTransaksiText.setEnabled(false);
        IDTransaksiText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTransaksiTextActionPerformed(evt);
            }
        });

        jLabel5.setText("Tanggal");

        jLabel6.setText("Nama Maskapai");

        jLabel7.setText("Tujuan Penerbangan");

        jLabel8.setText("Kelas Penerbangan");

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Business Class", "Economy Class" }));

        jLabel9.setText("Jam Penerbangan");

        cbJam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "06 : 00", "10 : 00", "14 : 00", "16 : 00", "20 : 00", "23 : 00" }));

        jLabel10.setText("Harga Tiket");

        jLabel11.setText("Jumlah Tiket");

        jumlahText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jumlahTextFocusGained(evt);
            }
        });
        jumlahText.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jumlahTextInputMethodTextChanged(evt);
            }
        });
        jumlahText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahTextKeyTyped(evt);
            }
        });

        jLabel12.setText("Total Pembayaran");

        btInput.setText("SUBMIT");
        btInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInputActionPerformed(evt);
            }
        });

        btDelete.setText("DELETE");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setText("UPDATE");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btInput, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btInput, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addContainerGap())
        );

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTransaksi);

        cbTujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAKARTA", "BANDUNG", "YOGYAKARTA", "BALI", "SURABAYA", "SOLO", "BANJARMASIN" }));

        btLogout.setText("LOGOUT");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        cb_maskapai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garuda Air", "Lion Air", "Citilink" }));

        btHitung.setLabel("Hitung");
        btHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHitungActionPerformed(evt);
            }
        });

        btCetak.setText("CETAK LAPORAN");
        btCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCetakActionPerformed(evt);
            }
        });

        btMenu.setText("MENU JADWAL PENERBANGAN");
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IDTransaksiText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbTujuan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_maskapai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbJenis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(185, 185, 185)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tanggalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbJam, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jumlahText, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btHitung))
                                                    .addComponent(hargaText, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(179, 179, 179)
                                                .addComponent(jLabel12)
                                                .addGap(18, 18, 18)
                                                .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCetak)
                        .addGap(22, 22, 22))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btMenu)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btLogout)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDTransaksiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(tanggalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(hargaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_maskapai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btHitung)
                    .addComponent(jumlahText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCetak))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IDTransaksiTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDTransaksiTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDTransaksiTextActionPerformed

    private void btInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInputActionPerformed
        // TODO add your handling code here:
        try {
          tran t = new tran();
          this.stat = k.getCon().prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?,?,?)");
          stat.setInt(1, 0);
          stat.setString(2, t.nama_pelanggan);
          stat.setString(3, t.tanggal);
          stat.setString(4, t.nama_maskapai);
          stat.setString(5, t.tujuan_penerbangan);
          stat.setString(6, t.jenis_penerbangan);
          stat.setString(7, t.jam_penerbangan);
          stat.setInt(8, t.harga_tiket);
          stat.setInt(9, t.jumlah_tiket);
          stat.setInt(10, t.total_pembayaran);
          stat.executeUpdate();
          refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btInputActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        try {
        tran t = new tran();
        this.stat = k.getCon().prepareStatement("update transaksi set nama_pelanggan=?,"
                + "tanggal=?, nama_maskapai=?, tujuan_penerbangan=?, jenis_penerbangan=?, jam_penerbangan=?, harga_tiket=?, jumlah_tiket=?, total_pembayaran=? where id_transaksi=? ");
        stat.setString(1, t.nama_pelanggan);
        stat.setString(2, t.tanggal);
        stat.setString(3, t.nama_maskapai);
        stat.setString(4, t.tujuan_penerbangan);
        stat.setString(5, t.jenis_penerbangan);
        stat.setString(6, t.jam_penerbangan);
        stat.setString(7, hargaText.getText());
        stat.setString(8, jumlahText.getText());
        stat.setString(9, totalText.getText());
        stat.setString(10, IDTransaksiText.getText());
        int rowsUpdated = stat.executeUpdate();
        
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(null, "Gagal mengupdate data. Coba lagi.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
       try {
        int confirmation = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Hapus Data", JOptionPane.OK_CANCEL_OPTION);
        
        if (confirmation == JOptionPane.OK_OPTION) {
            tran t = new tran();
            this.stat = k.getCon().prepareStatement("delete from transaksi where id_transaksi=?");
            stat.setString(1, IDTransaksiText.getText());
            int rowsDeleted = stat.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menghapus data. Coba lagi.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransaksiMouseClicked
        // Mengambil nilai cb
        String maskapaiValue = model.getValueAt(tableTransaksi.getSelectedRow(), 3).toString();
        String tujuanValue = model.getValueAt(tableTransaksi.getSelectedRow(), 4).toString();
        String jenisValue = model.getValueAt(tableTransaksi.getSelectedRow(), 5).toString();
        String jamValue = model.getValueAt(tableTransaksi.getSelectedRow(), 6).toString();
        
    // Mengatur nilai pada JComboBox cbJam, cbJenis, cbTujuan
         cb_maskapai.setSelectedItem(maskapaiValue);
        cbJam.setSelectedItem(jamValue);
        cbJenis.setSelectedItem(jenisValue);
        cbTujuan.setSelectedItem(tujuanValue);
        
       IDTransaksiText.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 0).toString());
        namaText.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 1).toString());
        tanggalText.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 2).toString());
        hargaText.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 7).toString());
        jumlahText.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 8).toString());
        totalText.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 9).toString());
       
    }//GEN-LAST:event_tableTransaksiMouseClicked

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCetakActionPerformed
        // TODO add your handling code here:
        
        try {
            File namafile = new File("src/laporan/laporan_transaksi.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, k.getCon());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btCetakActionPerformed

    private void jumlahTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jumlahTextFocusGained
        
    }//GEN-LAST:event_jumlahTextFocusGained

    private void jumlahTextInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jumlahTextInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahTextInputMethodTextChanged

    private void jumlahTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahTextKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahTextKeyTyped

    private void btHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHitungActionPerformed
        // Mendapatkan nilai dari hargaText dan jumlahText
    String hargaStr = hargaText.getText();
    String jumlahStr = jumlahText.getText();

    // Memastikan bahwa nilai tidak kosong
    if (!hargaStr.isEmpty() && !jumlahStr.isEmpty()) {
        // Mengkonversi nilai menjadi tipe data numerik
        double harga = Double.parseDouble(hargaStr);
        int jumlah = Integer.parseInt(jumlahStr);

        // Melakukan perhitungan
        double total = harga * jumlah;

        // Menetapkan nilai total ke totalText
        totalText.setText(String.valueOf(total));
    }
    }//GEN-LAST:event_btHitungActionPerformed

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        // TODO add your handling code here:
        lPenerbangan pener =  new lPenerbangan();
        pener.setVisible(true);
        this.setVisible(false);
        pener.btInput.setVisible(true);
        pener.btDelete.setVisible(true);
        pener.btUpdate.setVisible(true);
        pener.btMenu.setVisible(true);
    }//GEN-LAST:event_btMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDTransaksiText;
    private javax.swing.JButton btCetak;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btHitung;
    private javax.swing.JButton btInput;
    private javax.swing.JButton btLogout;
    public javax.swing.JButton btMenu;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cbJam;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JComboBox<String> cbTujuan;
    private javax.swing.JComboBox<String> cb_maskapai;
    private javax.swing.JTextField hargaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahText;
    private javax.swing.JTextField namaText;
    private javax.swing.JTable tableTransaksi;
    private com.github.lgooddatepicker.components.DatePicker tanggalText;
    private javax.swing.JTextField totalText;
    // End of variables declaration//GEN-END:variables
}

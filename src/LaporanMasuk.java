
import connection.DatabaseConnection;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ibnub
 */
public class LaporanMasuk extends javax.swing.JFrame {

    private int noTransMasuk, idUser = 0;
    private Statement statement;
    DefaultTableModel tblMasuk = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };

    /**
     * Creates new form LaporanMasuk
     */
    public LaporanMasuk() {
        try {
            statement = DatabaseConnection.getDatabaseConnection().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        initComponents();
        initiateData();
        getData();
        setClickableOnTable();
    }

    public LaporanMasuk(int idUser) {

        this.idUser = idUser;

        try {
            statement = DatabaseConnection.getDatabaseConnection().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        initComponents();
        initiateData();
        getData();
        setClickableOnTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporanMasuk = new javax.swing.JTable();
        edtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txTrans = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblLaporanMasuk.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLaporanMasuk);

        edtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtSearchKeyReleased(evt);
            }
        });

        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txTrans.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        txTrans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txTrans.setText("RIWAYAT TRANSAKSI MASUK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addComponent(txTrans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            if (noTransMasuk > 0) {
                int dialog = JOptionPane.showOptionDialog(null, "Apakah anda yakin untuk menghapus data?", "Delete", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if (dialog == JOptionPane.OK_OPTION) {
                    deleteData();
                    getData();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!");
            }
        } finally {
            tblMasuk.fireTableDataChanged();
            tblLaporanMasuk.repaint();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void edtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtSearchKeyReleased
        if (edtSearch.getText().isBlank() || edtSearch.getText().isEmpty()) {
            searchData();
        }
    }//GEN-LAST:event_edtSearchKeyReleased

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (noTransMasuk > 0) {

            TransaksiMasuk tm = new TransaksiMasuk(noTransMasuk, idUser);
            tm.setVisible(true);
            tm.pack();
            tm.setLocationRelativeTo(null);
            tm.setDefaultCloseOperation(ArtaLele_.DISPOSE_ON_CLOSE);

            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void searchData() {
        String tanggal = edtSearch.getText();

        int rowCount = tblLaporanMasuk.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tblMasuk.removeRow(0);
        }

        try {
            int noTransaksiMasuk, idUser, total;
            String berat, deskripsi, tanggalTransaksiMasuk;

            Statement statement = DatabaseConnection.getDatabaseConnection().createStatement();
            String sqlStatement = "SELECT * FROM transaksi_masuk WHERE tanggal_trans_masuk LIKE '%" + tanggal + "%'";
//            sqlStatement = String.format(sqlStatement, tanggal);

            ResultSet res = statement.executeQuery(sqlStatement);

            while (res.next()) {
                noTransaksiMasuk = res.getInt("no_trans_masuk");
                idUser = res.getInt("id_user");
                total = res.getInt("total");
                berat = res.getString("berat");
                deskripsi = res.getString("deskripsi");
                tanggalTransaksiMasuk = res.getString("tanggal_trans_masuk");

                Object[] row = {
                    noTransaksiMasuk, idUser, total, berat, deskripsi, tanggalTransaksiMasuk
                };

                tblMasuk.addRow(row);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        tblLaporanMasuk.setModel(tblMasuk);
    }

    private String deleteData() {
        String status;

        try {
            String sqlQuery = "DELETE FROM transaksi_masuk WHERE no_trans_masuk='%d'";
            sqlQuery = String.format(sqlQuery, noTransMasuk);
            statement.execute(sqlQuery);

            status = "sukses";
        } catch (Exception e) {
            e.printStackTrace();
            status = "gagal";
        }
        return status;
    }

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
            java.util.logging.Logger.getLogger(LaporanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanMasuk().setVisible(true);
            }
        });
    }

    private void setClickableOnTable() {
//        int row = tblMasuk.getSelectedRow(), column = 0;

        tblLaporanMasuk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblLaporanMasuk.rowAtPoint(e.getPoint());
                String rawNoTransaksiMasuk = tblLaporanMasuk.getModel().getValueAt(row, 0).toString();
                noTransMasuk = Integer.parseInt(rawNoTransaksiMasuk);
            }

        });
    }

    private void initiateData() {
        tblMasuk.addColumn("No Transaksi");
        tblMasuk.addColumn("Pencatat");
        tblMasuk.addColumn("Berat");
        tblMasuk.addColumn("Total");
        tblMasuk.addColumn("Deskripsi");
        tblMasuk.addColumn("Tanggal");
        tblLaporanMasuk.setModel(tblMasuk);
    }

    private void getData() {

        int rowCount = tblLaporanMasuk.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tblMasuk.removeRow(0);
        }

        try {
            Statement statement = DatabaseConnection.getDatabaseConnection().createStatement();
            String sqlStatement = "SELECT * FROM transaksi_masuk";
            ResultSet res = statement.executeQuery(sqlStatement);

            while (res.next()) {
                int noTransaksiMasuk, idUser, total;
                String berat, deskripsi, tanggalTransaksiMasuk;

                noTransaksiMasuk = res.getInt("no_trans_masuk");
                idUser = res.getInt("id_user");
                total = res.getInt("total");
                berat = res.getString("berat");
                deskripsi = res.getString("deskripsi");
                tanggalTransaksiMasuk = res.getString("tanggal_trans_masuk");

                Object[] row = {
                    noTransaksiMasuk, idUser, total, berat, deskripsi, tanggalTransaksiMasuk
                };

                tblMasuk.addRow(row);
                tblMasuk.fireTableDataChanged();
            }

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan karena : " + e);
            e.printStackTrace();
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField edtSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLaporanMasuk;
    private javax.swing.JLabel txTrans;
    // End of variables declaration//GEN-END:variables
}


import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
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
public class LaporanKeluar extends javax.swing.JFrame {

    private int idUser = 0, noTransKeluar = 0;

    DefaultTableModel tblKeluar = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };

    /**
     * Creates new form LaporanKeluar
     */
    public LaporanKeluar() {
        initComponents();
        initiateData();
        getData();
    }

    public LaporanKeluar(int idUser) {
        this.idUser = idUser;
        initComponents();
        initiateData();
        getData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporanKeluar = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        cmbBulan = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txTrans = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

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

        tblLaporanKeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLaporanKeluar.setRowHeight(30);
        tblLaporanKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLaporanKeluarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLaporanKeluar);

        btnSearch.setText("Filter");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cmbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jPanel1.setBackground(new java.awt.Color(116, 234, 246));

        txTrans.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        txTrans.setForeground(new java.awt.Color(255, 255, 255));
        txTrans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txTrans.setText("RIWAYAT TRANSAKSI KELUAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(cmbBulan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            if (noTransKeluar > 0) {
                int dialog = JOptionPane.showOptionDialog(null, "Apakah anda yakin untuk menghapus data?", "Delete", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if (dialog == JOptionPane.OK_OPTION) {
                    deleteData();
                    getData();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!");
            }

        } finally {
            tblKeluar.fireTableDataChanged();
            tblLaporanKeluar.repaint();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (noTransKeluar > 0) {

            TransaksiKeluar tk = new TransaksiKeluar(noTransKeluar, idUser);
            tk.setVisible(true);
            tk.pack();
            tk.setLocationRelativeTo(null);
            tk.setDefaultCloseOperation(ArtaLele_.DISPOSE_ON_CLOSE);

            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu!");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblLaporanKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLaporanKeluarMouseClicked
        int row = tblLaporanKeluar.rowAtPoint(evt.getPoint());
        String rawNoTransaksiKeluar = tblLaporanKeluar.getModel().getValueAt(row, 0).toString();
        noTransKeluar = Integer.parseInt(rawNoTransaksiKeluar);
    }//GEN-LAST:event_tblLaporanKeluarMouseClicked

    private void searchData() {
        String tanggal = String.valueOf(cmbBulan.getSelectedItem());

        int rowCount = tblLaporanKeluar.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tblKeluar.removeRow(0);
        }

        try {
            int noTransaksiMasukForTable, idUserForTable, total;
            String kategori, deskripsi, tanggalTransaksiKeluar;

            Statement statement = DatabaseConnection.getDatabaseConnection().createStatement();
            String sqlStatement = "SELECT * FROM transaksi_keluar WHERE tanggal_trans_keluar LIKE '%" + tanggal + "%'";

            ResultSet res = statement.executeQuery(sqlStatement);

            while (res.next()) {
                noTransaksiMasukForTable = res.getInt("no_trans_keluar");
                idUserForTable = res.getInt("id_user");
                total = res.getInt("total");
                deskripsi = res.getString("deskripsi");
                kategori = res.getString("kategori");
                tanggalTransaksiKeluar = res.getString("tanggal_trans_keluar");

                Object[] row = {
                    noTransaksiMasukForTable, idUserForTable, total, deskripsi, kategori, tanggalTransaksiKeluar
                };

                tblKeluar.addRow(row);
//                tblKeluar.fireTableDataChanged();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        tblLaporanKeluar.setModel(tblKeluar);
    }

    private String deleteData() {
        String status;

        int rowCount = tblLaporanKeluar.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tblKeluar.removeRow(0);
        }

        try {
            Statement statement = DatabaseConnection.getDatabaseConnection().createStatement();

            String sqlQuery = "DELETE FROM transaksi_keluar WHERE no_trans_keluar='%d'";
            sqlQuery = String.format(sqlQuery, noTransKeluar);
            statement.execute(sqlQuery);

            status = "sukses";
        } catch (Exception e) {
            e.printStackTrace();
            status = "gagal";
        }
        return status;
    }

    private void initiateData() {

        tblLaporanKeluar.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblLaporanKeluar.getTableHeader().setOpaque(false);
        tblLaporanKeluar.getTableHeader().setBackground(Color.BLUE);
        tblLaporanKeluar.getTableHeader().setForeground(Color.WHITE);

        tblKeluar.addColumn("No Transaksi");
        tblKeluar.addColumn("Pencatat");
        tblKeluar.addColumn("Total");
        tblKeluar.addColumn("Deskripsi");
        tblKeluar.addColumn("Kategori");
        tblKeluar.addColumn("Tanggal");
        tblLaporanKeluar.setModel(tblKeluar);
    }

    private void getData() {

        int rowCount = tblLaporanKeluar.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tblKeluar.removeRow(0);
        }

        try {
            int noTransaksiMasukForTable, idUserForTable, total;
            String kategori, deskripsi, tanggalTransaksiKeluar;

            Statement statement = DatabaseConnection.getDatabaseConnection().createStatement();
            String sqlStatement = "SELECT * FROM transaksi_keluar";
            ResultSet res = statement.executeQuery(sqlStatement);

            while (res.next()) {
                noTransaksiMasukForTable = res.getInt("no_trans_keluar");
                idUserForTable = res.getInt("id_user");
                total = res.getInt("total");
                deskripsi = res.getString("deskripsi");
                kategori = res.getString("kategori");
                tanggalTransaksiKeluar = res.getString("tanggal_trans_keluar");

                Object[] row = {
                    noTransaksiMasukForTable, idUserForTable, total, deskripsi, kategori, tanggalTransaksiKeluar
                };

                tblKeluar.addRow(row);
                tblKeluar.fireTableDataChanged();
            }

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan karena : " + e);
            e.printStackTrace();
        }

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
            java.util.logging.Logger.getLogger(LaporanKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanKeluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbBulan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLaporanKeluar;
    private javax.swing.JLabel txTrans;
    // End of variables declaration//GEN-END:variables
}

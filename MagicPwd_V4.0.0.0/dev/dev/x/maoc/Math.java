/*
 *  Copyright (C) 2011 yaoshangwen
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Math.java
 *
 * Created on 2011-2-16, 17:28:08
 */

package dev.x.maoc;

/**
 *
 * @author yaoshangwen
 */
public class Math extends javax.swing.JPanel {

    /** Creates new form Math */
    public Math() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ExpList = new javax.swing.JTable();
        lb_ExpText = new javax.swing.JLabel();
        tf_ExpText = new javax.swing.JTextField();
        bt_AocHelp = new javax.swing.JButton();
        bt_ExpText = new javax.swing.JButton();

        tb_ExpList.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_ExpList);

        lb_ExpText.setText("计算公式(F)");

        tf_ExpText.setText("jTextField1");
        tf_ExpText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ExpTextActionPerformed(evt);
            }
        });

        bt_AocHelp.setText("?");
        bt_AocHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AocHelpActionPerformed(evt);
            }
        });

        bt_ExpText.setText("=");
        bt_ExpText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ExpTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_ExpText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_ExpText, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_ExpText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_AocHelp)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ExpText)
                    .addComponent(tf_ExpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_AocHelp)
                    .addComponent(bt_ExpText))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ExpTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ExpTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_ExpTextActionPerformed

    private void bt_AocHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AocHelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_AocHelpActionPerformed

    private void tf_ExpTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ExpTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ExpTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_AocHelp;
    private javax.swing.JButton bt_ExpText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_ExpText;
    private javax.swing.JTable tb_ExpList;
    private javax.swing.JTextField tf_ExpText;
    // End of variables declaration//GEN-END:variables

}

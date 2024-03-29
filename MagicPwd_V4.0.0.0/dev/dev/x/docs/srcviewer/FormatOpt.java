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
 * FormatOpt.java
 *
 * Created on 2011-1-21, 16:24:45
 */

package dev.x.docs.srcviewer;

/**
 *
 * @author yaoshangwen
 */
public class FormatOpt extends javax.swing.JPanel {

    /** Creates new form FormatOpt */
    public FormatOpt() {
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

        lb_LineNbr = new javax.swing.JLabel();
        ck_LineNbr = new javax.swing.JCheckBox();
        ck_LinkUri = new javax.swing.JCheckBox();
        ck_TagStyle = new javax.swing.JComboBox();
        lb_LinkUri = new javax.swing.JLabel();
        lb_TagStyle = new javax.swing.JLabel();
        tf_TagCount = new javax.swing.JTextField();
        lb_TabCount = new javax.swing.JLabel();
        tt_TabCount = new javax.swing.JLabel();

        lb_LineNbr.setText("行号：");

        ck_LineNbr.setText("显示行号");

        ck_LinkUri.setText("显示资源链接");

        ck_TagStyle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lb_LinkUri.setText("资源：");

        lb_TagStyle.setText("格式：");

        tf_TagCount.setColumns(2);
        tf_TagCount.setText("jTextField1");

        lb_TabCount.setText("制表符：");

        tt_TabCount.setText("空格/制表符");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_LineNbr, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_LinkUri, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_TagStyle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_TabCount, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_TagCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tt_TabCount))
                    .addComponent(ck_TagStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ck_LinkUri)
                    .addComponent(ck_LineNbr))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_LineNbr)
                    .addComponent(ck_LineNbr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ck_LinkUri)
                    .addComponent(lb_LinkUri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ck_TagStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TagStyle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_TagCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_TabCount)
                    .addComponent(tt_TabCount))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ck_LineNbr;
    private javax.swing.JCheckBox ck_LinkUri;
    private javax.swing.JComboBox ck_TagStyle;
    private javax.swing.JLabel lb_LineNbr;
    private javax.swing.JLabel lb_LinkUri;
    private javax.swing.JLabel lb_TabCount;
    private javax.swing.JLabel lb_TagStyle;
    private javax.swing.JTextField tf_TagCount;
    private javax.swing.JLabel tt_TabCount;
    // End of variables declaration//GEN-END:variables

}

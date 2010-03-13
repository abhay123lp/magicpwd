/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UcfgProp.java
 *
 * Created on 2010-3-13, 10:06:39
 */

package test.draw.p;

/**
 *
 * @author Amon
 */
public class UcfgProp extends javax.swing.JPanel {

    /** Creates new form UcfgProp */
    public UcfgProp() {
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

        lb_UserLang = new javax.swing.JLabel();
        cb_UserLang = new javax.swing.JComboBox();
        lb_PwdsChar = new javax.swing.JLabel();
        cb_PwdsChar = new javax.swing.JComboBox();
        lb_PwdsSize = new javax.swing.JLabel();
        tf_PwdsSize = new javax.swing.JTextField();
        ck_PwdsUrpt = new javax.swing.JCheckBox();
        lb_BackCount = new javax.swing.JLabel();
        tf_BackCount = new javax.swing.JTextField();
        lb_BackPath = new javax.swing.JLabel();
        tf_BackPath = new javax.swing.JTextField();
        bt_BackPath = new javax.swing.JButton();
        lb_StayTime = new javax.swing.JLabel();
        tf_StayTime = new javax.swing.JTextField();

        lb_UserLang.setText("语言区域");

        cb_UserLang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lb_PwdsChar.setText("口令字符空间");

        cb_PwdsChar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lb_PwdsSize.setText("口令字长长度");

        tf_PwdsSize.setColumns(6);
        tf_PwdsSize.setText("8");

        ck_PwdsUrpt.setText("不可重复");

        lb_BackCount.setText("备份文件数量");

        tf_BackCount.setColumns(6);
        tf_BackCount.setText("5");

        lb_BackPath.setText("备份文件路径");

        tf_BackPath.setColumns(20);
        tf_BackPath.setText("jTextField3");

        bt_BackPath.setText(">>");
        bt_BackPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BackPathActionPerformed(evt);
            }
        });

        lb_StayTime.setText("剪贴板口令驻留时间");

        tf_StayTime.setColumns(6);
        tf_StayTime.setText("60");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_UserLang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_UserLang, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_PwdsChar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_PwdsChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_PwdsSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_PwdsSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ck_PwdsUrpt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_BackCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_BackCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_BackPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_BackPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_BackPath))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_StayTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_StayTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_UserLang)
                    .addComponent(cb_UserLang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_PwdsChar)
                    .addComponent(cb_PwdsChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_PwdsSize)
                    .addComponent(tf_PwdsSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ck_PwdsUrpt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_BackCount)
                    .addComponent(tf_BackCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_BackPath)
                    .addComponent(tf_BackPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_BackPath))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_StayTime)
                    .addComponent(tf_StayTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_BackPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BackPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_BackPathActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_BackPath;
    private javax.swing.JComboBox cb_PwdsChar;
    private javax.swing.JComboBox cb_UserLang;
    private javax.swing.JCheckBox ck_PwdsUrpt;
    private javax.swing.JLabel lb_BackCount;
    private javax.swing.JLabel lb_BackPath;
    private javax.swing.JLabel lb_PwdsChar;
    private javax.swing.JLabel lb_PwdsSize;
    private javax.swing.JLabel lb_StayTime;
    private javax.swing.JLabel lb_UserLang;
    private javax.swing.JTextField tf_BackCount;
    private javax.swing.JTextField tf_BackPath;
    private javax.swing.JTextField tf_PwdsSize;
    private javax.swing.JTextField tf_StayTime;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Load.java
 *
 * Created on 2010-1-29, 13:17:19
 */

package draw.v;

/**
 *
 * @author Administrator
 */
public class Load extends javax.swing.JPanel {

    /** Creates new form Load */
    public Load() {
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

        bt_Download = new javax.swing.JButton();
        bt_Replay = new javax.swing.JButton();
        bt_Delete = new javax.swing.JButton();
        lb_MailInfo = new javax.swing.JLabel();

        bt_Download.setText("jButton1");

        bt_Replay.setText("jButton2");

        bt_Delete.setText("jButton3");

        lb_MailInfo.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lb_MailInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_Replay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_Download))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bt_Download)
                .addComponent(bt_Replay)
                .addComponent(bt_Delete)
                .addComponent(lb_MailInfo))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Delete;
    private javax.swing.JButton bt_Download;
    private javax.swing.JButton bt_Replay;
    private javax.swing.JLabel lb_MailInfo;
    // End of variables declaration//GEN-END:variables

}

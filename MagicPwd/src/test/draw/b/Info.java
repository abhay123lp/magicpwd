/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Info.java
 *
 * Created on 2010-2-19, 11:35:56
 */

package test.draw.b;

/**
 *
 * @author Administrator
 */
public class Info extends javax.swing.JPanel {

    /** Creates new form Info */
    public Info() {
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

        lb_PropName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_PropData = new javax.swing.JTextArea();
        lb_NextTips = new javax.swing.JLabel();

        lb_PropName.setText("jLabel1");

        ta_PropData.setColumns(20);
        ta_PropData.setRows(2);
        jScrollPane1.setViewportView(ta_PropData);

        lb_NextTips.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_PropName, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_NextTips))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_PropName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_NextTips))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_NextTips;
    private javax.swing.JLabel lb_PropName;
    private javax.swing.JTextArea ta_PropData;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * List.java
 *
 * Created on 2010-2-22, 21:57:22
 */

package test.draw.v;

/**
 *
 * @author Administrator
 */
public class List extends javax.swing.JPanel {

    /** Creates new form List */
    public List() {
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

        lb_Major = new javax.swing.JLabel();
        lb_State = new javax.swing.JLabel();
        lb_Title = new javax.swing.JLabel();
        lb_Attach = new javax.swing.JLabel();
        lb_Other = new javax.swing.JLabel();

        lb_Major.setText("1");

        lb_State.setText("2");

        lb_Title.setText("3");

        lb_Attach.setText("5");

        lb_Other.setText("4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_Major)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_State)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Title, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Other)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Attach))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lb_Major)
                .addComponent(lb_State)
                .addComponent(lb_Title)
                .addComponent(lb_Attach)
                .addComponent(lb_Other))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_Attach;
    private javax.swing.JLabel lb_Major;
    private javax.swing.JLabel lb_Other;
    private javax.swing.JLabel lb_State;
    private javax.swing.JLabel lb_Title;
    // End of variables declaration//GEN-END:variables

}
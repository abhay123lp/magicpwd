/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HistProp.java
 *
 * Created on 2010-3-20, 6:14:32
 */

package plan.draw.p;

/**
 *
 * @author Amon
 */
public class HistProp extends javax.swing.JPanel {

    /** Creates new form HistProp */
    public HistProp() {
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

        javax.swing.JScrollPane sp_HistList = new javax.swing.JScrollPane();
        ls_HistList = new javax.swing.JList();
        pl_ItemEdit = new plan.draw.b.Edit();
        javax.swing.JScrollPane sp_HistInfo = new javax.swing.JScrollPane();
        ta_HistInfo = new javax.swing.JTextArea();

        ls_HistList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        sp_HistList.setViewportView(ls_HistList);

        ta_HistInfo.setColumns(20);
        ta_HistInfo.setRows(5);
        sp_HistInfo.setViewportView(ta_HistInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sp_HistList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pl_ItemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp_HistInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_HistList, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pl_ItemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sp_HistInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ls_HistList;
    private plan.draw.b.Edit pl_ItemEdit;
    private javax.swing.JTextArea ta_HistInfo;
    // End of variables declaration//GEN-END:variables

}
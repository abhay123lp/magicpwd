package com.magicpwd.x;

import com.magicpwd.__i.IBackCall;
import com.magicpwd._comn.prop.Kind;
import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Bean;
import com.magicpwd._util.Lang;
import com.magicpwd.r.KindTN;
import com.magicpwd.v.mpwd.MainPtn;

/**
 * 数据迁移对话窗口
 * @author Amon
 */
public class CatDialog extends javax.swing.JDialog
{

    private MainPtn mainPtn;
    private IBackCall backCall;

    public CatDialog(MainPtn mainPtn, IBackCall backCall)
    {
        super(mainPtn, true);
        this.mainPtn = mainPtn;
        this.backCall = backCall;
    }

    public void initView()
    {
        tr_KindList = new javax.swing.JTree();
        bt_Cancel = new javax.swing.JButton();
        bt_Update = new javax.swing.JButton();

        javax.swing.JScrollPane sp_KindList = new javax.swing.JScrollPane();
        tr_KindList.setModel(mainPtn.getTreeMdl());
        sp_KindList.setViewportView(tr_KindList);

        bt_Cancel.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_CancelActionPerformed(evt);
            }
        });

        bt_Update.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        javax.swing.GroupLayout.SequentialGroup hsg1 = layout.createSequentialGroup();
        hsg1.addComponent(bt_Update);
        hsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg1.addComponent(bt_Cancel);
        javax.swing.GroupLayout.ParallelGroup hpg = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        hpg.addComponent(sp_KindList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE);
        hpg.addGroup(hsg1);
        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();
        hsg.addContainerGap();
        hsg.addGroup(hpg);
        hsg.addContainerGap();
        layout.setHorizontalGroup(hsg);

        javax.swing.GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg1.addComponent(bt_Cancel);
        vpg1.addComponent(bt_Update);
        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
        vsg.addContainerGap();
        vsg.addComponent(sp_KindList, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg.addGroup(vpg1);
        vsg.addContainerGap();
        layout.setVerticalGroup(vsg);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(Bean.getLogo(16));
        pack();
        Bean.centerForm(this, mainPtn);
    }

    public void initLang()
    {
        Lang.setWText(bt_Update, LangRes.P30FA50A, "确定(@O)");

        Lang.setWText(bt_Cancel, LangRes.P30FA50B, "取消(@C)");

        setTitle(Lang.getLang(LangRes.P30F4206, "把记录迁移到..."));
    }

    public void initData()
    {
    }

    void bt_UpdateActionPerformed(java.awt.event.ActionEvent evt)
    {
        javax.swing.tree.TreePath tp = tr_KindList.getSelectionPath();
        if (tp == null)
        {
            Lang.showMesg(this, LangRes.P30FAA19, "请选择您要移动的目标类别！");
            return;
        }

        Object obj = tp.getLastPathComponent();
        if (obj instanceof KindTN)
        {
            KindTN item = (KindTN) obj;
            Kind kind = (Kind) item.getUserObject();
            backCall.callBack(null, null, kind.getC2010103());
        }
        this.setVisible(false);
        this.dispose();
    }

    void bt_CancelActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.setVisible(false);
        this.dispose();
    }
    private javax.swing.JTree tr_KindList;
    private javax.swing.JButton bt_Update;
    private javax.swing.JButton bt_Cancel;
}
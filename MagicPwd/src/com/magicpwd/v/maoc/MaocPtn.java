/*
 *  Copyright (C) 2010 Amon
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
package com.magicpwd.v.maoc;

import com.magicpwd.__a.AFrame;
import com.magicpwd._comp.BtnLabel;
import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Bean;
import com.magicpwd._util.Char;
import com.magicpwd._util.Lang;
import com.magicpwd._util.Logs;
import com.magicpwd.m.UserMdl;
import com.magicpwd.m.maoc.MaocMdl;
import com.magicpwd.v.MenuPtn;
import com.magicpwd.v.tray.TrayPtn;
import org.javia.arity.Symbols;

/**
 * 计算器
 * 
 * @author Amon
 */
public class MaocPtn extends AFrame
{

    private int precision;
    private MaocMdl maocMdl;
    private MenuPtn menuPtn;
    private Symbols symbols;

    public MaocPtn(TrayPtn trayPtn, UserMdl userMdl)
    {
        super(trayPtn, userMdl);
    }

    public void initView()
    {
        initArgView();
        initExpView();
        initBaseView();
    }

    private void initArgView()
    {
        sp_ArgBean = new javax.swing.JPanel();

        ls_NumList = new javax.swing.JList();
        sp_NumList = new javax.swing.JScrollPane(ls_NumList);
        ls_FunList = new javax.swing.JList();
        sp_FunList = new javax.swing.JScrollPane(ls_FunList);

        javax.swing.JSplitPane sp = new javax.swing.JSplitPane();
        sp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sp.setDividerLocation(120);
        sp.setOneTouchExpandable(true);
        sp.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        sp.setTopComponent(sp_NumList);
        sp.setRightComponent(sp_FunList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(sp_ArgBean);
        sp_ArgBean.setLayout(layout);

        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();
        hsg.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE);
        hsg.addGap(3);
        layout.setHorizontalGroup(hsg);

        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
        vsg.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE);
        layout.setVerticalGroup(vsg);
    }

    private void initExpView()
    {
        sp_ExpBean = new javax.swing.JPanel();
        tb_ExpList = new javax.swing.JTable();
        lb_ExpText = new javax.swing.JLabel();
        tf_ExpText = new javax.swing.JTextField();
        bt_AocHelp = new BtnLabel();
        bt_ExpText = new BtnLabel();

        javax.swing.JScrollPane sp_ExpList = new javax.swing.JScrollPane(tb_ExpList);

        lb_ExpText.setLabelFor(tf_ExpText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(sp_ExpBean);
        sp_ExpBean.setLayout(layout);
        javax.swing.GroupLayout.SequentialGroup hsg1 = layout.createSequentialGroup();
        hsg1.addComponent(lb_ExpText);
        hsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg1.addComponent(tf_ExpText, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE);
        hsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg1.addComponent(bt_ExpText);
        hsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg1.addComponent(bt_AocHelp);
        javax.swing.GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        hpg1.addComponent(sp_ExpList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE);
        hpg1.addGroup(hsg1);
        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup().addGap(6).addGroup(hpg1);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hsg));

        javax.swing.GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
        vpg1.addComponent(lb_ExpText);
        vpg1.addComponent(tf_ExpText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        vpg1.addComponent(bt_AocHelp);
        vpg1.addComponent(bt_ExpText);
        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
//        vsg.addContainerGap();
        vsg.addComponent(sp_ExpList, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg.addGroup(vpg1);
//        vsg.addContainerGap();
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vsg));
    }

    private void initBaseView()
    {
        javax.swing.JSplitPane sp = new javax.swing.JSplitPane();
        sp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sp.setDividerLocation(123);
        sp.setOneTouchExpandable(true);
        sp.setLeftComponent(sp_ArgBean);
        sp.setRightComponent(sp_ExpBean);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();
        hsg.addContainerGap();
        hsg.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE);
        hsg.addContainerGap();
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(hsg));

        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
        vsg.addContainerGap();
        vsg.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE);
        vsg.addContainerGap();
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(vsg));

        this.setIconImage(Bean.getLogo(16));

        this.pack();
        Bean.centerForm(this, null);
        this.setVisible(true);
    }

    public void initLang()
    {
        this.setTitle(Lang.getLang(LangRes.P30FB201, "计算器"));
        Bean.setText(lb_ExpText, Lang.getLang(LangRes.P30FB301, "计算式(@F)"));

        Bean.setText(bt_ExpText, Lang.getLang(LangRes.P30FB501, "@C"));
        Bean.setTips(bt_ExpText, Lang.getLang(LangRes.P30FB502, "运算(ALT + C)"));

        Bean.setText(bt_AocHelp, Lang.getLang(LangRes.P30FB503, "@O"));
        Bean.setTips(bt_AocHelp, Lang.getLang(LangRes.P30FB504, "选项(ALT + O)"));

        this.pack();
        Bean.centerForm(this, null);
    }

    public void initData()
    {
        maocMdl = new MaocMdl(userMdl);
        maocMdl.init();

        java.awt.event.ActionListener listener = new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                bt_ExpTextActionPerformed(e);
            }
        };
        tf_ExpText.addActionListener(listener);

        bt_ExpText.setIcon(readFavIcon("maoc-calc", false));
        bt_ExpText.addActionListener(listener);

        bt_AocHelp.setIcon(readFavIcon("maoc-help", false));
        bt_AocHelp.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                bt_AocHelpActionPerformed(e);
            }
        });

        symbols = new Symbols();

        pm_AocHelp = new javax.swing.JPopupMenu();
        menuPtn = new MenuPtn(trayPtn, this);
        try
        {
            menuPtn.loadData(new java.io.File(userMdl.getDataDir(), "maoc.xml"));
            menuPtn.getPopMenu("maoc", pm_AocHelp);
            menuPtn.getStrokes("maoc", rootPane);
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
        }

        tf_ExpText.requestFocus();

        this.pack();
        Bean.centerForm(this, null);
    }

    public void showData()
    {
    }

    @Override
    public MenuPtn getMenuPtn()
    {
        return null;
    }

    @Override
    public boolean endSave()
    {
        return true;
    }

    @Override
    public void requestFocus()
    {
    }

    private void bt_ExpTextActionPerformed(java.awt.event.ActionEvent e)
    {
        String math = tf_ExpText.getText().trim();
        if (!Char.isValidate(math))
        {
            return;
        }

        try
        {
            System.out.println(symbols.eval(math));
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
            Lang.showMesg(this, null, exp.getLocalizedMessage());
        }
    }

    private void bt_AocHelpActionPerformed(java.awt.event.ActionEvent e)
    {
        pm_AocHelp.show(bt_AocHelp, 0, bt_AocHelp.getHeight());
    }

    /**
     * @return the precision
     */
    public int getPrecision()
    {
        return precision;
    }

    /**
     * @param precision the precision to set
     */
    public void setPrecision(int precision)
    {
        this.precision = precision;
    }

    public void setExpression(String expression)
    {
        tf_ExpText.setText(expression);
    }

    public String getExpression()
    {
        return tf_ExpText.getText();
    }

    public void appendExpression(String expression)
    {
        tf_ExpText.setText(tf_ExpText.getText() + expression);
    }

    public void replaceExpression(String expression)
    {
        tf_ExpText.replaceSelection(expression);
    }

    public void setCaretPosition(int position)
    {
        tf_ExpText.setCaretPosition(position);
    }

    public void moveCaretPosition(int position)
    {
        tf_ExpText.setCaretPosition(tf_ExpText.getCaretPosition() + position);
    }
    private BtnLabel bt_AocHelp;
    private BtnLabel bt_ExpText;
    private javax.swing.JPanel sp_ArgBean;
    private javax.swing.JPanel sp_ExpBean;
    private javax.swing.JScrollPane sp_NumList;
    private javax.swing.JScrollPane sp_FunList;
    private javax.swing.JList ls_FunList;
    private javax.swing.JList ls_NumList;
    private javax.swing.JLabel lb_ExpText;
    private javax.swing.JTable tb_ExpList;
    private javax.swing.JTextField tf_ExpText;
    private javax.swing.JPopupMenu pm_AocHelp;
}

/*
 *  Copyright (C) 2011 Aven
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
package com.magicpwd.x.mgtd.schedule;

import com.magicpwd.__i.mgtd.IMgtdBean;
import com.magicpwd._comn.mpwd.Mgtd;
import com.magicpwd._comp.BtnLabel;
import com.magicpwd.x.mgtd.MgtdDlg;

/**
 * Application: MagicPwd
 * Author     : Aven
 * Encoding   : UTF-8
 * Website    : http://magicpwd.com/
 * Project    : http://magicpwd.googlecode.com/
 * Contact    : Amon@magicpwd.com
 * CopyRight  : Winshine.biz
 * Description:
 */
public class Cycle extends javax.swing.JPanel implements IMgtdBean
{

    private MgtdDlg mgtdDlg;

    public Cycle(MgtdDlg mgtdDlg)
    {
        this.mgtdDlg = mgtdDlg;
    }

    @Override
    public void initView()
    {
        btFtime = new BtnLabel();
        spFtime = new javax.swing.JSpinner();
        spFtime.setModel(new javax.swing.SpinnerDateModel());
        lbFtime = new javax.swing.JLabel();
        lbFtime.setLabelFor(spFtime);

        btTtime = new BtnLabel();
        spTtime = new javax.swing.JSpinner();
        spTtime.setModel(new javax.swing.SpinnerDateModel());
        lbTtime = new javax.swing.JLabel();
        lbTtime.setLabelFor(spTtime);

        btStime = new BtnLabel();
        spStime = new javax.swing.JSpinner();
        spStime.setModel(new javax.swing.SpinnerDateModel());
        lbStime = new javax.swing.JLabel();
        lbStime.setLabelFor(spStime);

        cbIntval = new javax.swing.JComboBox();
        lbIntval = new javax.swing.JLabel();
        lbIntval.setLabelFor(cbIntval);

        lsEnum = new javax.swing.JList();
        lsEnum.setVisibleRowCount(5);
        javax.swing.JScrollPane spEnum = new javax.swing.JScrollPane(lsEnum);
        lbEnum = new javax.swing.JLabel();
        lbEnum.setLabelFor(lsEnum);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        javax.swing.GroupLayout.SequentialGroup hsg1 = layout.createSequentialGroup();
        hsg1.addComponent(spFtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        hsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg1.addComponent(btFtime, 21, 21, 21);
        javax.swing.GroupLayout.SequentialGroup hsg2 = layout.createSequentialGroup();
        hsg2.addComponent(spTtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        hsg2.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg2.addComponent(btTtime, 21, 21, 21);
        javax.swing.GroupLayout.SequentialGroup hsg3 = layout.createSequentialGroup();
        hsg3.addComponent(spStime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        hsg3.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg3.addComponent(btStime, 21, 21, 21);
        javax.swing.GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        hpg1.addComponent(lbEnum);
        hpg1.addComponent(lbFtime);
        hpg1.addComponent(lbTtime);
        hpg1.addComponent(lbStime);
        hpg1.addComponent(lbIntval);
        javax.swing.GroupLayout.ParallelGroup hpg2 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        hpg2.addGroup(hsg1);
        hpg2.addGroup(hsg2);
        hpg2.addGroup(hsg3);
        hpg2.addComponent(cbIntval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        hpg2.addComponent(spEnum, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE);
        javax.swing.GroupLayout.SequentialGroup hsg4 = layout.createSequentialGroup();
//        hsg4.addContainerGap();
        hsg4.addGroup(hpg1);
        hsg4.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg4.addGroup(hpg2);
//        hsg4.addContainerGap();
        layout.setHorizontalGroup(hsg4);

        javax.swing.GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg1.addComponent(lbFtime);
        vpg1.addComponent(spFtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        vpg1.addComponent(btFtime, 21, 21, 21);
        javax.swing.GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg2.addComponent(lbTtime);
        vpg2.addComponent(spTtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        vpg2.addComponent(btTtime, 21, 21, 21);
        javax.swing.GroupLayout.ParallelGroup vpg3 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg3.addComponent(lbStime);
        vpg3.addComponent(spStime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        vpg3.addComponent(btStime, 21, 21, 21);
        javax.swing.GroupLayout.ParallelGroup vpg4 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg4.addComponent(lbIntval);
        vpg4.addComponent(cbIntval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        javax.swing.GroupLayout.ParallelGroup vpg5 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        vpg5.addComponent(lbEnum);
        vpg5.addComponent(spEnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
//        vsg.addContainerGap();
        vsg.addGroup(vpg1);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg.addGroup(vpg2);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg.addGroup(vpg3);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg.addGroup(vpg4);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg.addGroup(vpg5);
//        vsg.addContainerGap();
        layout.setVerticalGroup(vsg);
    }

    @Override
    public void initLang()
    {
        lbFtime.setText("起始时间(T)");
        lbTtime.setText("结束时间(S)");
        lbStime.setText("执行时间(S)");
    }

    @Override
    public String getName()
    {
        return "cycle";
    }

    @Override
    public String getTitle()
    {
        return "周期提醒";
    }

    @Override
    public boolean showData(Mgtd mgtd)
    {
        return true;
    }

    @Override
    public boolean saveData(Mgtd mgtd)
    {
        return true;
    }
    private BtnLabel btFtime;
    private BtnLabel btStime;
    private BtnLabel btTtime;
    private javax.swing.JComboBox cbIntval;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEnum;
    private javax.swing.JLabel lbFtime;
    private javax.swing.JLabel lbIntval;
    private javax.swing.JLabel lbStime;
    private javax.swing.JLabel lbTtime;
    private javax.swing.JList lsEnum;
    private javax.swing.JSpinner spFtime;
    private javax.swing.JSpinner spStime;
    private javax.swing.JSpinner spTtime;
}
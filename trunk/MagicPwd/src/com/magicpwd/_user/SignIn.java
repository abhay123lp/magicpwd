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
package com.magicpwd._user;

import com.magicpwd.__i.IUserView;
import com.magicpwd._comn.S1S1;
import com.magicpwd._cons.ConsCfg;
import com.magicpwd._cons.LangRes;
import com.magicpwd._enum.AppView;
import com.magicpwd._enum.AuthLog;
import com.magicpwd._util.Lang;
import com.magicpwd._util.Logs;
import com.magicpwd.m.MpwdMdl;
import com.magicpwd.m.UserMdl;

/**
 *
 * @author Aven
 */
public class SignIn extends javax.swing.JPanel implements IUserView
{

    private UserPtn userPtn;
    /**
     * 登录错误次数
     */
    private int errCount;

    SignIn(UserPtn userPtn)
    {
        this.userPtn = userPtn;
    }

    @Override
    public void initView()
    {
        lbUserView = new javax.swing.JLabel();
        cbUserView = new javax.swing.JComboBox();
        lbUserName = new javax.swing.JLabel();
        tfUserName = new javax.swing.JTextField();
        lbUserPwds = new javax.swing.JLabel();
        pfUserPwds = new javax.swing.JPasswordField();
        plUserOpts = new javax.swing.JPanel();

        plUserOpts.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        plUserOpts.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        javax.swing.GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        hpg1.addComponent(lbUserView, javax.swing.GroupLayout.Alignment.TRAILING);
        hpg1.addComponent(lbUserName, javax.swing.GroupLayout.Alignment.TRAILING);
        hpg1.addComponent(lbUserPwds, javax.swing.GroupLayout.Alignment.TRAILING);
        javax.swing.GroupLayout.ParallelGroup hpg2 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        hpg2.addComponent(cbUserView, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE);
        hpg2.addComponent(tfUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE);
        hpg2.addComponent(pfUserPwds, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE);
        javax.swing.GroupLayout.SequentialGroup hsg1 = layout.createSequentialGroup();
        hsg1.addGroup(hpg1);
        hsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg1.addGroup(hpg2);
        javax.swing.GroupLayout.ParallelGroup hpg3 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        hpg3.addGroup(hsg1);
        hpg3.addComponent(plUserOpts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        javax.swing.GroupLayout.SequentialGroup hsg2 = layout.createSequentialGroup();
        hsg2.addContainerGap();
        hsg2.addGroup(hpg3);
        hsg2.addContainerGap();
        layout.setHorizontalGroup(hsg2);
        javax.swing.GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg1.addComponent(lbUserView);
        vpg1.addComponent(cbUserView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        javax.swing.GroupLayout.ParallelGroup vpg2 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg2.addComponent(lbUserName);
        vpg2.addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        javax.swing.GroupLayout.ParallelGroup vpg3 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg3.addComponent(lbUserPwds);
        vpg3.addComponent(pfUserPwds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        javax.swing.GroupLayout.SequentialGroup vsg1 = layout.createSequentialGroup();
//        vsg1.addContainerGap();
        vsg1.addGroup(vpg1);
        vsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg1.addGroup(vpg2);
        vsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg1.addGroup(vpg3);
        vsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg1.addComponent(plUserOpts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        vsg1.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        layout.setVerticalGroup(vsg1);
    }

    @Override
    public void initMenu(javax.swing.JPopupMenu menu)
    {
        miFindPwds = new javax.swing.JMenuItem();
        miFindPwds.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                miFindPwdsMouseReleased(e);
            }
        });
        menu.add(miFindPwds);
    }

    @Override
    public void initLang()
    {
        Lang.setWText(lbUserView, LangRes.P30FA312, "模式(@M)");

        Lang.setWText(lbUserName, LangRes.P30FA301, "用户(@U)");
        Lang.setWText(lbUserPwds, LangRes.P30FA302, "口令(@P)");

        Lang.setWText(miFindPwds, LangRes.P30FA30E, "口令找回");
        Lang.setWTips(miFindPwds, LangRes.P30FA30F, "找回您的登录口令");

        Lang.setWText(userPtn.getApplyButton(), LangRes.P30FA501, "登录(@S)");

        Lang.setWText(userPtn.getAbortButton(), LangRes.P30FA504, "取消(@C)");

        userPtn.setTitle(Lang.getLang(LangRes.P30FA201, "用户登录"));
    }

    @Override
    public void initData()
    {
        UserMdl userMdl = userPtn.getUserMdl();

        // 显示上次登录用户
        String[] arr = userMdl.getMpwdMdl().getViewList().split(",");
        String tmp;
        for (int i = 0, j = arr.length; i < j; i += 1)
        {
            tmp = arr[i].toLowerCase();
            if (AppView.mexp.name().equals(tmp))
            {
                cbUserView.addItem(new S1S1(tmp, Lang.getLang(LangRes.P30FA107, "专业模式")));
                continue;
            }
            if (AppView.mwiz.name().equals(tmp))
            {
                cbUserView.addItem(new S1S1(tmp, Lang.getLang(LangRes.P30FA108, "向导模式")));
                continue;
            }
            if (AppView.mpad.name().equals(tmp))
            {
                cbUserView.addItem(new S1S1(tmp, Lang.getLang(LangRes.P30FA109, "记事模式")));
                continue;
            }
            if (AppView.maoc.name().equals(tmp))
            {
                cbUserView.addItem(new S1S1(tmp, Lang.getLang(LangRes.P30FA10A, "数值运算")));
                continue;
            }
            if (AppView.mruc.name().equals(tmp))
            {
                cbUserView.addItem(new S1S1(tmp, Lang.getLang(LangRes.P30FA10B, "单位换算")));
                continue;
            }
            if (AppView.mgtd.name().equals(tmp))
            {
                cbUserView.addItem(new S1S1(tmp, Lang.getLang(LangRes.P30FA10C, "任务管理")));
                continue;
            }
        }
        cbUserView.setSelectedItem(new S1S1(userMdl.getMpwdMdl().getViewLast(), ""));
        String name = userMdl.getCfg(ConsCfg.CFG_USER_LAST, "");
        if (com.magicpwd._util.Char.isValidate(name))
        {
            tfUserName.setText(name);
            pfUserPwds.requestFocus();
        }
        else
        {
            tfUserName.requestFocus();
        }
    }

    @Override
    public javax.swing.JPanel getPanel()
    {
        return this;
    }

    @Override
    public void btApplyActionPerformed(java.awt.event.ActionEvent e)
    {
        String name = tfUserName.getText();
        if (!com.magicpwd._util.Char.isValidate(name))
        {
            Lang.showMesg(this, LangRes.P30FAA01, "请输入用户名称！");
            tfUserName.requestFocus();
            return;
        }
        String pwds = new String(pfUserPwds.getPassword());
        if (!com.magicpwd._util.Char.isValidate(pwds))
        {
            Lang.showMesg(this, LangRes.P30FAA02, "请输入登录口令！");
            pfUserPwds.requestFocus();
            return;
        }

        try
        {
            boolean b = userPtn.getUserMdl().signIn(name, pwds);
            if (b)
            {
//                if (!ConsDat.VERSIONS.equals(DBA4000.readConfig("")))
//                {
//                    return;
//                }
                userPtn.getUserMdl().setCfg(ConsCfg.CFG_USER_LAST, name);
            }
            else
            {
                errCount += 1;
                if (errCount > 2)
                {
                    Lang.showMesg(this, LangRes.P30FAA1C, "您操作的错误次太多，请确认您是否为合法用户！\n为了保障用户数据安全，软件将自动关闭。");
                    System.exit(0);
                }
                else
                {
                    Lang.showMesg(this, LangRes.P30FAA03, "身份验证错误，请确认您的用户名及口令是否正确！");
                    pfUserPwds.setText("");
                    pfUserPwds.requestFocus();
                }
                return;
            }
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
            Lang.showMesg(this, LangRes.P30FAA03, "身份验证错误，请确认您的用户名及口令是否正确！");
            System.exit(0);
            return;
        }

        Object object = cbUserView.getSelectedItem();
        if (object instanceof S1S1)
        {
            MpwdMdl.setAppView(((S1S1) object).getK());
        }

        if (userPtn.callBack(AuthLog.signIn, null))
        {
            userPtn.hideWindow();
        }
    }

    @Override
    public void btAbortActionPerformed(java.awt.event.ActionEvent e)
    {
        userPtn.exitSystem();
    }

    private void miFindPwdsMouseReleased(java.awt.event.ActionEvent evt)
    {
        userPtn.initView(AuthLog.signFp);
        userPtn.initLang();
        userPtn.initData();
    }
    private javax.swing.JLabel lbUserView;
    private javax.swing.JComboBox cbUserView;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JTextField tfUserName;
    private javax.swing.JLabel lbUserPwds;
    private javax.swing.JPasswordField pfUserPwds;
    private javax.swing.JPanel plUserOpts;
    private javax.swing.JMenuItem miFindPwds;
}

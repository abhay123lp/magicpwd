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

/**
 *
 * @author Aven
 */
public class SignRs extends javax.swing.JPanel implements IUserView
{

    @Override
    public void initView()
    {
    }

    @Override
    public void initLang()
    {
    }

    @Override
    public void initData()
    {
    }

    @Override
    public javax.swing.JPanel getPanel()
    {
        return this;
    }

    @Override
    public void btApplyActionPerformed(java.awt.event.ActionEvent e)
    {
    }

    @Override
    public void btAbortActionPerformed(java.awt.event.ActionEvent e)
    {
    }
//    private void signRs()
//    {
//        String name = tf_UserName.getText();
//        if (!com.magicpwd._util.Char.isValidate(name))
//        {
//            Lang.showMesg(this, LangRes.P30FAA01, "请输入用户名称！");
//            tf_UserName.requestFocus();
//            return;
//        }
//        String pwds = new String(pf_UserKey0.getPassword());
//        if (!com.magicpwd._util.Char.isValidate(pwds))
//        {
//            Lang.showMesg(this, LangRes.P30FAA02, "请输入登录口令！");
//            pf_UserKey0.requestFocus();
//            return;
//        }
//
//        try
//        {
//            boolean b = userMdl.signIn(name, pwds);
//            if (b)
//            {
//                tf_UserName.setText("");
//                pf_UserKey0.setText("");
//            }
//            else
//            {
//                errCount += 1;
//                if (errCount > 2)
//                {
//                    Lang.showMesg(this, LangRes.P30FAA1C, "您操作的错误次太多，请确认您是否为合法用户！\n为了保障用户数据安全，软件将自动关闭。");
//                    System.exit(0);
//                }
//                else
//                {
//                    Lang.showMesg(this, LangRes.P30FAA03, "身份验证错误，请确认您的用户名及口令是否正确！");
//                    pf_UserKey0.setText("");
//                    pf_UserKey0.requestFocus();
//                }
//                return;
//            }
//        }
//        catch (Exception exp)
//        {
//            Logs.exception(exp);
//            Lang.showMesg(this, LangRes.P30FAA03, "身份验证错误，请确认您的用户名及口令是否正确！");
//            System.exit(0);
//            return;
//        }
//
//        dispoze();
//        if (backCall != null)
//        {
//            backCall.callBack(AuthLog.signRs.name(), null);
//        }
//    }
}
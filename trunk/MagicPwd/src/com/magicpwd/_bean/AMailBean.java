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
package com.magicpwd._bean;

import com.magicpwd.__a.AEditBean;
import com.magicpwd.__a.AFrame;
import com.magicpwd.__i.IEditItem;
import com.magicpwd._comp.BtnLabel;
import com.magicpwd._comp.WTextBox;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Desk;
import com.magicpwd._util.Lang;

/**
 * Application: MagicPwd
 * Author     : Amon
 * Encoding   : UTF-8
 * Created    : 2010-10-27 20:23:44
 * Website    : http://magicpwd.com/
 * Project    : http://magicpwd.googlecode.com/
 * Contact    : Amon@magicpwd.com
 * CopyRight  : Winshine.biz
 * Description:
 */
public abstract class AMailBean extends AEditBean
{

    protected AFrame formPtn;
    protected IEditItem itemData;
    private WTextBox dataBox;

    public AMailBean(AFrame formPtn)
    {
        this.formPtn = formPtn;
    }

    protected void initConfView()
    {
        tf_PropData = new javax.swing.JTextField();
        dataBox = new WTextBox(tf_PropData, true);
        dataBox.initView();

        pl_PropConf = new javax.swing.JPanel();
        pl_PropConf.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));

        bt_MailView = new BtnLabel();
        bt_MailView.setIcon(formPtn.getUserMdl().readIcon(ConsEnv.FEEL_PATH + "mail-send.png"));
        bt_MailView.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bt_MailViewActionPerformed(evt);
            }
        });
        pl_PropConf.add(bt_MailView);
    }

    protected void initConfLang()
    {
        Lang.setWText(bt_MailView, LangRes.P30F1511, "&O");
        Lang.setWTips(bt_MailView, LangRes.P30F1512, "发送邮件(Alt + O)");

        dataBox.initLang();
    }

    protected void initConfData()
    {
        dataBox.initData();
    }

    private void bt_MailViewActionPerformed(java.awt.event.ActionEvent evt)
    {
        String url = tf_PropData.getText();
        if (!com.magicpwd._util.Char.isValidateEmail(url))
        {
            Lang.showMesg(formPtn, LangRes.P30F7A32, "您输入的不是一个合适的邮件地址！");
            return;
        }

        if (!url.toLowerCase().startsWith("mailto:"))
        {
            url = "mailto:" + url;
        }
        Desk.mail(url);
    }
    protected javax.swing.JTextField tf_PropData;
    // 配置信息
    protected javax.swing.JPanel pl_PropConf;
    private BtnLabel bt_MailView;
}
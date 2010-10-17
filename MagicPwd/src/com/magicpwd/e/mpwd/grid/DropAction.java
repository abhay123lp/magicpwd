/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd.e.mpwd.grid;

import com.magicpwd.__a.mpwd.AMpwdAction;
import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Lang;
import com.magicpwd.v.TrayPtn;

/**
 *
 * @author aven
 */
public class DropAction extends AMpwdAction
{

    public DropAction()
    {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        if (Lang.showFirm(TrayPtn.getCurrForm(), LangRes.P30F1A01, "确认要删除此属性数据么？") == javax.swing.JOptionPane.YES_OPTION)
        {
            mainPtn.removeSelected();
        }
    }

    @Override
    public void doInit(Object object)
    {
    }

    @Override
    public void reInit(javax.swing.AbstractButton button)
    {
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd.e.pwd.file;

import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Lang;
import com.magicpwd.m.CoreMdl;
import com.magicpwd.v.pwd.MainPtn;

/**
 *
 * @author Amon
 */
public class DropAction extends javax.swing.AbstractAction
{

    private MainPtn mainPtn;
    private CoreMdl coreMdl;

    public DropAction()
    {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        Object object = getMainPtn().getSelectedItem();
        if (object == null)
        {
            return;
        }

        if (Lang.showFirm(getMainPtn(), LangRes.P30F7A0A, "您正在进行的操作是删除记录数据及其所有历史信息，确认继续么？") != javax.swing.JOptionPane.YES_OPTION)
        {
            return;
        }
        if (Lang.showFirm(getMainPtn(), LangRes.P30F7A0B, "确认一下您操作的正确性，要返回么？") != javax.swing.JOptionPane.NO_OPTION)
        {
            return;
        }
//        coreMdl.getListMdl().wDelete(index);
        getCoreMdl().getGridMdl().clear();
        getMainPtn().showPropEdit();
    }

    /**
     * @return the mainPtn
     */
    public MainPtn getMainPtn()
    {
        return mainPtn;
    }

    /**
     * @param mainPtn the mainPtn to set
     */
    public void setMainPtn(MainPtn mainPtn)
    {
        this.mainPtn = mainPtn;
    }

    /**
     * @return the coreMdl
     */
    public CoreMdl getCoreMdl()
    {
        return coreMdl;
    }

    /**
     * @param coreMdl the coreMdl to set
     */
    public void setCoreMdl(CoreMdl coreMdl)
    {
        this.coreMdl = coreMdl;
    }
}

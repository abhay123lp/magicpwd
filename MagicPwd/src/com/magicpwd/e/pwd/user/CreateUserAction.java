/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd.e.pwd.user;

import com.magicpwd.m.CoreMdl;
import com.magicpwd.v.MainPtn;

/**
 *
 * @author Amon
 */
public class CreateUserAction extends javax.swing.AbstractAction
{

    private MainPtn mainPtn;
    private CoreMdl coreMdl;

    public CreateUserAction(MainPtn mainPtn, CoreMdl coreMdl)
    {
        this.mainPtn = mainPtn;
        this.coreMdl = coreMdl;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd.e.mpwd.list;

import com.magicpwd.__a.mpwd.AMpwdAction;
import com.magicpwd._cons.ConsCfg;

/**
 *
 * @author Amon
 */
public class SortDirAction extends AMpwdAction
{

    public SortDirAction()
    {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        mainPtn.getUserMdl().setCfg(ConsCfg.CFG_VIEW_LIST_ASC, e.getActionCommand());
        mainPtn.showList();
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
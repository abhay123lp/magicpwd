/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd.e.mpwd.skin;

import com.magicpwd.__a.mpwd.AMpwdAction;
import com.magicpwd._util.Desk;

/**
 *
 * @author Administrator
 */
public class MoreAction extends AMpwdAction
{

    public MoreAction()
    {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        Desk.browse(e.getActionCommand());
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

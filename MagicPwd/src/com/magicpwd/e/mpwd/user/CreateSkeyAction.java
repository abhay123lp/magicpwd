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
package com.magicpwd.e.mpwd.user;

import com.magicpwd.__a.mpwd.AMpwdAction;
import com.magicpwd.__i.IBackCall;
import com.magicpwd._cons.ConsCfg;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Char;
import com.magicpwd._util.Lang;

/**
 *
 * @author Amon
 */
public class CreateSkeyAction extends AMpwdAction
{

    public CreateSkeyAction()
    {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        if (Char.isValidate(mainPtn.getUserMdl().getCfg(ConsCfg.CFG_USER_SKEY), 224))
        {
            Lang.showMesg(mainPtn, LangRes.P30F7A28, "您已经设置过安全口令！");
            return;
        }

        trayPtn.getUserPtn(ConsEnv.INT_SIGN_SK, new IBackCall()
        {

            @Override
            public boolean callBack(Object sender, java.util.EventListener event, String... params)
            {
                if (params == null || params.length < 1)
                {
                    return false;
                }

                if (ConsEnv.STR_SIGN_SK.equals(params[0]))
                {
                    javax.swing.AbstractButton button = mainPtn.getMenuPtn().getButton("mpwd-skey");
                    if (button != null)
                    {
                        button.setEnabled(false);
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void doInit(Object object)
    {
        setEnabled(!Char.isValidate(mainPtn.getUserMdl().getCfg(ConsCfg.CFG_USER_SKEY), 224));
    }

    @Override
    public void reInit(javax.swing.AbstractButton button)
    {
        button.setEnabled(isEnabled());
    }
}

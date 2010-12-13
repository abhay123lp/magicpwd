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
package com.magicpwd.v.mruc;

import com.magicpwd.__a.AFrame;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd.m.UserMdl;
import com.magicpwd.m.mruc.MrucMdl;
import com.magicpwd.v.MenuPtn;
import com.magicpwd.v.TrayPtn;

/**
 * 单位换算
 * 
 * @author Amon
 */
public class MrucPtn extends AFrame
{

    private MrucMdl mrucMdl;
    private java.util.ArrayList<BodyPtn> bodyList;

    public MrucPtn(TrayPtn trayPtn, UserMdl userMdl)
    {
        super(trayPtn, userMdl);
    }

    public void initView()
    {
        bodyList = new java.util.ArrayList<BodyPtn>();
        Integer step = ConsEnv.PWDS_HEAD_SIZE;
        BodyPtn bodyPtn;
        while (step < 10)
        {
            bodyPtn = new BodyPtn(null);
            bodyPtn.initView(step);
            bodyList.add(bodyPtn);
        }
    }

    public void initLang()
    {
    }

    public void initData()
    {
        mrucMdl = new MrucMdl(userMdl);
        mrucMdl.init();
    }

    @Override
    public MenuPtn getMenuPtn()
    {
        return null;
    }

    @Override
    public boolean endSave()
    {
        return true;
    }

    @Override
    public void requestFocus()
    {
    }
}

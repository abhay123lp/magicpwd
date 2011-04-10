/*
 *  Copyright (C) 2010 Administrator
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
package com.magicpwd.m.mwiz;

import com.magicpwd.__i.IEditItem;
import com.magicpwd._comn.I1S2;
import com.magicpwd._comn.mpwd.Keys;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._util.Char;
import com.magicpwd.d.db.DBA3000;
import com.magicpwd.m.SafeMdl;
import com.magicpwd.m.UserMdl;

/**
 * Application: MagicPwd
 * Author     : Administrator
 * Encoding   : UTF-8
 * Created    : 2010-10-24 22:09:08
 * Website    : http://magicpwd.com/
 * Project    : http://magicpwd.googlecode.com/
 * Contact    : Amon@magicpwd.com
 * CopyRight  : Winshine.biz
 * Description:
 */
public class KeysMdl extends SafeMdl
{

    KeysMdl(UserMdl userMdl)
    {
        super(userMdl);
    }

    void init()
    {
    }

    @Override
    public void initHead()
    {
        initMeta();
        initLogo();
        initHint();
    }

    @Override
    public void initBody()
    {
        DBA3000.selectTpltData(userMdl, ls_ItemList.get(ConsEnv.PWDS_HEAD_GUID).getSpec(IEditItem.SPEC_GUID_TPLT), ls_ItemList);
    }

    @Override
    public void clear()
    {
        ls_ItemList.clear();
        keys.setDefault();
    }

    public void clear(int sIndex)
    {
        clear(sIndex, ls_ItemList.size() - 1);
    }

    public void clear(int sIndex, int eIndex)
    {
        if (sIndex >= 0 && eIndex >= sIndex)
        {
            while (eIndex >= sIndex)
            {
                ls_ItemList.remove(eIndex--);
            }
        }
    }

    public boolean isUpdate()
    {
        return Char.isValidateHash(keys.getP30F0104());
    }

    public void loadData(Keys keys) throws Exception
    {
        loadData(keys.getP30F0104());
    }

    /**
     *
     * @param type
     * @return
     */
    public java.util.List<I1S2> wSelect(int type)
    {
        java.util.ArrayList<I1S2> list = new java.util.ArrayList<I1S2>();
        int i = 0;
        for (IEditItem item : ls_ItemList)
        {
            if (item.getType() == type)
            {
                list.add(new I1S2(i, item.getData(), item.getName()));
            }
            i += 1;
        }
        return list;
    }
}

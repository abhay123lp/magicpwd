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
package com.magicpwd.m.mpro;

import com.magicpwd._comn.prop.Kind;
import com.magicpwd._cons.ConsDat;
import com.magicpwd.m.UserMdl;
import com.magicpwd.r.KindTN;

/**
 *
 * @author Amon
 */
public final class MproMdl
{

    private KindMdl kindMdl;
    private ListMdl listMdl;
    private GridMdl gridMdl;
    private UserMdl userMdl;

    public MproMdl(UserMdl userMdl)
    {
        this.userMdl = userMdl;
    }

    public void init()
    {
        listMdl = new ListMdl(userMdl);
        listMdl.init();

        Kind kind = new Kind();
        kind.setC2010203(ConsDat.HASH_ROOT);
        kind.setC2010106("魔方密码");
        kind.setC2010207("魔方密码");
        kindMdl = new KindMdl(userMdl, new KindTN(userMdl, kind));
        kindMdl.init();

        gridMdl = new GridMdl(userMdl);
        gridMdl.init();
    }

    /**
     * @return the listMdl
     */
    public ListMdl getListMdl()
    {
        return listMdl;
    }

    /**
     * @return the treeMdl
     */
    public KindMdl getKindMdl()
    {
        return kindMdl;
    }

    /**
     * @return the gridMdl
     */
    public GridMdl getGridMdl()
    {
        return gridMdl;
    }
}

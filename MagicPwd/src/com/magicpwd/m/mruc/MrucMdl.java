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
package com.magicpwd.m.mruc;

import com.magicpwd._comn.S1S2;
import com.magicpwd.m.UserMdl;

/**
 * Application: MagicPwd
 * Author     : Amon
 * Encoding   : UTF-8
 * Created    : 2010-12-12 17:33:27
 * Website    : http://magicpwd.com/
 * Project    : http://magicpwd.googlecode.com/
 * Contact    : Amon@magicpwd.com
 * CopyRight  : Winshine.biz
 * Description:
 */
public final class MrucMdl
{

    private UserMdl userMdl;
    private UnitMdl unitMdl;
    private java.util.ArrayList<S1S2> unitList;

    public MrucMdl(UserMdl userMdl)
    {
        this.userMdl = userMdl;
    }

    public void init()
    {
        setUnitMdl(new UnitMdl(userMdl));
        getUnitMdl().init();
    }

    /**
     * @return the unitMdl
     */
    public UnitMdl getUnitMdl()
    {
        return unitMdl;
    }

    /**
     * @param unitMdl the unitMdl to set
     */
    public void setUnitMdl(UnitMdl unitMdl)
    {
        this.unitMdl = unitMdl;
    }
}

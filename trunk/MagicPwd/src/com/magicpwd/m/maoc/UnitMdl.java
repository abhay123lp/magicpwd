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
package com.magicpwd.m.maoc;

import com.magicpwd.m.SafeMdl;
import com.magicpwd.m.UserMdl;

/**
 *
 * @author Amon
 */
public class UnitMdl extends SafeMdl
{

    public UnitMdl(UserMdl userMdl)
    {
        super(userMdl);
    }

    public void init()
    {
    }

    @Override
    public void initHead()
    {
    }

    @Override
    public void initBody()
    {
    }

    @Override
    public void clear()
    {
        ls_ItemList.clear();
        keys.setDefault();
    }

    public int getSize()
    {
        return ls_ItemList.size();
    }
}

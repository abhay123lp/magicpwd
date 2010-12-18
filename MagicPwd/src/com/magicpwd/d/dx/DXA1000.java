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
package com.magicpwd.d.dx;

import com.magicpwd.__i.IEditItem;
import com.magicpwd._comn.Keys;
import com.magicpwd._comn.item.EditItem;
import com.magicpwd._comn.item.GuidItem;
import com.magicpwd._comn.item.HintItem;
import com.magicpwd._comn.item.LogoItem;
import com.magicpwd._comn.item.MetaItem;
import com.magicpwd._util.Logs;
import com.magicpwd.d.db.DBA3000;
import com.magicpwd.m.SafeMdl;
import com.magicpwd.m.UserMdl;
import java.util.ArrayList;

/**
 *
 * @author Amon
 */
public class DXA1000 implements DXA
{

    public DXA1000()
    {
    }

    @Override
    public int importByKind(UserMdl userMdl, SafeMdl safeMdl, java.util.ArrayList<java.util.ArrayList<String>> data, String kindHash) throws Exception
    {
        int size = 0;
        int indx = 0;
        EditItem item;
        Keys tempKeys = new Keys();
        java.util.ArrayList<IEditItem> tempList = new java.util.ArrayList<IEditItem>();
        for (java.util.ArrayList<String> temp : data)
        {
            switch ((temp.size() - 8) % 3)
            {
                case 2:
                    if (com.magicpwd._util.Char.isValidate(temp.get(temp.size() - 1)))
                    {
                        temp.add("");
                        break;
                    }
                    temp.remove(temp.size() - 1);
                case 1:
                    temp.remove(temp.size() - 1);
                    break;
            }

            indx = 0;
            tempKeys.setDefault();
            tempList.clear();
            tempKeys.setP30F0105(userMdl.getCode());

            // Guid
            GuidItem guid = new GuidItem(userMdl);
            guid.setTime(new java.sql.Timestamp(com.magicpwd._util.Date.toDate(temp.get(indx++), '-', ':', ' ').getTimeInMillis()));
            guid.setData(kindHash);
            tempList.add(guid);

            // Meta
            MetaItem meta = new MetaItem(userMdl);
            meta.setName(temp.get(indx++));
            meta.setData(temp.get(indx++));
            tempList.add(meta);

            // Logo
            tempList.add(new LogoItem(userMdl));

            // Hint
            HintItem hint = new HintItem(userMdl);
            String text = temp.get(indx++);
            if (com.magicpwd._util.Char.isValidate(text))
            {
                hint.setTime(new java.sql.Timestamp(com.magicpwd._util.Date.toDate(text, '-', ':', ' ').getTimeInMillis()));
            }
            hint.setName(temp.get(indx++));
            tempList.add(hint);

            while (indx < temp.size())
            {
                item = new EditItem(userMdl);
                item.setType(Integer.parseInt(temp.get(indx++)));
                item.setName(temp.get(indx++));
                item.setData(temp.get(indx++));
                tempList.add(item);
            }

            safeMdl.enCrypt(tempKeys, tempList);
            DBA3000.savePwdsData(tempKeys);
            size += 1;
            Thread.sleep(200);
        }
        return size;
    }

    @Override
    public int importByKeys(java.util.ArrayList<java.util.ArrayList<String>> data, String kindHash) throws Exception
    {
        return 0;
    }

    @Override
    public int exportByKind(UserMdl userMdl, SafeMdl safeMdl, java.util.ArrayList<java.util.ArrayList<String>> data, String kindHash) throws Exception
    {
        java.util.ArrayList<Keys> dataList = new java.util.ArrayList<Keys>();
        DBA3000.readKeysList(userMdl, kindHash, dataList);
        if (dataList == null || dataList.size() < 1)
        {
            return 0;
        }

        int size = 0;
        java.util.ArrayList<String> temp;
        int indx;
        IEditItem item;

        java.util.ArrayList<IEditItem> tempList = new java.util.ArrayList<IEditItem>();
        for (Keys keys : dataList)
        {
            indx = 0;
            temp = new java.util.ArrayList<String>();
            try
            {
                tempList.clear();
                keys.setP30F0105(userMdl.getCode());
                if (DBA3000.readPwdsData(keys))
                {
                    safeMdl.deCrypt(keys, tempList);
                }
            }
            catch (Exception exp)
            {
                Logs.exception(exp);
                continue;
            }

            // Guid
            item = tempList.get(indx++);
            temp.add(item.getName());

            // Meta
            item = tempList.get(indx++);
            temp.add(item.getName());
            temp.add(item.getData());

            // Logo
            item = tempList.get(indx++);

            // Hint
            item = tempList.get(indx++);
            temp.add(item.getData());
            temp.add(item.getName());

            while (indx < tempList.size())
            {
                item = tempList.get(indx++);
                temp.add("" + item.getType());
                temp.add(item.getName());
                temp.add(item.getData());
            }

            size += 1;
            data.add(temp);
        }
        return size;
    }

    @Override
    public int exportByKeys(java.util.ArrayList<java.util.ArrayList<String>> data, String kindHash) throws Exception
    {
        return 0;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd._comn;

import com.magicpwd._cons.ConsDat;
import com.magicpwd._util.Logs;
import com.magicpwd._util.Util;
import java.sql.Timestamp;

/**
 *
 * @author Amonsoft
 */
public class Hint extends EditItem
{

    private Timestamp time;

    public Hint()
    {
        super(ConsDat.INDX_HINT);
    }

    @Override
    public String getData()
    {
        if (time == null)
        {
            return "";
        }
        String name = time.toString();
        int dot = name.indexOf('.');
        return dot > 0 ? name.substring(0, dot) : name;
    }

    @Override
    public boolean setData(String data)
    {
        if (!Util.isValidate(data))
        {
            return false;
        }
        try
        {
            time = new java.sql.Timestamp(Util.stringToDate(data, '-', ':', ' ').getTimeInMillis());
            return true;
        }
        catch (Exception ex)
        {
            Logs.exception(ex);
            return false;
        }
    }

    public Timestamp getTime()
    {
        return time;
    }

    public void setTime(Timestamp time)
    {
        this.time = time;
    }
}

/**
 * 
 */
package com.magicpwd.m.mpad;

import com.magicpwd._comn.item.EditItem;

import com.magicpwd.__i.IEditItem;
import com.magicpwd._cons.ConsDat;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd.m.SafeMdl;
import com.magicpwd.m.UserMdl;

/**
 * 记事便签数据模型
 * @author Amon
 */
public class NoteMdl extends SafeMdl
{

    NoteMdl(UserMdl userMdl)
    {
        super(userMdl);
    }

    void init()
    {
    }

    @Override
    public void initHead()
    {
        // Guid
        initGuid().setData(ConsDat.HASH_NOTE);

        // Meta
        initMeta();
        // Logo
        initLogo();
        // Hint
        initHint();
    }

    @Override
    public void initBody()
    {
        EditItem note = new EditItem(userMdl);
        note.setType(ConsDat.INDX_AREA);
        ls_ItemList.add(note);
    }

    @Override
    public void clear()
    {
        ls_ItemList.clear();
        keys.setDefault();
        setModified(false);
    }

    public void setNote(String name, String note)
    {
        ls_ItemList.get(ConsEnv.PWDS_HEAD_META).setName(name);
        ls_ItemList.get(ConsEnv.PWDS_HEAD_SIZE).setName(name);
        ls_ItemList.get(ConsEnv.PWDS_HEAD_SIZE).setData(note);
    }

    public IEditItem getNote()
    {
        return ls_ItemList.get(ConsEnv.PWDS_HEAD_SIZE);
    }

    public int getSize()
    {
        return ls_ItemList.size();
    }
}

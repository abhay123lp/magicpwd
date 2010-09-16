/**
 * 
 */
package com.magicpwd.m;

import com.magicpwd._comn.item.EditItem;
import com.magicpwd._comn.item.GuidItem;
import java.util.ArrayList;
import java.util.List;

import com.magicpwd._comn.Keys;
import com.magicpwd._comn.item.MetaItem;
import com.magicpwd._comn.item.HintItem;
import com.magicpwd._comn.item.LogoItem;
import com.magicpwd._cons.ConsDat;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._face.IEditItem;
import com.magicpwd.d.DBA3000;

/**
 * 记事便签数据模型
 * @author Amon
 */
public class NoteMdl
{

    private boolean modified;
    private List<IEditItem> ls_ItemList;
    private Keys keys;
    private CoreMdl coreMdl;

    NoteMdl(CoreMdl coreMdl)
    {
        this.coreMdl = coreMdl;
        ls_ItemList = new ArrayList<IEditItem>();
        keys = new Keys();
    }

    public IEditItem initGuid()
    {
        GuidItem guid = new GuidItem(coreMdl.getUserCfg());
        guid.setData(ConsDat.HASH_NOTE);
        guid.setTime(new java.sql.Timestamp(System.currentTimeMillis()));
        ls_ItemList.add(guid);
        return guid;
    }

    public IEditItem initMeta()
    {
        MetaItem meta = new MetaItem(coreMdl.getUserCfg());
        ls_ItemList.add(meta);
        return meta;
    }

    public IEditItem initLogo()
    {
        LogoItem logo = new LogoItem(coreMdl.getUserCfg());
        ls_ItemList.add(logo);
        return logo;
    }

    public IEditItem initHint()
    {
        HintItem hint = new HintItem(coreMdl.getUserCfg());
        ls_ItemList.add(hint);
        return hint;
    }

    public IEditItem initNote()
    {
        EditItem note = new EditItem(coreMdl.getUserCfg());
        note.setType(ConsDat.INDX_AREA);
        ls_ItemList.add(note);
        return note;
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

    public void loadData(String keysHash) throws Exception
    {
        clear();
        keys.setP30F0104(keysHash);
        keys.setP30F0105(coreMdl.getUserCfg().getUserCode());
        DBA3000.readPwdsData(keys);
        coreMdl.getGridMdl().deCrypt(keys, ls_ItemList);
    }

    public void saveData(boolean histBack) throws Exception
    {
        keys.setP30F0105(coreMdl.getUserCfg().getUserCode());
        keys.setP30F0106(ConsDat.HASH_NOTE);
        keys.setHistBack(histBack);
        coreMdl.getGridMdl().enCrypt(keys, ls_ItemList);
        DBA3000.savePwdsData(keys);
    }

    public void clear()
    {
        ls_ItemList.clear();
        keys.setDefault();
        modified = false;
    }

    public int getSize()
    {
        return ls_ItemList.size();
    }

    public IEditItem getItemAt(int index)
    {
        return ls_ItemList.get(index);
    }

    public void setStatus(int status)
    {
        keys.setP30F0102(status);
        modified = true;
    }

    /**
     * 数据是否被修改过
     * 
     * @return
     */
    public boolean isModified()
    {
        return modified;
    }

    /**
     * 
     * @return
     */
    public boolean isUpdate()
    {
        return com.magicpwd._util.Char.isValidateHash(keys.getP30F0104());
    }
}
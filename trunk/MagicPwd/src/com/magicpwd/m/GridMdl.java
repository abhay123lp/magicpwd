/**
 * 
 */
package com.magicpwd.m;

import com.magicpwd._comn.Guid;
import com.magicpwd._comn.I1S2;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.table.DefaultTableModel;

import com.magicpwd._comn.Keys;
import com.magicpwd._comn.Pwds;
import com.magicpwd._comn.Item;
import com.magicpwd._comn.Logo;
import com.magicpwd._comn.Meta;
import com.magicpwd._comn.Note;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._cons.ConsDat;
import com.magicpwd._cons.LangRes;
import com.magicpwd._face.IEditItem;
import com.magicpwd._util.Lang;
import com.magicpwd._util.Hash;
import com.magicpwd._util.Logs;
import com.magicpwd._util.Util;
import com.magicpwd.d.DBA3000;

/**
 * @author Amon
 * 
 */
public class GridMdl extends DefaultTableModel
{

    /**
     * 临时数据保存
     */
    private boolean interim;
    private boolean modified;
    private List<IEditItem> ls_ItemList;
    private Keys keys;

    GridMdl()
    {
        ls_ItemList = new ArrayList<IEditItem>();
        keys = new Keys();
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.table.DefaultTableModel#getColumnCount()
     */
    @Override
    public int getColumnCount()
    {
        return 2;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
     */
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnIndex == 0 ? Integer.class : String.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.table.DefaultTableModel#getColumnName(int)
     */
    @Override
    public String getColumnName(int columnIndex)
    {
        return columnIndex == 1 ? Lang.getLang(LangRes.P30F7304, "属性(T)") : Lang.getLang(LangRes.P30F7303, "");
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.DefaultTableModel#getRowCount()
     */
    @Override
    public int getRowCount()
    {
        return ls_ItemList != null ? ls_ItemList.size() : 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
     */
    @Override
    public Object getValueAt(int row, int column)
    {
        // 索引列
        if (column == 0)
        {
            switch (row)
            {
                case ConsDat.INDX_GUID - ConsDat.INDX_GUID:
                    return Lang.getLang(LangRes.P30F1106, "日期");
                case ConsDat.INDX_META - ConsDat.INDX_GUID:
                    return Lang.getLang(LangRes.P30F110A, "标题");
                case ConsDat.INDX_LOGO - ConsDat.INDX_GUID:
                    return Lang.getLang(LangRes.P30F1112, "徽标");
                case ConsDat.INDX_NOTE - ConsDat.INDX_GUID:
                    return Lang.getLang(LangRes.P30F110B, "提醒");
                default:
                    return row + 1 - ConsEnv.PWDS_HEAD_SIZE;
            }
        }

        // 公共属性
        if (ls_ItemList == null)
        {
            return null;
        }
        return ls_ItemList.get(row);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
     */
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }

    /**
     * 是否使用临时口令名称
     *
     * @return
     */
    public boolean isInterim()
    {
        return interim;
    }

    /**
     * @param interim
     */
    public void setInterim(boolean interim)
    {
        this.interim = interim;
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
     * @param modified
     */
    public void setModified(boolean modified)
    {
        this.modified = modified;
    }

    /**
     * 读取指定索引的密码数据
     * 
     * @param keysHash
     */
    public void loadData(String keysHash) throws Exception
    {
        keys.setDefault();
        keys.setP30F0103(keysHash);
        keys.setP30F0104(UserMdl.getUserId());
        DBA3000.readPwdsData(keys);
        deCrypt(keys, ls_ItemList);
        fireTableDataChanged();
    }

    /**
     * 是否要更新原有数据
     * 
     * @param histBack
     * @throws Exception
     */
    public void saveData(boolean histBack, boolean repaint) throws Exception
    {
        keys.setP30F0104(UserMdl.getUserId());
        keys.setHistBack(histBack);
        enCrypt(keys, ls_ItemList);
        DBA3000.savePwdsData(keys);
        clear();
        if (repaint)
        {
            fireTableDataChanged();
        }
    }

    /**
     * 向导初始化
     * @return
     */
    public Item initGuid()
    {
        Guid guid = new Guid();
        guid.setTime(new java.sql.Timestamp(System.currentTimeMillis()));
        ls_ItemList.add(guid);
        fireTableDataChanged();
        return guid;
    }

    /**
     * 
     */
    public void initMeta()
    {
        // 关键搜索
        ls_ItemList.add(new Meta());
        // 徽标
        ls_ItemList.add(new Logo());
        // 过时提醒
        ls_ItemList.add(new Note());
        fireTableDataChanged();
    }

    /**
     * @param index
     * @return
     */
    public IEditItem getItemAt(int index)
    {
        return ls_ItemList.get(index);
    }

    /**
     *
     */
    public void clear()
    {
        ls_ItemList.clear();
        keys.setDefault();
        modified = false;
    }

    /**
     * 添加指定类别的数据
     * 
     * @param type
     */
    public Item wAppend(int indx, int type)
    {
        return wAppend(indx, new Item(type));
    }

    /**
     * @param pi
     */
    public Item wAppend(int indx, Item item)
    {
        ls_ItemList.add(indx, item);
        fireTableDataChanged();
        return item;
    }

    /**
     * @param pi
     */
    public Item wAppend(Item item)
    {
        ls_ItemList.add(item);
        fireTableDataChanged();
        return item;
    }

    /**
     * 初始化指定类型的数据
     */
    public void wAppend(String typeHash)
    {
        DBA3000.selectTpltData(typeHash, ls_ItemList);
        fireTableDataChanged();
    }

    /**
     * 查找特定类别且具有特定附加属性的字段
     * @param type
     * @param args
     */
    public int wSelect(int type, int args)
    {
        int t = (type | args);
        int n = 0;
        int l = 0;
        for (int i = 0, j = ls_ItemList.size(); i < j; i += 1)
        {
            if (ls_ItemList.get(i).getType() == t)
            {
                l = i;
                n += 1;
            }
        }
        return n == 1 ? l : -1;
    }

    /**
     * 
     * @param type
     * @return
     */
    public List<I1S2> wSelect(int type)
    {
        List<I1S2> list = new ArrayList<I1S2>();
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

    public void wUpdate()
    {
        fireTableDataChanged();
    }

    public void wUpdate(int indx, Item tplt)
    {
        ls_ItemList.set(indx, tplt);
        fireTableDataChanged();
    }

    public void wRemove(int indx)
    {
        ls_ItemList.remove(indx);
        fireTableDataChanged();
        modified = true;
    }

    public void wRemove(IEditItem item)
    {
        ls_ItemList.remove(item);
        fireTableDataChanged();
        modified = true;
    }

    public int wImport(ArrayList<ArrayList<String>> data, String kindHash) throws Exception
    {
        int size = 0;
        int indx = 0;
        Item tplt;
        String text;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(ConsEnv.VIEW_DATE);
        for (ArrayList<String> temp : data)
        {
            switch ((temp.size() - 5) % 3)
            {
                case 2:
                    if (Util.isValidate(temp.get(temp.size() - 1)))
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
            keys.setDefault();
            ls_ItemList.clear();

            // Guid
            tplt = new Item();
            tplt.setType(ConsDat.INDX_GUID);
            text = temp.get(indx++);
            tplt.setName(sdf.format(Util.stringToDate(text, '-', ':', ' ').getTime()));
            tplt.setData(ConsDat.HASH_TPLT);
            ls_ItemList.add(tplt);

            // Meta
            tplt = new Item();
            tplt.setType(ConsDat.INDX_META);
            text = temp.get(indx++);
            tplt.setName(text);
            keys.setP30F0107(text);
            text = temp.get(indx++);
            tplt.setData(text);
            keys.setP30F0108(text);
            ls_ItemList.add(tplt);

            // Past
            tplt = new Item();
            tplt.setType(ConsDat.INDX_NOTE);
            text = temp.get(indx++);
            tplt.setData(text);
            keys.setP30F010A(new java.sql.Timestamp(Util.stringToDate(text, '-', ':', ' ').getTimeInMillis()));
            text = temp.get(indx++);
            tplt.setName(text);
            keys.setP30F010C(text);
            ls_ItemList.add(tplt);

            while (indx < temp.size())
            {
                tplt = new Item();
                tplt.setType(Integer.parseInt(temp.get(indx++)));
                tplt.setName(temp.get(indx++));
                tplt.setData(temp.get(indx++));
                ls_ItemList.add(tplt);
            }

            keys.setP30F0102(ConsDat.PWDS_STAT_1);
            keys.setP30F0103(Hash.hash(false));
            keys.setP30F0107(kindHash);
            keys.setP30F010A(new java.sql.Timestamp(System.currentTimeMillis()));
            enCrypt(keys, ls_ItemList);
            DBA3000.savePwdsData(keys);
            size += 1;
            Thread.sleep(200);
        }
        return size;
    }

    public int wExport(ArrayList<ArrayList<String>> data, String kindHash)
    {
        List<Keys> dataList = new ArrayList<Keys>();
        DBA3000.readKeysList(kindHash, dataList);
        if (dataList == null || dataList.size() < 1)
        {
            return 0;
        }

        int size = 0;
        ArrayList<String> temp;
        int indx;
        IEditItem tplt;

        for (Keys item : dataList)
        {
            indx = 0;
            temp = new ArrayList<String>();
            try
            {
                clear();
                loadData(item.getP30F0103());
            }
            catch (Exception exp)
            {
                Logs.exception(exp);
                continue;
            }

            // Guid
            tplt = ls_ItemList.get(indx++);
            temp.add(tplt.getName());

            // Meta
            tplt = ls_ItemList.get(indx++);
            temp.add(tplt.getName());
            temp.add(tplt.getData());
            ls_ItemList.add(tplt);

            // Past
            tplt = ls_ItemList.get(indx++);
            temp.add(tplt.getData());
            temp.add(tplt.getName());

            while (indx < ls_ItemList.size())
            {
                tplt = ls_ItemList.get(indx++);
                temp.add("" + tplt.getType());
                temp.add(tplt.getName());
                temp.add(tplt.getData());
            }

            size += 1;
            data.add(temp);
        }
        return size;
    }

    /**
     * @param row
     * @param to
     */
    public void wMoveto(int row, int to)
    {
        if (row == to)
        {
            return;
        }

        IEditItem p = ls_ItemList.remove(row);
        ls_ItemList.add(to, p);
    }

    /**
     * 数据解密处理
     * 
     * @param dba
     */
    public final void deCrypt(Keys keys, List<IEditItem> list) throws Exception
    {
        // 查询数据是否为空
        Pwds pwds = keys.getPassword();
        pwds.deCript(UserMdl.getDCipher(), UserMdl.getSec().getMask());
        StringBuffer text = pwds.getP30F0203();
        Logs.log(text.toString());
        if (text.length() < 16)
        {
            return;
        }

        // Guid
        Guid guid = new Guid();
        guid.setData(keys.getP30F0105());
        guid.setTime(keys.getP30F0106());
        guid.deCodeSpec(keys.getP30F010C().substring(1) + ";", ";");
        list.add(guid);

        // Meta
        Meta meta = new Meta();
        meta.setName(keys.getP30F0107());
        meta.setData(keys.getP30F0108());
        list.add(meta);

        // Logo
        Logo logo = new Logo();
        logo.setName(keys.getP30F0109());
        list.add(logo);

        // Note
        Note note = new Note();
        note.setTime(keys.getP30F010A());
        note.setData(keys.getP30F010B());
        list.add(note);

        // 处理每一个数据
        StringTokenizer st = new StringTokenizer(text.toString(), ConsDat.SP_SQL_EE);
        String name;
        String data;
        String spec;
        int dn;
        int dd;
        int ds;
        int type;
        String t;
        Item item;
        while (st.hasMoreTokens())
        {
            t = st.nextToken() + ConsDat.SP_SQL_KV;
            dn = t.indexOf(ConsDat.SP_SQL_KV);
            dd = t.indexOf(ConsDat.SP_SQL_KV, dn + 1);
            ds = t.indexOf(ConsDat.SP_SQL_KV, dd + 1);

            type = Integer.parseInt(t.substring(0, dn));
            name = t.substring(dn + 1, dd);
            data = t.substring(dd + 1, ds);
            spec = t.substring(ds + 1, t.length());
            item = new Item(type, name, data);
            if (spec.length() > 0)
            {
                item.deCodeSpec(spec, ConsDat.SP_SQL_KV);
            }
            list.add(item);
        }
    }

    /**
     * 数据加密处理
     * 
     * @param dba
     */
    public final void enCrypt(Keys keys, List<IEditItem> list) throws Exception
    {
        Pwds pwds = keys.getPassword();
        StringBuffer text = pwds.getP30F0203();
        text.delete(0, text.length());

        // Guid
        Guid guid = (Guid) list.get(ConsEnv.PWDS_HEAD_GUID);
        keys.setP30F0105(guid.getData());
        keys.setP30F0106(guid.getTime());
        keys.setP30F010C(guid.enCodeSpec(";"));

        // Meta
        Meta meta = (Meta) list.get(ConsEnv.PWDS_HEAD_META);
        keys.setP30F0107(interim ? meta.getName() + keys.getP30F0106() : meta.getName());
        keys.setP30F0108(meta.getData());

        // Logo
        Logo logo = (Logo) list.get(ConsEnv.PWDS_HEAD_LOGO);
        keys.setP30F0109(logo.getName());

        // Note
        Note note = (Note) list.get(ConsEnv.PWDS_HEAD_NOTE);
        keys.setP30F010A(note.getTime());
        keys.setP30F010B(note.getData());

        // 字符串拼接
        IEditItem item;
        for (int i = ConsEnv.PWDS_HEAD_SIZE, j = list.size(); i < j; i += 1)
        {
            item = list.get(i);
            text.append(item.getType());
            text.append(ConsDat.SP_SQL_KV);
            text.append(item.getName());
            text.append(ConsDat.SP_SQL_KV);
            text.append(item.getData());
            text.append(item.enCodeSpec(ConsDat.SP_SQL_KV));
            text.append(ConsDat.SP_SQL_EE);
        }

        pwds.enCrypt(UserMdl.getECipher(), UserMdl.getSec().getMask());
    }

    public boolean isUpdate()
    {
        return Util.isValidateHash(keys.getP30F0103());
    }

    public void setStatus(int status)
    {
        keys.setP30F0102(status);
        modified = true;
    }
}
